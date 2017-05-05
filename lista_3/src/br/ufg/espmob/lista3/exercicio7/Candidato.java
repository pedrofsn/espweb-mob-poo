package br.ufg.espmob.lista3.exercicio7;

import java.util.Random;

/**
 * Created by pedrofsn on 04/05/2017.
 */
public class Candidato {

    private int numeroInscricao;
    private String nome;
    private String telefone;
    private Prova prova;

    public Candidato() {
        this.numeroInscricao = new Random().nextInt(100);
        this.nome = "Candidato " + this.numeroInscricao;
        this.telefone = String.valueOf(this.numeroInscricao * 104561);
        this.prova = new Prova();
    }

    @Override
    public String toString() {
        return "INSCRIÇÃO: " + numeroInscricao + " | NOME: " + nome + " | NOTA: " + prova.getNota();
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
