package br.pedrofsn.labheranca;

import java.util.Random;
import java.util.UUID;

/**
 * Created by aluno on 29/04/17.
 */
public abstract class Funcionario {

    private int matricula;
    private String nome;
    private double salarioBase;

    public Funcionario() {
        this.salarioBase = 1000.00;
    }

    public abstract double calcularSalario();

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
