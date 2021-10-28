package com.example.examen03_t3_videoj.services;

import com.example.examen03_t3_videoj.entities.Repository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UpnService {

    @GET("pokemons/N00109334")
    Call<List<Repository>> allRepos();

    @POST("pokemons/N00109334/crear")
    Call<Repository> createPokemon(@Body Repository repository);
}
