package br.ufjf.dcc196.luisguilhermecipriani.filmes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFilmes;
    private List<Filme> filmes;
    private LinearLayoutManager layoutManager;
    private FilmeAdapter filmeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmes = new ArrayList<Filme>(){{
            add(new Filme("IT - A Coisa", "2017", "Terror", "Andy Muschietti", true));
            add(new Filme("Vingadores Ultimato", "2019", "Ação", "Joe Russo", false));
            add(new Filme("Histórias Cruzadas", "2012", "Drama", "Tate Taylor", true));
            add(new Filme("Amor com Data Marcada", "2020", "Comédia", "John Whitesell", false));
            add(new Filme("Voo Noturno", "2005", "Suspense", "Wes Craven", true));
        }};

        recyclerViewFilmes =findViewById(R.id.recyclerViewFilmes);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFilmes.setLayoutManager(layoutManager);
        filmeAdapter = new FilmeAdapter(filmes);
        recyclerViewFilmes.setAdapter(filmeAdapter);
    }
}