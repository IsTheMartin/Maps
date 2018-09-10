package mx.ceti.maps;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se crea un manejador de fragmentos obtienendo el soporte que maneja esta App
        FragmentManager fm = getSupportFragmentManager();
        //Se crea una transacción entre fragmentos y en el manejador se inicia la transacción
        FragmentTransaction ft = fm.beginTransaction();
        //Se crea una variable de la clase MapFragment
        MapFragment mapFragment = new MapFragment();
        //En la transacción creada, reemplaza fragments existentes por un fragment de mapa y se
        //lanza inmediatamente.
        ft.replace(R.id.main_layout, mapFragment).commit();
    }
}
