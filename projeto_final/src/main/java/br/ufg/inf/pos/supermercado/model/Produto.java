package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.utils.Utils;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Produto {

    private int codigo;
    private String nome;
    private Integer quantidade;
    private Double peso;
    private double preco;

    public Produto() {
    }

    public Produto(int codigo, String nome, Integer quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(int codigo, String nome, Double peso, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.peso = peso;
        this.preco = preco;
    }

    public boolean isPorKg() {
        return !Utils.isNullOrEmpty(peso) && Utils.isNullOrEmpty(quantidade);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "CÓDIGO: " + codigo + " | NOME: " + nome + " | " + (isPorKg() ? "PESO" : "QUANTIDADE") + ": " + (isPorKg() ? peso : quantidade) + " | Preço: " + preco + " | Por Kg: " + (isPorKg() ? "Sim" : "Não");
    }
}
