package br.com.fucionario.model;

public class Funcionario {

    private final String nome;
    private final String telefone;
    private final String email;

    public Funcionario(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return nome;
    }
}
