package cl.sema.instatens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import cl.sema.instatens.Connection.ConnectionDB;

public class MainActivity extends AppCompatActivity {

    Button register;
    EditText correoEt, passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correoEt = findViewById(R.id.correoLogin);
        passwordEt = findViewById(R.id.passwordLogin);

        getLogin();

        register = findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }


    public void OnLogin(View view) {
        final String correo = correoEt.getText().toString().trim();
        final String password = passwordEt.getText().toString().trim();
        if (!correo.isEmpty() && !password.isEmpty()) {
            validarUsuario("http://192.168.0.15/instatens/login.php");
        } else {
            Toast.makeText(getApplicationContext(), "No se permiten campos vacíos", Toast.LENGTH_SHORT).show();
        }

    }

    private void validarUsuario(String URL) {
        final String correo = correoEt.getText().toString().trim();
        final String password = passwordEt.getText().toString().trim();
        final String passH = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    saveLogin();
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectas.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("correo", correo);
                params.put("password", passH);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    private void saveLogin() {
        String correo = correoEt.getText().toString().trim();
        String password = passwordEt.getText().toString().trim();
        SharedPreferences sharedPreferences =
                getSharedPreferences("saveLogin", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("correo", correo);
        editor.putString("password", password);
        editor.putBoolean("log", true);
        editor.apply();
    }

    private void getLogin() {
        SharedPreferences sharedPreferences =
                getSharedPreferences("saveLogin", Context.MODE_PRIVATE);
        correoEt.setText(sharedPreferences.getString("correo", ""));
        passwordEt.setText(sharedPreferences.getString("password", ""));

    }
}
