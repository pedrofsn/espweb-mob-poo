package br.ufg.espmob.lista3.exercicio5;

import java.util.Random;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class Comerciario {

    private int numeroInscricao;
    private double salarioFixo;
    private int telasPlanasVendidas;
    private int telasComunsVendidas;

    public Comerciario() {
        this.numeroInscricao = new Random().nextInt(100);
        this.salarioFixo = new Random().nextInt(750);
        this.telasPlanasVendidas = new Random().nextInt(50);
        this.telasComunsVendidas = new Random().nextInt(50);
    }

    private double getComissaoTelasPlanas() {
        return telasPlanasVendidas >= 10 ? telasPlanasVendidas * 50 : telasPlanasVendidas * 30;
    }

    private double getComissaoTelasComuns() {
        return telasComunsVendidas >= 20 ? telasComunsVendidas * 30 : telasComunsVendidas * 20;
    }

    private double getComissoes() {
        return getComissaoTelasComuns() + getComissaoTelasPlanas();
    }

    public double getSalarioBruto() {
        return salarioFixo + getComissoes();
    }

    public double getSalarioLiquido() {
        double salarioLiquido = 0.0;
        double inss = 0.0;

        inss = salarioFixo * 0.8;
        salarioLiquido = salarioFixo + getComissoes() - inss;

        if (salarioLiquido >= 700.00) {
            double irf = 0.5 * salarioLiquido;
            salarioLiquido = salarioLiquido - irf;
        }

        return salarioLiquido;
    }

    public int getNumeroInscricao() {
        return numeroInscricao;
    }

    public void setNumeroInscricao(int numeroInscricao) {
        this.numeroInscricao = numeroInscricao;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public int getTelasPlanasVendidas() {
        return telasPlanasVendidas;
    }

    public void setTelasPlanasVendidas(int telasPlanasVendidas) {
        this.telasPlanasVendidas = telasPlanasVendidas;
    }

    public int getTelasComunsVendidas() {
        return telasComunsVendidas;
    }

    public void setTelasComunsVendidas(int telasComunsVendidas) {
        this.telasComunsVendidas = telasComunsVendidas;
    }
}
