package com.usuario.pedroultimoentregable.View;



import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


import com.example.usuario.pedroultimoentregable.R;
import com.facebook.CallbackManager;

import com.google.firebase.auth.FirebaseAuth;

import com.usuario.pedroultimoentregable.DAO.DAOfirebase;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterCuadros.Notificable {





    private FirebaseAuth.AuthStateListener mAuthListener;
    private CallbackManager mCallbackManager;
    private Button botonLoginActivity;
    private Toolbar toolbar;
    private AdapterCuadros adapterCuadros;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterCuadros = new AdapterCuadros(new AdapterCuadros.Notificable() {
            @Override
            public void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro) {
                abrirDetalleCuadro(listaDeCuadros,posicionCuadro);
            }
        });
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
            startActivity(intent);

        }

        /*
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

*/

        DAOfirebase daoInternet = new DAOfirebase();


        Cuadro cuadro1 = new Cuadro("cuadro1", "alo","asasdas", "adsasd", "asdsad", "asdasd");
        Cuadro cuadro2 = new Cuadro("cuadro1", "alo","asasdas", "adsasd", "asdsad", "asdasd");

        daoInternet.escribirEnLaBase(cuadro1);
        daoInternet.escribirEnLaBase(cuadro2);

        daoInternet.leerDatabase(new ResultListener<List<Cuadro>>() {
            @Override
            public void finish(List<Cuadro> resultado) {
                adapterCuadros.setListaDeCuadros(resultado);
            }
        });





        FragmentHome fragmentHome = new FragmentHome();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerMainFragment, fragmentHome);
        fragmentTransaction.commit();




    }


    @Override
    public void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro) {
        Cuadro cuadro = listaDeCuadros.get(posicionCuadro);
        String titulo = cuadro.getNamePainting();
        String imagen = cuadro.getImage();

        Bundle bundle = new Bundle();
        bundle.putString("titulo", titulo);
        bundle.putString("descripcion", imagen);

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        fragmentDetalle.setArguments(bundle);
        // MANDAR EL OBJETO ENTERO PARA RECIBIRLO CON EL SERIALIZABLE DESDE EL FRAGMENT DETALLE
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.containerMainFragment, fragmentDetalle);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();




    }


}
