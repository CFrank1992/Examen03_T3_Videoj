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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                Intent intent3 = new Intent(getApplicationContext(), DetailActivity3.class);
                startActivity(intent3);
            }
        });

        RecyclerView rv = findViewById(R.id.rvDataPokemon);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        List<String> datos = Arrays.asList("dato1","dato2","dato3");

        repositoryAdapter adapter = new repositoryAdapter(datos);

        rv.setAdapter(adapter);



    }
}