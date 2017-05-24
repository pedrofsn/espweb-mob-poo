package br.ufg.esp.empresas;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Funcionario {

    private int codigo;
    private String nome;
    private Estudo estudo;
    private double rendaBasica = 1000;

    public Funcionario(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.estudo = null;
    }

    public Funcionario(int codigo, String nome, Estudo estudo) {
        this.codigo = codigo;
        this.nome = nome;
        this.estudo = estudo;
    }

    public Estudo getEstudo() {
        return estudo;
    }

    public void setEstudo(Estudo estudo) {
        this.estudo = estudo;
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
}
