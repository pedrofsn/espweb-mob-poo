package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Funcionario extends Pessoa {

    protected float salario;

    public float calcularImposto() {
        return (salario * 3) / 100;
    }

    @Override
    public void imprimirDados() {

    }
}
