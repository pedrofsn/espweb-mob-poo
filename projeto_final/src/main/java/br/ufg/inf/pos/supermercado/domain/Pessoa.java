package br.ufg.inf.pos.supermercado.domain;

/**
 * Created by aluno on 13/05/17.
 */
public abstract class Pessoa {

    private String nome;

    public abstract TipoUsuario getTipo();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
