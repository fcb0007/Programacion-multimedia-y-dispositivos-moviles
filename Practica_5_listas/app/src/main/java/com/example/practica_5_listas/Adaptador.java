package com.example.practica_5_listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adaptador  extends RecyclerView.Adapter<Adaptador.VideojuegosViewHolder> {

    private Videojuegos[] listaVideojuegos;

    public Adaptador(Videojuegos[] listaVideojuegos) {
        this.listaVideojuegos = listaVideojuegos;

    }

    @NonNull
    @Override
    public VideojuegosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videojuego_item, parent, false);
        return new VideojuegosViewHolder(view, parent.getContext());

    }

    @Override
    public void onBindViewHolder(@NonNull VideojuegosViewHolder holder, int position) {
        holder.bind(this.listaVideojuegos[position]);

    }

    @Override
    public int getItemCount() {
        return listaVideojuegos.length;
    }


    public static class VideojuegosViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewVideojuego;
        private TextView textViewVideojuego;
        private TextView textViewGenero;
        private TextView textViewAño;

        private Context context;

        public VideojuegosViewHolder(View view, Context context) {
            super(view);
            this.context = context;
            imageViewVideojuego = view.findViewById(R.id.imageViewVideojuego);
            textViewVideojuego = view.findViewById(R.id.textViewVideojuego);
            textViewGenero = view.findViewById(R.id.textViewGenero);
            textViewAño = view.findViewById(R.id.textViewAño);

        }

        public void bind(Videojuegos videojuego) {
            textViewVideojuego.setText(videojuego.getNombre());
            textViewGenero.setText(videojuego.getGenero());
            textViewAño.setText(videojuego.getAño());
            imageViewVideojuego.setImageResource(videojuego.getImagen());

        }

    }
}



