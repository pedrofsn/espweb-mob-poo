package br.ufg.esp.empresas;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Funcionario {

    private static final double RENDA_BASICA = 1000;

    private int codigo;
    private String nome;
    private Estudo estudo;

    public Funcionario(int codigo, Estudo estudo) {
        this.codigo = codigo;
        this.nome = "Fulano " + codigo;
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

    public double getSalario() {
        return estudo.calcularSalario(RENDA_BASICA);
    }
}
