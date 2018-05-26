package com.example.usuario.pedroultimoentregable;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        adapterCuadros = new AdapterCuadros(crearListaCuadros(), )


        return view;
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


















