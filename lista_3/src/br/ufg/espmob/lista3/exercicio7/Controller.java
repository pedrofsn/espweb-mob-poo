package br.ufg.espmob.lista3.exercicio7;

import br.ufg.espmob.Utils;

import java.util.List;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class Controller {

    public void printCandidatos(List<Candidato> candidatos) {
        if (!Utils.isNullOrEmpty(candidatos)) {
            for (int i = 0; i < candidatos.size(); i++) {
                Candidato obj = candidatos.get(i);
                Utils.print(obj.toString());
            }
        }
    }

}
