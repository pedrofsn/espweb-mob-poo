package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Gerente extends Funcionario {

    private String area;

    @Override
    public float calcularImposto() {
        return (salario * 5) / 100;
    }

    @Override
    public void imprimirDados() {
        super.imprimirDados();
    }
}
