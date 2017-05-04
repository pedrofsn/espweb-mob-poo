package br.ufg.espmob.lista3.exercicio6;

import java.util.Random;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class Trabalhador {

    private static final double SALARIO_MINIMO = 937.00;

    private int matricula;
    private int pecasPorMes;
    private boolean masculino;

    public Trabalhador() {
        this.matricula = new Random().nextInt(100);
        this.masculino = new Random().nextBoolean();
        this.pecasPorMes = new Random().nextInt(50);
    }

    public boolean isA() {
        return pecasPorMes <= 10;
    }

    public boolean isB() {
        return pecasPorMes >= 11 && pecasPorMes <= 34;
    }

    public boolean isC() {
        return pecasPorMes >= 35;
    }

    public double getSalario() {
        double salario = 0.0;
        double percentualPorPeca = 0.0;
        double extra;

        if (isA()) {
            return SALARIO_MINIMO;

        } else if (isB()) {

            percentualPorPeca = SALARIO_MINIMO * 0.5;
            extra = pecasPorMes > 10 ? percentualPorPeca * (pecasPorMes - 10) : 0;
            salario = extra + SALARIO_MINIMO;

        } else if (isC()) {

            percentualPorPeca = SALARIO_MINIMO * 0.9;
            extra = pecasPorMes > 35 ? percentualPorPeca * (pecasPorMes - 35) : 0;
            salario = extra + SALARIO_MINIMO;
        } else {

            throw new RuntimeException("Caso inexistente");
        }

        return salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getPecasPorMes() {
        return pecasPorMes;
    }

    public void setPecasPorMes(int pecasPorMes) {
        this.pecasPorMes = pecasPorMes;
    }

    public boolean isMasculino() {
        return masculino;
    }

    public void setMasculino(boolean masculino) {
        this.masculino = masculino;
    }
}
