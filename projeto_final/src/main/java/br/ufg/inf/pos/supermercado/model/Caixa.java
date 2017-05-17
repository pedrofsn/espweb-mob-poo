package br.ufg.inf.pos.supermercado.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Caixa {

    public boolean isUnidade; // false = kg
    private int codigo;

    public Caixa(int codigo) {
        this.codigo = codigo;
    }

    public boolean isUnidade() {
        return isUnidade;
    }

    public void setUnidade(boolean unidade) {
        isUnidade = unidade;
    }
}
