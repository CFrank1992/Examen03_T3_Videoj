package com.example.examen03_t3_videoj.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.examen03_t3_videoj.DetailActivity3;
import com.example.examen03_t3_videoj.R;
import com.example.examen03_t3_videoj.entities.Repository;

import java.util.List;

public class repositoryAdapter2 extends RecyclerView.Adapter<repositoryAdapter2.NameViewHolder> {

    private List<Repository> data;

    public repositoryAdapter2(List<Repository> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(repositoryAdapter2.NameViewHolder holder, int position) {
        TextView tvNames = holder.itemView.findViewById(R.id.tvNames);
        TextView tvType = holder.itemView.findViewById(R.id.tvType);
        Repository value = data.get(position);

        tvNames.setText(String.valueOf(value.getNombre()));
        tvType.setText(String.valueOf(value.getTipo()));
/*
        Button button3 = findViewById(R.id.detailButton);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity3.class);
                startActivity(intent);
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(View itemView) {
            super(itemView);
        }
    }

}
