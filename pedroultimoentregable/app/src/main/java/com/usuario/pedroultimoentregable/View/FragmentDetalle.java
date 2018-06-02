package com.usuario.pedroultimoentregable.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.usuario.pedroultimoentregable.R;
import com.usuario.pedroultimoentregable.Model.Cuadro;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalle extends Fragment {


    private static final String ID_CUADRO = "ID_CUADRO";


    private ImageView imagenDetalle;
    private TextView tituloDetalle;
    private TextView descripcionDetalle;
    private Cuadro cuadro;

    public FragmentDetalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        imagenDetalle = view.findViewById(R.id.imagenDetalle);
        tituloDetalle = view.findViewById(R.id.tituloDetalle);
        descripcionDetalle = view.findViewById(R.id.descripcionDetalle);

        Bundle bundle = getArguments();



        cuadro = (Cuadro) bundle.getSerializable(ID_CUADRO);




        return view;
    }

    public static FragmentDetalle fabricaFragmentCuadros(Cuadro unCuadro) {

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ID_CUADRO, unCuadro);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }

}
