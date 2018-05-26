package com.example.usuario.pedroultimoentregable;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalle extends Fragment {

    private ImageView imagenDetalle;
    private TextView tituloDetalle;
    private TextView descripcionDetalle;


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




        return view;
    }

}
