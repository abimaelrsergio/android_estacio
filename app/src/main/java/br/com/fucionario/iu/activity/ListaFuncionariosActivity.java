package br.com.fucionario.iu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.fucionario.R;
import br.com.fucionario.dao.FuncionarioDAO;

public class ListaFuncionariosActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funcionarios);
        setTitle("Lista Funcionarios");
        FloatingActionButton botaoNovoFuncionario = findViewById(R.id.activity_lista_funcionarios_fab_novo_funcionario);
        botaoNovoFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaFuncionariosActivity.this, FormularioFuncionarioActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        FuncionarioDAO funcionarioDao = new FuncionarioDAO();
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        listaDeFuncionarios.setAdapter(
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1, funcionarioDao.getAll()));

    }
}
