package br.com.fucionario.iu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.fucionario.R;
import br.com.fucionario.iu.activity.ListaFuncionariosActivity;
import br.com.fucionario.model.Funcionario;

public class ListaFuncionariosAdapter extends BaseAdapter {

    private final List<Funcionario> funcionarios = new ArrayList<>();
    private Context context;

    public ListaFuncionariosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return funcionarios.size();
    }

    @Override
    public Funcionario getItem(int position) {
        return funcionarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return funcionarios.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewInflated = LayoutInflater
                .from(context)
                .inflate(R.layout.item_funcionario, parent, false);
        Funcionario funcionario = funcionarios.get(position);
        TextView nomeFunc = viewInflated.findViewById(R.id.item_funcionario_nome);
        TextView telefoneFunc = viewInflated.findViewById(R.id.item_funcionario_telefone);
        nomeFunc.setText(funcionario.getNome());
        telefoneFunc.setText(funcionario.getTelefone());
        return viewInflated;
    }

    public void clear() {
        this.funcionarios.clear();
    }

    public void addAll(List<Funcionario> funcionarios) {
        this.funcionarios.addAll(funcionarios);
    }

    public void remove(Funcionario funcionario){
        this.funcionarios.remove(funcionario);
    }
}
