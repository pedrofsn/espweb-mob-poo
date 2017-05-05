package br.ufg.espmob.lista3.exercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pedrofsn on 04/05/2017.
 */
public class Questao {

    private int pontuacao;
    private int alternativaCorreta;
    private int alternativaSelecionada;
    private int maxAlternativas;
    private List<String> alternativas;

    public Questao() {
        this.pontuacao = 1;
        this.maxAlternativas = 5;
        this.alternativaCorreta = new Random().nextInt(maxAlternativas);
        this.alternativaSelecionada = new Random().nextInt(maxAlternativas);

        List<String> alternativas = new ArrayList<>();

        for (int i = 0; i < maxAlternativas; i++) {
            alternativas.add("Texto da alternativa blá blá blá_" + new Random().nextInt(32));
        }

        this.alternativas = alternativas;
    }

    public boolean isCorreta() {
        return alternativaCorreta == alternativaSelecionada;
    }

    public int getAlternativaSelecionada() {
        return alternativaSelecionada;
    }

    public void setAlternativaSelecionada(int alternativaSelecionada) {
        this.alternativaSelecionada = alternativaSelecionada;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(int alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }

    public int getMaxAlternativas() {
        return maxAlternativas;
    }

    public void setMaxAlternativas(int maxAlternativas) {
        this.maxAlternativas = maxAlternativas;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<String> alternativas) {
        this.alternativas = alternativas;
    }
}
