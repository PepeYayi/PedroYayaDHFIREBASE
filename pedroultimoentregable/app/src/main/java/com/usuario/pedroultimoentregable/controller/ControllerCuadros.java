package com.usuario.pedroultimoentregable.controller;

import com.usuario.pedroultimoentregable.DAO.DAOinternet;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;

import java.util.List;

public class ControllerCuadros {

    public void obtenerCuadros(final ResultListener<List<Cuadro>> escuchadorDeLaVista){

        DAOinternet daoInternet = new DAOinternet();

        daoInternet.obtenerCuadrosDeInternetAsincronico(new ResultListener<List<Cuadro>>() {
            @Override
            public void finish(List<Cuadro> resultado) {
                escuchadorDeLaVista.finish(resultado);
            }
        });

    }



}
