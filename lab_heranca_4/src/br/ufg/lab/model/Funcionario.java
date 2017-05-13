package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Funcionario extends Pessoa {

    private float salario;

    public Funcionario(String nome, Data nascimento, float salario) {
        super(nome, nascimento);
        this.salario = salario;
    }

    public float calcularImposto() {
        return (salario * 3) / 100;
    }

    @Override
    public void imprimirDados() {
        System.out.println("O salário do funcionário " + getNome() + " é de " + salario + " fora o desconto de " + calcularImposto() + "\n");
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
