package com.usuario.pedroultimoentregable.View;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.usuario.pedroultimoentregable.R;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.usuario.pedroultimoentregable.DAO.DAOfirebase;
import com.usuario.pedroultimoentregable.Model.Artista;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalle extends Fragment {


    public static final String CUADRO = "ID_CUADRO";
    private static final String ARTISTA = "ID_ARTISTA";


    private ImageView imagenDetalle;
    private TextView nameArtistDetalle;
    private TextView namePaintingDetalle;
    private TextView nacionalidadDetalle;
    private TextView influenciaDetalle;
    private Context context;
    private AdapterCuadros adapterCuadros;
    private List<Artista> listaDeArtistas = new ArrayList<>();
    private Cuadro cuadro;


    private FirebaseStorage firebaseStorage;


    public FragmentDetalle() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();;
        StorageReference reference =  firebaseStorage.getReference();

        imagenDetalle = view.findViewById(R.id.imagenDetalle);
        namePaintingDetalle = view.findViewById(R.id.namePaintingDetalle);
        nameArtistDetalle = view.findViewById(R.id.nameArtistDetalle);
        nacionalidadDetalle = view.findViewById(R.id.nacionalidadDetalle);
        influenciaDetalle = view.findViewById(R.id.influenciaDetalle);

        Bundle bundle = getArguments();
        cuadro = (Cuadro) bundle.getSerializable(CUADRO);



            //SETEO NOMBRE DE PINTURA
            namePaintingDetalle.setText(cuadro.getNamePainting());

            //SETEO IMAGEN DE PINTIRA
            Glide.with(getActivity())
                    .using(new FirebaseImageLoader())
                    .load(reference.child(cuadro.getImage()))
                    .centerCrop()
                    .into(imagenDetalle);


        DAOfirebase daoInternet = new DAOfirebase();


        daoInternet.leerDatabase(new ResultListener<List<Artista>>() {
            @Override
            public void finish(List<Artista> resultado) {
                listaDeArtistas.addAll(resultado);
                // RECORRER LISTA DE ARTISTAS Y SETEAR NOMBRE DE ARTISTA, NACIONALIDAD E INFLUENCIA

                for (Artista artista: listaDeArtistas) {
                    if (cuadro.getArtistId().toString().equals(artista.getArtistId())){
                        nameArtistDetalle.setText(artista.getName());
                        nacionalidadDetalle.setText(artista.getNationality());
                        influenciaDetalle.setText(artista.getInfluenced_by());
                    }
                }
            }
        });






        return view;
    }

    public static FragmentDetalle fabricaFragmentCuadros(Cuadro unCuadro) {

        FragmentDetalle fragmentDetalle = new FragmentDetalle();
        Bundle bundle = new Bundle();
        bundle.putSerializable(CUADRO, unCuadro);
        fragmentDetalle.setArguments(bundle);
        return fragmentDetalle;
    }



}
