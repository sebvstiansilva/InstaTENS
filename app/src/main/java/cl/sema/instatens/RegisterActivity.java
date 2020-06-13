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
    TextView rut, name, password, mail, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.registerBtn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Usuario usuario = new Usuario();

                rut = findViewById(R.id.rutTxt);
                name = findViewById(R.id.nameTxt);
                password = findViewById(R.id.passwordTxt);
                mail = findViewById(R.id.mailTxt);
                phone = findViewById(R.id.phoneTxt);

                usuario.setRut(rut.getText().toString());
                usuario.setName(name.getText().toString());
                usuario.setPassword(password.getText().toString());
                usuario.setMail(mail.getText().toString());
                usuario.setPhone(Integer.parseInt(phone.getText().toString()));

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
