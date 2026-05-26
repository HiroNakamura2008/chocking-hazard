package com.example.forca_integrado;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<RecycleHolder> {

    private ArrayList<Palavra> list;

    @NonNull
    @Override
    public RecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);

        return new RecycleHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleHolder holder, int position) {


    }

    @Override
    public int getItemCount() {

        return 0;

    }
}
