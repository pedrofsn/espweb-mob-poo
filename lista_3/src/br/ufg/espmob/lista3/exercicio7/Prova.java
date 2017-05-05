package br.ufg.espmob.lista3.exercicio7;

import br.ufg.espmob.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 04/05/2017.
 */
public class Prova {

    private List<Questao> questoes;

    public Prova() {
        List<Questao> questoes = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            questoes.add(new Questao());
        }
        this.questoes = questoes;
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


    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }
}
