package com.usuario.pedroultimoentregable.View;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.usuario.pedroultimoentregable.R;
import com.facebook.CallbackManager;

import com.google.firebase.auth.FirebaseAuth;

import com.usuario.pedroultimoentregable.Model.Cuadro;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterCuadros.Notificable {


    // METER LISTENER AL BOTON NUEVO EN MAINACT PARA IR A LA ACT LOGIN Y VER SI ANDA EL LOGIN DE FIREBASE


    private FirebaseAuth.AuthStateListener mAuthListener;
    private CallbackManager mCallbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        FragmentHome fragmentHome = new FragmentHome();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerMainFragment, fragmentHome);
        fragmentTransaction.commit();




    }


    @Override
    public void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro) {
        Cuadro cuadro = listaDeCuadros.get(posicionCuadro);
        String titulo = cuadro.getName();
        String imagen = cuadro.getImage();

        Bundle bundle = new Bundle();
        bundle.putString("titulo", titulo);
        bundle.putString("descripcion", imagen);

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        fragmentDetalle.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerMainFragment, fragmentDetalle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}
