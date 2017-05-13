package br.ufg.lab.model;

import br.ufg.lab.domain.Multimidia;

/**
 * Created by aluno on 13/05/17.
 */
public class Filme extends Multimidia {

    private String diretor;

    public Filme() {
        this.diretor = getRandom().nextBoolean() ? "Pedro" : "Sérgio";
    }

    @Override
    public String toString() {
        return "Do diretor " + diretor + ", " + super.toString();
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
