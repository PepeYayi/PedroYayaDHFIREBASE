package com.usuario.pedroultimoentregable.DAO;

import com.usuario.pedroultimoentregable.Model.ContenedorDeCuadros;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ServiceCuadro {


    @GET("/bins/x858r")
    Call<ContenedorDeCuadros> getCuadros();

}
