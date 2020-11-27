package br.ufjf.dcc196.luisguilhermecipriani.filmes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFilmes;
    private List<Filme> filmes;
    private LinearLayoutManager layoutManager;
    private FilmeAdapter filmeAdapter;
    private ItemTouchHelper.SimpleCallback touchHelperCallback;

    public static final int REQUEST_CRIA_FILME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmes = new ArrayList<Filme>() {{
            add(new Filme("IT - A Coisa", "2017", "Terror", "Andy Muschietti", true));
            add(new Filme("Vingadores Ultimato", "2019", "Ação", "Joe Russo", false));
            add(new Filme("Histórias Cruzadas", "2012", "Drama", "Tate Taylor", true));
            add(new Filme("Amor com Data Marcada", "2020", "Comédia", "John Whitesell", false));
            add(new Filme("Voo Noturno", "2005", "Suspense", "Wes Craven", true));
        }};

        recyclerViewFilmes = findViewById(R.id.recyclerViewFilmes);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewFilmes.setLayoutManager(layoutManager);
        filmeAdapter = new FilmeAdapter(filmes);
        recyclerViewFilmes.setAdapter(filmeAdapter);

        touchHelperCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                filmes.remove(viewHolder.getAdapterPosition());
                filmeAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        };

        new ItemTouchHelper(touchHelperCallback).attachToRecyclerView(recyclerViewFilmes);
    }

    public void criaFilmeClick(View view) {
        try{
            Intent intent = new Intent(getApplicationContext(), CriaFilmeActivity.class);
            startActivityForResult(intent, REQUEST_CRIA_FILME);
        } catch (NumberFormatException ex){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String titulo = "";
        String ano = "";
        String estilo = "";
        String diretor = "";
        Boolean assistido = false;
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CRIA_FILME){
                titulo = data.getExtras().getString("titulo");
                ano = data.getExtras().getString("ano");
                estilo = data.getExtras().getString("estilo");
                diretor = data.getExtras().getString("diretor");
            }
            filmes.add(new Filme(titulo, ano, estilo, diretor, true));
        }
    }
}