package br.com.fucionario.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fucionario.model.Funcionario;

public class FuncionarioDAO {
    private final static List<Funcionario> funcionarios = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void salvar(Funcionario funcionario) {
        funcionario.setId(contadorDeIds);
        funcionarios.add(funcionario);
        updateIds();
    }

    private void updateIds() {
        contadorDeIds++;
    }

    public List<Funcionario> getAll() {
        return new ArrayList<>(funcionarios); // cópia
    }

    public void editar(Funcionario funcionario) {

        Funcionario funcionarioEncontrado = findFuncionarioById(funcionario);
        if (funcionarioEncontrado != null) {
            int posicao = funcionarios.indexOf(funcionarioEncontrado);
            funcionarios.set(posicao, funcionario);
        }
    }

    private Funcionario findFuncionarioById(Funcionario funcionario) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                return f;
            }
        }
        return null;
    }

    public void remove(Funcionario funcionario) {
        Funcionario funcionarioEncontrado = findFuncionarioById(funcionario);
        if (funcionarioEncontrado != null) {
            funcionarios.remove(funcionarioEncontrado);
        }
    }
}
