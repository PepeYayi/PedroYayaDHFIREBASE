package com.usuario.pedroultimoentregable.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
import com.usuario.pedroultimoentregable.Model.Cuadro;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AdapterCuadros extends RecyclerView.Adapter {

    private List<Cuadro> listaDeCuadros;
    private Notificable notificable;
    private Context context;


    public AdapterCuadros( Notificable notificable) {
        this.listaDeCuadros = new ArrayList<>();
        this.notificable = notificable;
    }

    public void setListaDeCuadros(List<Cuadro> listaDeCuadros) {
        this.listaDeCuadros = listaDeCuadros;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewCelda = layoutInflater.inflate(R.layout.celdarecycler, parent,false);
        ViewHolderCuadros viewHolderCuadros = new ViewHolderCuadros(viewCelda);




        return viewHolderCuadros;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Cuadro cuadro = listaDeCuadros.get(position);
        ViewHolderCuadros viewHolderCuadros = (ViewHolderCuadros) holder;
        viewHolderCuadros.setearDatos(cuadro);
    }

    @Override
    public int getItemCount() {
        return listaDeCuadros.size();
    }


    private class ViewHolderCuadros extends RecyclerView.ViewHolder {
        private ImageView imagen;
        private TextView nombreObra;
        private TextView nombreArtista;

        private FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();;
        private StorageReference reference =  firebaseStorage.getReference();







        public ViewHolderCuadros(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenCelda);
            nombreObra = itemView.findViewById(R.id.nombreObra);
            nombreArtista = itemView.findViewById(R.id.nombreArtista);




            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notificable.abrirDetalleCuadro(listaDeCuadros,getAdapterPosition());
                }
            });

        }



        public void setearDatos(Cuadro cuadro){


            nombreObra.setText(cuadro.getNamePainting());
            nombreArtista.setText(cuadro.getNameArtist());
            Glide.with(context)
                    .using(new FirebaseImageLoader())
                    .load(reference.child(cuadro.getImage()))
                    .centerCrop()
                    .into(imagen);


        }
    }


    public interface Notificable{
        void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro);
    }





}
