package com.usuario.pedroultimoentregable.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by DH on 30/5/2018.
 */

public class Cuadro implements Serializable {

    // crear clase artista
    private String image;
    @SerializedName("name")
    private String namePainting;
    private String artistId;
    @SerializedName("Influenced_by")
    private String Influenced_by;
    private String nameArtist;
    private String nationality;


    public Cuadro(String image, String namePainting, String artistId, String influenced_by, String nameArtist, String nationality) {
        this.image = image;
        this.namePainting = namePainting;
        this.artistId = artistId;
        Influenced_by = influenced_by;
        this.nameArtist = nameArtist;
        this.nationality = nationality;
    }

    public Cuadro() {
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

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getInfluenced_by() {
        return Influenced_by;
    }

    public void setInfluenced_by(String influenced_by) {
        Influenced_by = influenced_by;
    }

    public String getNameArtist() {
        return nameArtist;
    }

    public void setNameArtist(String nameArtist) {
        this.nameArtist = nameArtist;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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
