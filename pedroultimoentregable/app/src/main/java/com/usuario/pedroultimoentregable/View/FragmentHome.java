package com.usuario.pedroultimoentregable.View;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.pedroultimoentregable.R;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;
import com.usuario.pedroultimoentregable.controller.ControllerCuadros;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    private AdapterCuadros adapterCuadros;
    private AdapterCuadros.Notificable notificable;
    private ControllerCuadros controllerCuadros;


    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapterCuadros = new AdapterCuadros(new AdapterCuadros.Notificable() {
            @Override
            public void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro) {
                    notificable.abrirDetalleCuadro(listaDeCuadros, posicionCuadro);            }
        });
        controllerCuadros = new ControllerCuadros();
        controllerCuadros.obtenerCuadros(new ResultListener<List<Cuadro>>() {
            @Override
            public void finish(List<Cuadro> resultado) {
                adapterCuadros.setListaDeCuadros(resultado);

            }
        });}





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerViewCuadros = view.findViewById(R.id.recyclerViewPrincipal);
        recyclerViewCuadros.setHasFixedSize(true);
        recyclerViewCuadros.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        controllerCuadros = new ControllerCuadros();

        recyclerViewCuadros.setAdapter(adapterCuadros);



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificable = (AdapterCuadros.Notificable) context;
    }





}


















