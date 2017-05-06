package br.ufg.espmob.lista3.exercicio7;

import br.ufg.espmob.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 04/05/2017.
 */
public class Prova {

    private List<Questao> questoes;
    private int notaMinimaParaAprovacao;

    public Prova() {
        List<Questao> questoes = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            questoes.add(new Questao());
        }
        this.questoes = questoes;
        this.notaMinimaParaAprovacao = 6;
    }

    public int getNota() {
        if (!Utils.isNullOrEmpty(questoes)) {
            int pontuacao = 0;

            for (int i = 0; i < questoes.size(); i++) {
                Questao questao = questoes.get(i);

                if (questao.isCorreta()) {
                    pontuacao++;
                }
            }

            return pontuacao;
        }

        return -1;
    }

    public boolean isNotaMaiorOuIgual(int valor) {
        return getNota() >= valor;
    }

    public boolean isNotaMaiorOuIgualMedia() {
        return isNotaMaiorOuIgual(notaMinimaParaAprovacao);
    }

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    public int getNotaMinimaParaAprovacao() {
        return notaMinimaParaAprovacao;
    }

    public void setNotaMinimaParaAprovacao(int notaMinimaParaAprovacao) {
        this.notaMinimaParaAprovacao = notaMinimaParaAprovacao;
    }
}
