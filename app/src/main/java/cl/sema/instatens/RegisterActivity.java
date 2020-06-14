package cl.sema.instatens;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cl.sema.instatens.DAO.UsuarioDAO;
import cl.sema.instatens.DTO.Usuario;

public class RegisterActivity extends AppCompatActivity {

    Button register, cancel;
    TextView nombre, apellidoPaterno, apellidoMaterno, password, mail, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();

                nombre = findViewById(R.id.nombreTxt);
                apellidoPaterno = findViewById(R.id.apellidoPaternoTxt);
                apellidoMaterno = findViewById(R.id.apellidoMaternoTxt);
                password = findViewById(R.id.passwordTxt);
//                mail = findViewById(R.id.mailTxt);
//                telefono = findViewById(R.id.telefonoTxt);

                usuario.setNombre(nombre.getText().toString());
                usuario.setApellidoPaterno(apellidoPaterno.getText().toString());
                usuario.setAppellidoMaterno(apellidoMaterno.getText().toString());
                usuario.setPassword(password.getText().toString());
                usuario.setMail(mail.getText().toString());
                usuario.setTelefono(Integer.parseInt(telefono.getText().toString()));

                new UsuarioDAO().addUsuario(usuario);

                System.out.println(usuario.toString());
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
}
