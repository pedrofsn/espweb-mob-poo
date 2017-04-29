package br.pedrofsn.labheranca;

import java.util.Random;

/**
 * Created by aluno on 29/04/17.
 */
public class Comissionado extends Funcionario {

    private int itensVendidos;
    private double valorItem;

    public Comissionado() {
        this.itensVendidos = new Random().nextInt(50);
        this.valorItem = new Random().nextInt(100);
    }

    @Override
    public double calcularSalario() {
        return getSalarioBase() + (itensVendidos * valorItem);
    }

    public int getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(int itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }
}
