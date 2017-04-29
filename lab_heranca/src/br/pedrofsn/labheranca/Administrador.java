package br.pedrofsn.labheranca;

import java.util.Random;

/**
 * Created by aluno on 29/04/17.
 */
public class Administrador extends Funcionario {

    private double bonus;

    public Administrador() {
        this.bonus = new Random().nextInt(15000);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
