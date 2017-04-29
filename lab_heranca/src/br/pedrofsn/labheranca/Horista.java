package br.pedrofsn.labheranca;

import java.util.Random;

/**
 * Created by aluno on 29/04/17.
 */
public class Horista extends Funcionario {

    private double valorHora;
    private int horasTrabalhadas;

    public Horista() {
        this.horasTrabalhadas = new Random().nextInt(261);
        this.valorHora = new Random().nextInt(100);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (horasTrabalhadas * valorHora);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}
