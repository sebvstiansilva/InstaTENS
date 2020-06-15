package cl.sema.instatens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    Dialog nuevaAtencion;
    Button nuevaAtencionBtn, cancelarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nuevaAtencion = new Dialog(this);

        nuevaAtencionBtn = findViewById(R.id.nuevaAtencionSBtn);
        nuevaAtencionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNuevaAtencion();
            }
        });

    }

    public void showDialogNuevaAtencion() {
        nuevaAtencion.setContentView(R.layout.layout_nueva_atencion);
        cancelarBtn = nuevaAtencion.findViewById(R.id.cancelarBtn);

        cancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevaAtencion.dismiss();
            }
        });
        nuevaAtencion.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(150,0,0,0)));
        nuevaAtencion.show();
    }

}