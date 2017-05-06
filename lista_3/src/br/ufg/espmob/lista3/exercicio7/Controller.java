package br.ufg.espmob.lista3.exercicio7;

import br.ufg.espmob.Utils;

import java.util.ArrayList;
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

    public void printPercentualAprovados(List<Candidato> candidatos) {
        if (!Utils.isNullOrEmpty(candidatos)) {
            int aprovados = 0;
            int totalCandidatos = candidatos.size();

            for (int i = 0; i < totalCandidatos; i++) {
                Candidato obj = candidatos.get(i);

                if (obj.getProva().isNotaMaiorOuIgualMedia()) {
                    aprovados++;
                }
            }

            float percentualAprovados = aprovados * 100 / totalCandidatos;
            Utils.print("Percentual de aprovados: " + percentualAprovados + "%");
        }
    }

    public void printCandidatosAprovados(List<Candidato> candidatos) {
        if (!Utils.isNullOrEmpty(candidatos)) {
            List<Candidato> aprovados = new ArrayList<>();

            for (int i = 0; i < candidatos.size(); i++) {
                Candidato obj = candidatos.get(i);

                if (obj.getProva().isNotaMaiorOuIgualMedia()) {
                    aprovados.add(obj);
                }
            }

            if (Utils.isNullOrEmpty(aprovados)) {
                Utils.print("Não há candidatos aprovados");

            } else {
                printCandidatos(aprovados);
            }
        }
    }

    public void printCandidatosComNotaMaiorOuIgual(List<Candidato> candidatos, int valor) {
        if (!Utils.isNullOrEmpty(candidatos)) {
            List<Candidato> aprovados = new ArrayList<>();

            for (int i = 0; i < candidatos.size(); i++) {
                Candidato obj = candidatos.get(i);

                if (obj.getProva().isNotaMaiorOuIgual(valor)) {
                    aprovados.add(obj);
                }
            }

            if (Utils.isNullOrEmpty(aprovados)) {
                Utils.print("Não há candidatos com nota maior ou igual a " + valor);

            } else {
                printCandidatos(aprovados);
            }
        }
    }

    public void fazTudo(List<Candidato> lista) {
        printCandidatos(lista);
        Utils.print("===");
        printPercentualAprovados(lista);
        Utils.print("===");
        printCandidatosAprovados(lista);
        Utils.print("===");
        printCandidatosComNotaMaiorOuIgual(lista, 9);
    }
}
