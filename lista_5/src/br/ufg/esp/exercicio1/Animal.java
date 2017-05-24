package br.ufg.esp.exercicio1;

/**
 * Created by pedrofsn on 24/05/2017.
 */
public abstract class Animal {

    private String nome;
    private String idade;

    public abstract void emitirSom();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }
}
