package com.usuario.pedroultimoentregable.DAO;

import android.util.Log;

import com.usuario.pedroultimoentregable.Model.ContenedorDeCuadros;
import com.usuario.pedroultimoentregable.Model.Cuadro;
import com.usuario.pedroultimoentregable.Utils.ResultListener;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DAOinternet {


    private Retrofit retrofit;
    private ServiceCuadro service;
    private static final String BASE_URL = "https://api.myjson.com";


    public DAOinternet() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = builder.client(httpClient.build()).build();

        service = retrofit.create(ServiceCuadro.class);

    }

    public void obtenerCuadrosDeInternetAsincronico(final ResultListener<List<Cuadro>> escuchadorDelControlador) {

        service.getCuadros().enqueue(new Callback<ContenedorDeCuadros>() {
            @Override
            public void onResponse(Call<ContenedorDeCuadros> call, Response<ContenedorDeCuadros> response) {

                escuchadorDelControlador.finish(response.body().getPaints());
            }

            @Override
            public void onFailure(Call<ContenedorDeCuadros> call, Throwable t) {
                Log.e("retrofit", "fallo");
            }
        });

    }

}
