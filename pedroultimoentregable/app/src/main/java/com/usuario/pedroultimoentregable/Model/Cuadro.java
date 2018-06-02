package com.usuario.pedroultimoentregable.Model;

import java.io.Serializable;

/**
 * Created by DH on 30/5/2018.
 */

public class Cuadro implements Serializable {

    private String image;
    private String name;
    private String artistId;

    public Cuadro(String image, String name, String artistId) {
        this.image = image;
        this.name = name;
        this.artistId = artistId;
    }

    public Cuadro() {
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getArtistId() {
        return artistId;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "image ='" + image + '\'' +
                ", name ='" + name + '\'' +
                ", Artist Id =" + artistId +
                '}';
    }
}
