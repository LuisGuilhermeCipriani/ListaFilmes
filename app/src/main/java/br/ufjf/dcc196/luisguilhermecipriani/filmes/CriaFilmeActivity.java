package br.ufjf.dcc196.luisguilhermecipriani.filmes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CriaFilmeActivity extends AppCompatActivity {
    private EditText editTextTextTitulo;
    private EditText editTextTextAno;
    private EditText editTextTextEstilo;
    private EditText editTextTextDiretor;
    private Boolean assistido;
    private RadioButton sim;
    private RadioButton nao;
    private Button criar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_filme);

        editTextTextTitulo = findViewById(R.id.editTextTextTitulo);
        editTextTextAno = findViewById(R.id.editTextTextAno);
        editTextTextEstilo = findViewById(R.id.editTextTextEstilo);
        editTextTextDiretor = findViewById(R.id.editTextTextDiretor);

        sim = (RadioButton) findViewById(R.id.radioButtonSim);
        nao = (RadioButton) findViewById(R.id.radioButtonNao);
        criar = findViewById(R.id.buttonCriar);
    }

    public void criaClick(View view) {
        try {
            String titulo = editTextTextTitulo.getText().toString();
            String ano = editTextTextAno.getText().toString();
            String estilo = editTextTextEstilo.getText().toString();
            String diretor = editTextTextDiretor.getText().toString();
            if (sim.isChecked()) {
                assistido = true;
            }
            if (nao.isChecked()) {
                assistido = false;
            }

            Intent resultado = new Intent();
            resultado.putExtra("titulo", titulo);
            resultado.putExtra("ano", ano);
            resultado.putExtra("estilo", estilo);
            resultado.putExtra("diretor", diretor);
            resultado.putExtra("assistido", assistido);
            setResult(RESULT_OK, resultado);

            Context contexto = getApplicationContext();
            String texto = "Filme Criado!";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();
        }catch (Exception e){
            Context contexto = getApplicationContext();
            String texto = "Erro";
            int duracao = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(contexto, texto, duracao);
            toast.show();
        }

    }

    public void retornarClick(View view) {
        finish();
    }
}