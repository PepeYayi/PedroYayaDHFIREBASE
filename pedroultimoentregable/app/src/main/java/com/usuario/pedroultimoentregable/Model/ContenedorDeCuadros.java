package com.usuario.pedroultimoentregable.Model;

import java.util.List;

/**
 * Created by DH on 30/5/2018.
 */

public class ContenedorDeCuadros {

    private List<Cuadro> listaDeCuadros;

    public ContenedorDeCuadros(List<Cuadro> listaDeCuadros) {
        this.listaDeCuadros = listaDeCuadros;
    }

    @Override
    public String toString() {
        return "ClaseContenedora{" +
                "listaDeCuadros=" + listaDeCuadros +
                '}';
    }
}
