package cl.sema.instatens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;


import cl.sema.instatens.Connection.ConnectionDB;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView register;
    EditText correo, password;

    private ConnectionDB connection = new ConnectionDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = findViewById(R.id.correoLogin);
        password = findViewById(R.id.passwordLogin);

        login = findViewById(R.id
                .loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correoTxt = correo.getText().toString().trim();
                String passwordTxt = password.getText().toString();
                String passH = Hashing.sha256()
                        .hashString(passwordTxt, StandardCharsets.UTF_8)
                        .toString();

                boolean isLogin = login(correoTxt, passwordTxt);
                Toast.makeText(MainActivity.this, ""+ correoTxt + passwordTxt, Toast.LENGTH_SHORT).show();
                if(isLogin){
                    Intent goHome = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(goHome);
                    Toast.makeText(MainActivity.this, "Ha iniciado sesión correctamente.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Ingrese datos por favor.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        register = findViewById(R.id.textRegister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private boolean login(String correo, String password) {
       boolean result = true;

        return result;
    }
}
