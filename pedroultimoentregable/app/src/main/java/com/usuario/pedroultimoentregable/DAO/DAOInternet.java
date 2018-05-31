package com.usuario.pedroultimoentregable.DAO;

import android.content.res.AssetManager;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.usuario.pedroultimoentregable.Model.Cuadro;

/**
 * Created by DH on 30/5/2018.
 */

public class DAOInternet {

        private FirebaseDatabase database;

    public DAOInternet() {
        database = FirebaseDatabase.getInstance();
    }

    public void escribirEnLaBase(Cuadro cuadro){

        database.getReference().child("Cuadros")
                .child(cuadro.getName())
                .setValue(cuadro);
    }

// push es solo para crear ids unicos. setValue es para escribir en la base.

 // El single es para leer una sola vez la base, y el otro es el valueeventlistener si aguien cambia algo se ejecuta.
    public void leerDatabase(){
        database.getReference().child("Cuadros").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot jsonCuadro : dataSnapshot.getChildren()) {
                    jsonCuadro.getValue(Cuadro.class);
                    // preguntar como guardo esto para pasarlo a la vista.
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
