package com.example.usuario.pedroultimoentregable;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    private AdapterCuadros adapterCuadros;
    private AdapterCuadros.Notificable notificable;



    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView recyclerViewCuadros = view.findViewById(R.id.recyclerViewPrincipal);
        recyclerViewCuadros.setHasFixedSize(true);
        recyclerViewCuadros.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        adapterCuadros = new AdapterCuadros(crearListaCuadros(), new AdapterCuadros.Notificable() {
            @Override
            public void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro) {
                notificable.abrirDetalleCuadro(listaDeCuadros, posicionCuadro);
            }
        });

        recyclerViewCuadros.setAdapter(adapterCuadros);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        notificable = (AdapterCuadros.Notificable) context;
    }


    private static List<Cuadro> crearListaCuadros() {

        List<Cuadro> listaCuadros = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));
            listaCuadros.add(new Cuadro(R.drawable.ata, "ataaa", "asdasadasdadadasdad"));


        }

        return listaCuadros;
    }

}


















