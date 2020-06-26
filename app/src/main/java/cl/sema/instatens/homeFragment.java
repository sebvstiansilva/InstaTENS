package cl.sema.instatens;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link homeFragment} factory method to
 * create an instance of this fragment.
 */
public class homeFragment extends Fragment {

    // Dialogs
    Dialog dialog;

    // Widgets
    Button addNewFamiliarBtn, closeFamiliarBtn, aceptarFamiliarBtn,
            addNewDireccionBtn, closeDireccionBtn, aceptarDireccionBtn;
    EditText nombreEt, apellidoPaternoEt, apellidoMaternoEt, fechaNacimientoEt,
            calleEt, numeroEt, pisoEt;
    Spinner sexoSp, regionSp, comunaSp;
    DatePickerDialog datePicker;
    TextView title;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        String correo = getFromSharedPreferences("correo");
        Toast.makeText(getContext(), "Hola " + correo, Toast.LENGTH_SHORT).show();
        addNewFamiliarBtn = view
                .findViewById(R.id.addNewFamiliarBtn);
        addNewFamiliarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNewFamiliar();
            }
        });

        addNewDireccionBtn = view
                .findViewById(R.id.addNewDireccionBtn);
        addNewDireccionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogNewDireccion();
            }
        });

        return view;
    }

    private String getFromSharedPreferences(String key) {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("saveLogin", Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    private void showDialogNewDireccion() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R
                .layout.layout_nueva_direccion);
        aceptarDireccionBtn = dialog.findViewById(R.id.aceptarDireccionBtn);
        regionSp = dialog.findViewById(R.id.regionSp);
        comunaSp = dialog.findViewById(R.id.comunaSp);
        calleEt = dialog.findViewById(R.id.calleEt);
        numeroEt = dialog.findViewById(R.id.numeroEt);
        pisoEt = dialog.findViewById(R.id.pisoEt);

        aceptarDireccionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!regionSp.getSelectedItem().toString().isEmpty()) {
                    agregarNuevaDireccion("http://192.168.0.15/instatens/direccion/nuevaDireccion.php");
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        closeDireccionBtn = dialog
                .findViewById(R.id.closeDireccionBtn);
        closeDireccionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void agregarNuevaDireccion(String URL) {
        final String region = regionSp.getSelectedItem().toString();
        final String comuna = comunaSp.getSelectedItem().toString();
        final String calle = calleEt.getText().toString().trim();
        final String numero = numeroEt.getText().toString().trim();
        final String piso = numeroEt.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Toast.makeText(getContext(), "Se ha agregado un nueva dirección.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Verifique los campos y vuelva a intentar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("region", region);
                params.put("comuna", comuna);
                params.put("calle", calle);
                params.put("numero", numero);
                params.put("piso", piso);
                params.put("idUsuario", "4");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    public void showDialogNewFamiliar() {
        dialog = new Dialog(getContext());
        dialog.setContentView(R.layout
                .layout_nuevo_familiar);
        aceptarFamiliarBtn = dialog.findViewById(R.id.agregarFamiliarBtn);
        nombreEt = dialog.findViewById(R.id.nombreF);
        apellidoPaternoEt = dialog.findViewById(R.id.apellidoPaternoF);
        apellidoMaternoEt = dialog.findViewById(R.id.apellidoMaternoF);
        sexoSp = dialog.findViewById(R.id.sexoF);
        fechaNacimientoEt = dialog.findViewById(R.id.fechaNacimientoF);
        aceptarFamiliarBtn = dialog.findViewById(R.id.agregarFamiliarBtn);

        aceptarFamiliarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nombreEt.getText().toString().isEmpty()) {
                    agregarNuevoFamiliar("http://192.168.0.15/instatens/familiar/nuevoFamiliar.php");
                    dialog.dismiss();
                } else {
                    Toast.makeText(getContext(), "No se permiten campos vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });
        closeFamiliarBtn = dialog
                .findViewById(R.id.closeFamiliarBtn);
        closeFamiliarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void agregarNuevoFamiliar(String URL) {
        final String nombre = nombreEt.getText().toString().trim();
        final String apellidoPaterno = apellidoPaternoEt.getText().toString().trim();
        final String apellidoMaterno = apellidoMaternoEt.getText().toString().trim();
        final String sexo = sexoSp.getSelectedItem().toString();
        final String fechaNacimiento = fechaNacimientoEt.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(StringRequest.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()){
                    Toast.makeText(getContext(), "Se ha agregado un nuevo familiar.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Verifique los campos y vuelva a intentar", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("nombre", nombre);
                params.put("apellidoPaterno", apellidoPaterno);
                params.put("apellidoMaterno", apellidoMaterno);
                params.put("sexo", sexo);
                params.put("fechaNacimiento", fechaNacimiento);
                params.put("idUsuario", "4");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

}