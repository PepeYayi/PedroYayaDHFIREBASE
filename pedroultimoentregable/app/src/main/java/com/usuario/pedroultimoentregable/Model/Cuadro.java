package com.usuario.pedroultimoentregable.Model;

/**
 * Created by DH on 30/5/2018.
 */

public class Cuadro {

    private String image;
    private String name;
    private String artistId;

    public Cuadro(String image, String name, String artistId) {
        this.image = image;
        this.name = name;
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
