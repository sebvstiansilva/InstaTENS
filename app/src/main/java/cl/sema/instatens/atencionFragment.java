package cl.sema.instatens;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import cl.sema.instatens.DTO.Familiar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link atencionFragment} factory method to
 * create an instance of this fragment.
 */
public class atencionFragment extends Fragment {

    // Widgets
    Spinner nombreAtencionSp, direccionAtencionSp, tensAtencionSp;
    Button solicitarTensBtn;

    final ArrayList<String> arrayListT = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void getFamiliares(String URL) {
        final ArrayList<String> arrayList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject familiar = array.getJSONObject(i);
                                int id = familiar.getInt("idFamiliar");
                                String nombre = familiar.getString("nombre");
                                String apellidoPaterno = familiar.getString("apellidoPaterno");
                                int idUsuario = familiar.getInt("idUsuario");
                                String familiar1 = nombre.toString() + " " + apellidoPaterno.toString();
                                arrayList.add(familiar1);
                            }
                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrayList);
                            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                            nombreAtencionSp.setAdapter(arrayAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    private void getDirecciones(String URL) {
        final ArrayList<String> arrayList = new ArrayList<>();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject direccion = array.getJSONObject(i);
                        int id = direccion.getInt("idDireccion");
                        String calle = direccion.getString("calle");
                        int numero = direccion.getInt("numero");
                        int idUsuario = direccion.getInt("idUsuario");
                        String direccion1 = calle.toString() + " " + numero;
                        arrayList.add(direccion1);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrayList);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    direccionAtencionSp.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    private void getTens(String URL) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject tens = array.getJSONObject(i);
                        String rut = tens.getString("rut");
                        String nombre = tens.getString("nombre");
                        String apellidoPaterno = tens.getString("apellidoPaterno");
                        String tens1 = nombre + " " + apellidoPaterno;
                        arrayListT.add(tens1);
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, arrayListT);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    tensAtencionSp.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atencion, container, false);
        nombreAtencionSp = view.findViewById(R.id.nombreAtencionSp);
        getFamiliares("http://192.168.0.15/instatens/familiar/getFamiliares.php");
        direccionAtencionSp = view.findViewById(R.id.direccionAtencionSp);
        getDirecciones("http://192.168.0.15/instatens/direccion/getDirecciones.php");
        tensAtencionSp = view.findViewById(R.id.tensAtencionSp);
        getTens("http://192.168.0.15/instatens/tens/getTens.php");
        solicitarTensBtn = view.findViewById(R.id.solicitarTensBtn);
        solicitarTensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarTens();
            }
        });

        return view;
    }

    private void solicitarTens() {
        Intent intent = new Intent(getContext(), SeleccionActivity.class);
        startActivity(intent);
        Toast.makeText(getContext(), "El TENS " + arrayListT.get(0) + " se pondra en contacto contigo.", Toast.LENGTH_SHORT).show();
    }


}