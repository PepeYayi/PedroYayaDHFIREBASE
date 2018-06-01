package com.usuario.pedroultimoentregable.Model;

import java.util.List;

/**
 * Created by DH on 30/5/2018.
 */

public class ContenedorDeCuadros {

    private List<Cuadro> paints;

    public ContenedorDeCuadros(List<Cuadro> paints) {
        this.paints = paints;
    }

    public List<Cuadro> getPaints() {
        return paints;
    }

    public void setPaints(List<Cuadro> paints) {
        this.paints = paints;
    }

    @Override
    public String toString() {
        return "ClaseContenedora{" +
                "paints=" + paints +
                '}';
    }
}
