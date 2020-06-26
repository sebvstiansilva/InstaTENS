package cl.sema.instatens;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cl.sema.instatens.DTO.Direccion;

public class RegisterActivity extends AppCompatActivity {

    Button register, cancel;
    EditText nombreEt, apellidoPaternoEt, apellidoMaternoEt, passwordEt, fechaNacimientoEt, correoEt, telefonoEt;
    Spinner sexoSp;
    DatePickerDialog picker;
    private static List<Direccion> direccionList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombreEt = findViewById(R.id.nombreTxt);
        apellidoPaternoEt = findViewById(R.id.apellidoPaternoTxt);
        apellidoMaternoEt = findViewById(R.id.apellidoMaternoTxt);
        passwordEt = findViewById(R.id.passwordRegister);
        sexoSp = findViewById(R.id.sexo);
        fechaNacimientoEt = findViewById(R.id.fechaNacimiento);
        fechaNacimientoEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);
                picker = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                                fechaNacimientoEt.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        telefonoEt = findViewById(R.id.telefonoTxt);
        correoEt = findViewById(R.id.correoRegister);



        register = findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String nombre = nombreEt.getText().toString();
                final String apellidoPaterno = apellidoPaternoEt.getText().toString();
                final String apellidoMaterno = apellidoMaternoEt.getText().toString();
                final String password = passwordEt.getText().toString();
                final String sexo = sexoSp.getSelectedItem().toString();
                final String fechaNacimiento = fechaNacimientoEt.getText().toString();
                final String telefono = telefonoEt.getText().toString();
                final String correo = correoEt.getText().toString();

                if (!nombre.isEmpty()
                        && !password.isEmpty()
                        && !apellidoPaterno.isEmpty()
                        && !apellidoMaterno.isEmpty()
                        && !sexo.isEmpty()
                        && !fechaNacimiento.isEmpty()
                        && !telefono.isEmpty()
                        && !correo.isEmpty()) {
                    registrarUsuario("http://192.168.0.15/instatens/register.php");
                } else {
                    Toast.makeText(getApplicationContext(), "No se permiten campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel = findViewById(R.id.cancelBtn);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void registrarUsuario(String URL) {
        final String nombre = nombreEt.getText().toString();
        final String apellidoPaterno = apellidoPaternoEt.getText().toString();
        final String apellidoMaterno = apellidoMaternoEt.getText().toString();
        final String password = passwordEt.getText().toString();
        final String sexo = sexoSp.getSelectedItem().toString();
        final String fechaNacimiento = fechaNacimientoEt.getText().toString();
        final String telefono = telefonoEt.getText().toString();
        final String correo = correoEt.getText().toString();
        final String passH = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(RegisterActivity.this, "Se ha registrado su cuenta.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Verifique los campos y vuelva a intentar.", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("apellidoPaterno", apellidoPaterno);
                params.put("apellidoMaterno", apellidoMaterno);
                params.put("password", passH);
                params.put("sexo", sexo);
                params.put("fechaNacimiento", fechaNacimiento);
                params.put("telefono", telefono);
                params.put("correo", correo);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
