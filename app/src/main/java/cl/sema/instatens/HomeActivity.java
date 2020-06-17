package cl.sema.instatens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    Dialog agregarFamiliar;
    Button nuevaAtencionBtn, agregarFamiliarBtn;
    Button cancelarBtn, cancelarFamiliarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new homeFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.homeFragment:
                            selectedFragment = new homeFragment();
                            break;
                        case R.id.atencionFragment:
                            selectedFragment = new atencionFragment();
                            break;
                        case R.id.profileFragment:
                            selectedFragment = new profileFragment();
                            break;
                    }
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();
                    return true;
                }
            };


    private void showDialogAgregarFamiliar() {
        agregarFamiliar.setContentView(R.layout.layout_nuevo_familiar);
        cancelarFamiliarBtn = agregarFamiliar.findViewById(R.id.cancelarFamiliarBtn);
        cancelarFamiliarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarFamiliar.dismiss();
            }
        });
        agregarFamiliar.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(150, 0, 0, 0)));
        agregarFamiliar.show();
    }

}