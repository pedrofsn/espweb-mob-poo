package br.ufg.espmob;

/**
 * Created by pedrofsn on 18/04/2017.
 */
public class Funcionario {

    private String nome;
    private String departamento;
    private double salario;
    private Data dataDeEntrada = new Data();
    private String rg;

    public void recebeAumento(double aumento) {
        this.salario = salario + aumento;
    }

    public double calculaGanhoAnual() {
        return salario * 12;
    }

    public void mostra() {
        Utils.print("Nome: " + nome);
        Utils.print("Departamento: " + departamento);
        Utils.print("Salário: " + Utils.getValorMonetario(salario));
        Utils.print("RG: " + rg);

        if (!Utils.isNullOrEmpty(dataDeEntrada)) {
            Utils.print("Entrada no banco:" + dataDeEntrada.formatada());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Data getDataDeEntrada() {
        return dataDeEntrada;
    }

    public void setDataDeEntrada(Data dataDeEntrada) {
        this.dataDeEntrada = dataDeEntrada;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
