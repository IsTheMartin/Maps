package mx.ceti.maps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

/**
 * A simple {@link Fragment} subclass.
 */
//Es importante que esta clase implemente la interfaz OnMapReadyCallback y su método
public class MapFragment extends Fragment implements OnMapReadyCallback{

    SupportMapFragment supportMapFragment; //Variable para vincular el Fragment con el mapa
    GoogleMap googleMap; //Variable de google map para agregar muchos componentes

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla o vincula el layout del fragmento a una variable tipo vista
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        //Se obtiene el hijo del manejador de fragmentos ubicandolo por el ID
        supportMapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        //Si no hay soporte para el fragmento de mapa
        if (supportMapFragment == null) {
            //Se crea un manejador de fragmentos y se vincula al de la aplicación
            FragmentManager fragmentManager = getFragmentManager();
            //Se crea una transacción y se inicializa la transacción el manejador de fragmentos
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            //Se genera una nueva instancia del soport de fragmento de mapa
            supportMapFragment = SupportMapFragment.newInstance();
            //Reemplazamos los fragmentos visibles por el creado previamente y lo lanzamos
            transaction.replace(R.id.map, supportMapFragment).commit();
        }
        //Obtenemos una asincronización del mapa e introducimos un escuchador cuando el mapa esté
        //listo para mostrarse
        supportMapFragment.getMapAsync(this);
        //Se retorna la vista inflada al inicio de este método
        return view;
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        //Esta variable se asigna cuando el mapa esté listo para mostrarse, podemos crear objetos
        //fuera de esta clase usando la variable googleMap
        googleMap = gMap;
        //En esta función se pueden agregar un montón de cosas.
    }
}
