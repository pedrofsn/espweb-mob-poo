package br.ufg.lab.model;

import br.ufg.lab.domain.Multimidia;

/**
 * Created by aluno on 13/05/17.
 */
public class Jogo extends Multimidia {

    private int numeroJogadores;
    private String plataforma;

    public Jogo() {
        this.numeroJogadores = getRandom().nextInt(6);
        this.plataforma = getRandom().nextBoolean() ? "xbox one" : "ps4";
    }

    @Override
    public String toString() {
        return "Exclusivo para " + plataforma.toUpperCase() + ": " + super.toString() + " | Número de jogadores: " + numeroJogadores;
    }

    public int getNumeroJogadores() {
        return numeroJogadores;
    }

    public void setNumeroJogadores(int numeroJogadores) {
        this.numeroJogadores = numeroJogadores;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
