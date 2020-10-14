package br.com.fucionario.iu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.com.fucionario.R;
import br.com.fucionario.dao.FuncionarioDAO;
import br.com.fucionario.model.Funcionario;

public class ListaFuncionariosActivity extends AppCompatActivity {

    public static final String TITULO_LISTA_APP = "Lista Funcionarios";
    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();

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
        final List<Funcionario> funcionarios = funcionarioDao.getAll();
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        criarAdapter(funcionarios, listaDeFuncionarios);
        criarListener(funcionarios, listaDeFuncionarios);;
    }

    private void criarListener(final List<Funcionario> funcionarios, ListView listaDeFuncionarios) {
        listaDeFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Funcionario funcionario = funcionarios.get(position);
                Intent irParaFormulario = new Intent(ListaFuncionariosActivity.this, FormularioFuncionarioActivity.class);
                irParaFormulario.putExtra("funcionario", funcionario);
                startActivity(irParaFormulario);
            }
        });
    }

    private void criarAdapter(List<Funcionario> funcionarios, ListView listaDeFuncionarios) {
        listaDeFuncionarios.setAdapter(
                new ArrayAdapter<>(this,
                        android.R.layout.simple_list_item_1,
                        funcionarios));
    }
}
