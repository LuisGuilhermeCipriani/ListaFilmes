package br.ufjf.dcc196.luisguilhermecipriani.filmes;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {
    private final List<Filme> filmes;

    public FilmeAdapter(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class FilmeViewHolder extends RecyclerView.ViewHolder{
        public FilmeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
