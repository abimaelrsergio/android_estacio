package br.com.fucionario.iu.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.fucionario.R;
import br.com.fucionario.dao.FuncionarioDAO;
import br.com.fucionario.iu.adapter.ListaFuncionariosAdapter;
import br.com.fucionario.model.Funcionario;

import static br.com.fucionario.iu.activity.Constantes.CHAVE;

public class ListaFuncionariosActivity extends AppCompatActivity {

    private static final String TITULO_LISTA_APP = "Lista Funcionarios";
    private FuncionarioDAO funcionarioDao = new FuncionarioDAO();
    private ListaFuncionariosAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_funcionarios);
        setTitle(TITULO_LISTA_APP);
        configurarBotaoNovoFuncionario();
        buscarListaFuncionarios();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.activity_lista_funcionarios_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.activity_lista_funcionarios_menu_remover) {
            AdapterView.AdapterContextMenuInfo menuInfo =
                    (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            Funcionario funcionario = adapter.getItem(menuInfo.position);
            funcionarioDao.remove(funcionario);
            adapter.remove(funcionario);
        }
        if (itemId == R.id.activity_lista_funcionarios_menu_testando) {
            Log.i("TESTANDO", "onContextItemSelected: " + itemId);
        }
        return super.onContextItemSelected(item);
    }

    private void configurarBotaoNovoFuncionario() {
        FloatingActionButton botaoNovoFuncionario = findViewById(R.id.activity_lista_funcionarios_fab_novo_funcionario);
        botaoNovoFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirFormularioInserirFuncionario();
            }
        });
    }

    private void abrirFormularioInserirFuncionario(){
        startActivity(new Intent(ListaFuncionariosActivity.this, FormularioFuncionarioActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarFuncionarios();
    }

    private void atualizarFuncionarios() {
        adapter.clear();
        adapter.addAll(funcionarioDao.getAll());
    }

    private void buscarListaFuncionarios() {
        final List<Funcionario> funcionarios = funcionarioDao.getAll();
        ListView listaDeFuncionarios = findViewById(R.id.activity_lista_funcionarios);
        criarAdapter(funcionarios, listaDeFuncionarios);
        criarListener(listaDeFuncionarios);
        registerForContextMenu(listaDeFuncionarios);
    }

    private void criarListener(ListView listaDeFuncionarios) {
        listaDeFuncionarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {
                Funcionario funcionario = (Funcionario) parent.getItemAtPosition(posicao);
                editarFuncionario(funcionario);
            }
        });
    }

    private void editarFuncionario(Funcionario funcionario) {
        Intent irParaFormulario = new Intent(ListaFuncionariosActivity.this, FormularioFuncionarioActivity.class);
        irParaFormulario.putExtra(CHAVE, funcionario);
        startActivity(irParaFormulario);
    }

    private void criarAdapter(List<Funcionario> funcionarios, ListView listaDeFuncionarios) {
        adapter = new ListaFuncionariosAdapter(this);
        listaDeFuncionarios.setAdapter(adapter);
    }
}

