package br.com.fucionario.model;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private int id;
    private String nome;
    private String telefone;
    private String email;

    public Funcionario(){
    }

    public Funcionario(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
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

    public boolean isValidId(){
        return id > 0;
    }

    public String toString() {
        return nome;
    }
}
