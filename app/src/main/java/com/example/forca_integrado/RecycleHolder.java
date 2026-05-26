package com.example.forca_integrado;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleHolder extends RecyclerView.ViewHolder {

    private TextView textWord, textCategory;

    public RecycleHolder(@NonNull View itemView) {

        super(itemView);

        textWord = itemView.findViewById(R.id.id_word);
        textCategory = itemView.findViewById(R.id.id_category);

    }
}
