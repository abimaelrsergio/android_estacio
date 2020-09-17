package br.com.fucionario.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fucionario.model.Funcionario;

public class FuncionarioDAO {
    private final static List<Funcionario> funcionarios = new ArrayList<>();

    public void salvar(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public List<Funcionario> getAll(){
        return new ArrayList<>(funcionarios); // cópia
    }

}
