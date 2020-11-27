package br.ufjf.dcc196.luisguilhermecipriani.filmes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FilmeAdapter extends RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder> {
    private final List<Filme> filmes;
    private Object listener;

    public FilmeAdapter(List<Filme> filmes, OnFilmeClickListener listener) {
        this.filmes = filmes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FilmeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context ctx = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View filmeView = inflater.inflate(R.layout.filme_layout, parent, false);
        FilmeViewHolder viewHolder = new FilmeViewHolder(filmeView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmeViewHolder holder, int position) {
        String verificaAssistido = "Não Assistido";
        if(filmes.get(position).getAssistido().toString() == "true")
            verificaAssistido = "Assistido";

        holder.textViewTitulo.setText(filmes.get(position).getTitulo());
        holder.textViewAno.setText(filmes.get(position).getAno());
        holder.textViewEstilo.setText(filmes.get(position).getEstilo());
        holder.textViewDiretor.setText(filmes.get(position).getDiretor());
        holder.textViewAssistido.setText(verificaAssistido);
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public class FilmeViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitulo;
        private TextView textViewAno;
        private TextView textViewEstilo;
        private TextView textViewDiretor;
        private TextView textViewAssistido;
        public FilmeViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.textViewTitulo);
            textViewAno = itemView.findViewById(R.id.textViewAno);
            textViewEstilo = itemView.findViewById(R.id.textViewEstilo);
            textViewDiretor = itemView.findViewById(R.id.textViewDiretor);
            textViewAssistido = itemView.findViewById(R.id.textViewAssistido);
        }
    }

    public interface OnFilmeClickListener{
        void onFilmeCLick(View soure, int position);
    }
}
