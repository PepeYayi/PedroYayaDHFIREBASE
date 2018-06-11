package com.usuario.pedroultimoentregable.DAO;

import android.content.res.AssetManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usuario.pedroultimoentregable.Model.Artista;
import com.usuario.pedroultimoentregable.Model.ContenedorDeCuadros;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by DH on 30/5/2018.
 */

public class DAOfirebase {

        private FirebaseDatabase database;
        public List<Artista> listaDeArtistasInternet = new ArrayList<>();



    public DAOfirebase() {
        database = FirebaseDatabase.getInstance();
    }

    public void escribirEnLaBase(Cuadro cuadro){

        database.getReference().child("Cuadros")
                .child(cuadro.getNamePainting())
                .setValue(cuadro);

    }

// push es solo para crear ids unicos. setValue es para escribir en la base.

 // El single es para leer una sola vez la base, y el otro es el valueeventlistener si aguien cambia algo se ejecuta.
    public void leerDatabase(final ResultListener<List<Artista>> escuchadorDeLaVista){
        database.getReference().child("artists").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot jsonArtista : dataSnapshot.getChildren()) {
                    Artista artista = jsonArtista.getValue(Artista.class);
                    listaDeArtistasInternet.add(artista);

                }
                escuchadorDeLaVista.finish(listaDeArtistasInternet);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
