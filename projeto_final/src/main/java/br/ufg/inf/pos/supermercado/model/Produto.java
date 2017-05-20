package br.ufg.inf.pos.supermercado.model;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Produto {

    private int codigo;
    private String nome;
    private double quantidade;
    private double preco;

    public Produto() {
    }

    public Produto(int codigo, double quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public Produto(int codigo, String nome, double quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public boolean isPorKg() {
        int inteiro = (int) quantidade;
        return quantidade - inteiro > 0;
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

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        String mensagem = (isPorKg() ? "PESO" : "QUANTIDADE") + ": " + quantidade;
        return "CÓDIGO: " + codigo + " | NOME: " + nome + " | Preço: " + preco + " | Por Kg: " + (isPorKg() ? "Sim" : "Não") + " | " + mensagem;
    }

    public String getTipoEmString() {
        return isPorKg() ? "Kg" : "unidade(s)";
    }
}
