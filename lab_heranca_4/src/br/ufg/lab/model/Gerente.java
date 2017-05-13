package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Gerente extends Funcionario {

    private String area;

    public Gerente(String nome, Data nascimento, float salario, String area) {
        super(nome, nascimento, salario);
        this.area = area;
    }

    @Override
    public float calcularImposto() {
        return (getSalario() * 5) / 100;
    }

    @Override
    public void imprimirDados() {
        System.out.println("O salário do gerente " + getNome() + " (nascido em " + getNascimento().getFormatado() + "), da área " + area + ", é de " + getSalario() + " fora o desconto de " + calcularImposto() + "\n");
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
