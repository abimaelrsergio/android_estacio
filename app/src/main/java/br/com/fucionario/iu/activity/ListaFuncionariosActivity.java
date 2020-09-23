package br.com.fucionario.iu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.fucionario.R;
import br.com.fucionario.dao.FuncionarioDAO;

public class ListaFuncionariosActivity extends AppCompatActivity {

    public static final String TITULO_LISTA_APP = "Lista Funcionarios";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funcionarios);
        setTitle(TITULO_LISTA_APP);
        configurarBotaoNovoFuncionario();
    }

    private void configurarBotaoNovoFuncionario() {
        FloatingActionButton botaoNovoFuncionario = findViewById(R.id.activity_lista_funcionarios_fab_novo_funcionario);
        botaoNovoFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormulario();
            }
        });
    }

    private void abrirFormulario(){
        startActivity(new Intent(ListaFuncionariosActivity.this, FormularioFuncionarioActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscarListaFuncionarios();
    }

    private void buscarListaFuncionarios() {
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        listaDeFuncionarios.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, funcionarioDao.getAll()));
        listaDeFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("Posição do Funcionario", "" + position);
            }
        });
    }
}
