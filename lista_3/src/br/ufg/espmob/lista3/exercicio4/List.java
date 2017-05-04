package br.ufg.espmob.lista3.exercicio4;

import br.ufg.espmob.lista3.exercicio3.Cidade;

import java.util.ArrayList;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class List {

    private java.util.List<Cidade> lista;
    private int tamanhoMaximo;

    public List(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.lista = new ArrayList<>();
    }

    public void adiciona(Cidade cidade) {
        if (lista.size() <= tamanhoMaximo)
            lista.add(cidade);
    }

    public void remove(int posicao) {
        if (posicao <= lista.size() && posicao >= 0)
            lista.remove(posicao);
    }

    public java.util.List<Cidade> getLista() {
        return lista;
    }

    public void setLista(java.util.List<Cidade> lista) {
        this.lista = lista;
    }

    public int getTamanhoMaximo() {
        return tamanhoMaximo;
    }

    public void setTamanhoMaximo(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
    }
}
