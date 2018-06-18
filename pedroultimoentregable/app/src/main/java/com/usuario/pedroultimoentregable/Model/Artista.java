package com.usuario.pedroultimoentregable.Model;

public class Artista {



        private String Influenced_by;
        private String name;
        private String nationality;
        private String artistId;

    public Artista(String influenced_by, String name, String nationality, String artistId) {

        Influenced_by = influenced_by;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
