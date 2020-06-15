package cl.sema.instatens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.sema.instatens.Connection.Connection;

public class MainActivity extends AppCompatActivity {

    Button login;
    TextView register;
    EditText correo, password;

    private Connection connection = new Connection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        correo = findViewById(R.id.correoLogin);
        password = findViewById(R.id.passwordLogin);

        final String correoTxt = correo.getText().toString().trim();
        final String passwordTxt = password.getText().toString();

        login = findViewById(R.id.loginBtn);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!correoTxt.isEmpty() && !passwordTxt.isEmpty()){
                    Intent goHome = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(goHome);
                    Toast.makeText(MainActivity.this, ""+passwordTxt, Toast.LENGTH_SHORT).show();
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

    protected boolean login(String correo, String password) {

        try {
            this.connection.connect();
            Connection con = this.connection.getConnection();
            String sql = "";

        } catch (Exception ex) {
            return false;
        } finally {
            this.connection.disconnect();
        }

        return true;
    }
}
