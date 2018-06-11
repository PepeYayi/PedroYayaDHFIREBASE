package com.usuario.pedroultimoentregable.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by DH on 30/5/2018.
 */

public class Cuadro implements Serializable {


    private String image;
    @SerializedName("name")
    private String namePainting;
    private Integer artistId;


    public Cuadro(String image, String namePainting, Integer artistId) {
        this.image = image;
        this.namePainting = namePainting;
        this.artistId = artistId;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNamePainting() {
        return namePainting;
    }

    public void setNamePainting(String namePainting) {
        this.namePainting = namePainting;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "image ='" + image + '\'' +
                ", name ='" + namePainting + '\'' +
                ", Artist Id =" + artistId +
                '}';
    }
}
