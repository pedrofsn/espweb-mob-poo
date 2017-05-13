package br.ufg.lab.model;

import br.ufg.lab.domain.Multimidia;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 13/05/17.
 */
public class MinhaLista {

    private List<Multimidia> lista = new ArrayList<>();
    private int quantidadeCd;
    private int quantidadeFilme;
    private int quantidadeJogo;

    public void add(Multimidia multimidia) {
        lista.add(multimidia);
        incrementar(multimidia);
    }

    public void remove(Multimidia multimidia) {
        lista.remove(multimidia);
        decrementar(multimidia);
    }

    private void incrementar(Multimidia multimidia) {
        atualizarContadores(multimidia, true);
    }

    private void decrementar(Multimidia multimidia) {
        atualizarContadores(multimidia, false);
    }

    private void atualizarContadores(Multimidia multimidia, boolean isIncrementar) {
        if (multimidia instanceof Cd) {
            quantidadeCd = quantidadeCd + (isIncrementar ? +1 : -1);

        } else if (multimidia instanceof Filme) {
            quantidadeFilme = quantidadeFilme + (isIncrementar ? +1 : -1);

        } else if (multimidia instanceof Jogo) {
            quantidadeJogo = quantidadeJogo + (isIncrementar ? +1 : -1);

        }
    }

    public int getQuantidadeCd() {
        return quantidadeCd;
    }

    public int getQuantidadeFilme() {
        return quantidadeFilme;
    }

    public int getQuantidadeJogo() {
        return quantidadeJogo;
    }
}
