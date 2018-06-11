package com.usuario.pedroultimoentregable.Model;

import com.google.gson.annotations.SerializedName;

public class Artista {


    @SerializedName("Influenced_by")
    private String Influenced_by;
    private String nameArtist;
    private String nationality;
    private String artistId;

    public Artista(String influenced_by, String nameArtist, String nationality, String artistId) {

        Influenced_by = influenced_by;
        this.nameArtist = nameArtist;
        this.nationality = nationality;
        this.artistId = artistId;
    }

    public Artista(){

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

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }
}
