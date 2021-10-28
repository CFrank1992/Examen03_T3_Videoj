package com.example.examen03_t3_videoj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.examen03_t3_videoj.adapters.repositoryAdapter;
import com.example.examen03_t3_videoj.entities.Repository;
import com.example.examen03_t3_videoj.services.UpnService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        Log.i("MAIN_APP", "Iniciando detalle 1");
        Button button3 = findViewById(R.id.detailButton);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity3.class);
                startActivity(intent);
            }
        });

        RecyclerView rv = findViewById(R.id.rvDataPokemon);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://upn.lumenes.tk/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UpnService service = retrofit.create(UpnService.class);
        service.allRepos().enqueue(new Callback<List<Repository>>() {
            @Override
            public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                Log.i("MAIN_APP",String.valueOf(response.code()));

                if(response.code() == 200) {
                    repositoryAdapter adapter = new repositoryAdapter(response.body());

                    rv.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Repository>> call, Throwable t) {
                Log.e("MAIN_APP","No hubo comunicación");
            }
        });






    }
}