package br.com.fucionario.iu.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();

        setTitle("Lista Funcionarios");
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        listaDeFuncionarios.setAdapter(
                new ArrayAdapter<>(this,
                             android.R.layout.simple_list_item_1, funcionarioDao.getAll()));

    }
}
