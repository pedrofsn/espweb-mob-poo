package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Cliente extends Pessoa {

    private int codigo;

    @Override
    public void imprimirDados() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
