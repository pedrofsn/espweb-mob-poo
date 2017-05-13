package br.ufg.lab.model;

/**
 * Created by aluno on 13/05/17.
 */
public class Cliente extends Pessoa {

    private int codigo;

    public Cliente(String nome, Data nascimento, int codigo) {
        super(nome, nascimento);
        this.codigo = codigo;
    }

    @Override
    public void imprimirDados() {
        System.out.print("O cliente " + getNome() + " nascido em " + getNascimento().getFormatado() + " tem código igual a " + codigo + "\n" + "\n");
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
