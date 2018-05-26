package com.example.usuario.pedroultimoentregable;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.cert.Certificate;
import java.util.List;

public class AdapterCuadros extends RecyclerView.Adapter {

    private List<Cuadro> listaDeCuadros;
    private Notificable notificable;

    public AdapterCuadros(List<Cuadro> listaDeCuadros, Notificable notificable) {
        this.listaDeCuadros = listaDeCuadros;
        this.notificable = notificable;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
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
        private TextView titulo;
        private TextView descripcion;



        public ViewHolderCuadros(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenCelda);
            titulo = itemView.findViewById(R.id.tituloCelda);
            descripcion = itemView.findViewById(R.id.descripcionCelda);

        }

        public void setearDatos(Cuadro cuadro){
            imagen.setImageResource(cuadro.getImagen());
            titulo.setText(cuadro.getTitulo());
            descripcion.setText(cuadro.getDescripcion());
        }
    }


    public interface Notificable{
        void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro);
    }


}
