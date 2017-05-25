package br.ufg.esp.empresas;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Funcionario {

    private static final double RENDA_BASICA = 1000;

    private int codigo;
    private String nome;
    private Estudo estudo;
    private Comissao comissao;

    public Funcionario(int codigo, Estudo estudo, Comissao comissao) {
        this.codigo = codigo;
        this.nome = "Fulano " + codigo;
        this.estudo = estudo;
        this.comissao = comissao;
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

    public double getRendaTotal() {
        double comissao = 0.0;
        if (!Utils.isNullOrEmpty(getComissao())) {
            comissao = getComissao().getValor();
        }

        return estudo.calcularSalario(RENDA_BASICA) + comissao;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    @Override
    public String toString() {
        return nome + " recebeu " + Utils.getValorMonetario(getRendaTotal()) + "(" + Utils.getValorMonetario(comissao.getValor()) + " de comissão)";
    }
}
