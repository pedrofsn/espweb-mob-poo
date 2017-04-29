package br.pedrofsn.labheranca;

import java.util.Random;

/**
 * Created by aluno on 29/04/17.
 */
public class Gerente extends Funcionario {

    private double gratificacao;

    public Gerente() {
        this.gratificacao = new Random().nextInt(4000);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + gratificacao;
    }

    public double getGratificacao() {
        return gratificacao;
    }

    public void setGratificacao(double gratificacao) {
        this.gratificacao = gratificacao;
    }
}
