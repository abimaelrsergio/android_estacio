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

public class ListaFuncionariosActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funcionarios);
        setTitle("Lista Funcionarios");
        List<String> funcionarios = new ArrayList<>(
                Arrays.asList("Andre","Antonio","Maria","Ana","Joao","Pedro","Daniel","Daniela","Wagner","Leandro","Abimael","Gisela","Gisele","Gislene","Joana","Maria Joaquina","Quirino","Sirino","Chaves","Quico","Kiko","Quico"));
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        listaDeFuncionarios.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, funcionarios));

    }
}
