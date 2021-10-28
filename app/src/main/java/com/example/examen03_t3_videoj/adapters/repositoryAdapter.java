package com.example.examen03_t3_videoj.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen03_t3_videoj.R;

import java.util.List;

public class repositoryAdapter extends RecyclerView.Adapter<repositoryAdapter.NameViewHolder> {

    private List<String> data;

    public repositoryAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public NameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_name,parent,false);

        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NameViewHolder holder, int position) {
        TextView tv = holder.itemView.findViewById(R.id.tvNames);
        String value = data.get(position);

        tv.setText(value);

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
