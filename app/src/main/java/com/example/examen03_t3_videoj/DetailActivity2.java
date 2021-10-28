package com.example.examen03_t3_videoj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.examen03_t3_videoj.entities.Repository;
import com.example.examen03_t3_videoj.services.UpnService;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Log.i("MAIN_APP","Iniciando registro de pokemon");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UpnService service = retrofit.create(UpnService.class);

        Repository repository = new Repository();
        /*
        repository.setNombre("Pikachu");
        repository.setTipo("Eléctrico");
        repository.setUrlImagen("https://cdn.pixabay.com/photo/2020/08/29/16/07/pikachu-5527375_960_720.jpg");
        repository.setLatitude(-8.101673);
        repository.setLongitude(-79.047755);
*/

        service.createPokemon(repository).enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                Log.i("MAIN_APP", new Gson().toJson(response.body()));
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {
                Log.e("MAIN_APP", "No se pudo comunicar");
            }
        });
    }
}