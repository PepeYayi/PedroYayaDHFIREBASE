package com.usuario.pedroultimoentregable.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.usuario.pedroultimoentregable.R;
import com.usuario.pedroultimoentregable.Model.Cuadro;

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
        private TextView imagen;
        private TextView titulo;





        public ViewHolderCuadros(View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagenCelda);
            titulo = itemView.findViewById(R.id.tituloCelda);


            imagen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    notificable.abrirDetalleCuadro(listaDeCuadros,getAdapterPosition());
                }
            });

        }



        public void setearDatos(Cuadro cuadro){
            imagen.setText(cuadro.getImage());
            titulo.setText(cuadro.getName());

        }
    }


    public interface Notificable{
        void abrirDetalleCuadro(List<Cuadro> listaDeCuadros, Integer posicionCuadro);
    }



    public void cargarCuadros(List<Cuadro> listaDeCuadrosACargar){
        listaDeCuadros.addAll(listaDeCuadrosACargar);
        notifyDataSetChanged();
    }


}
