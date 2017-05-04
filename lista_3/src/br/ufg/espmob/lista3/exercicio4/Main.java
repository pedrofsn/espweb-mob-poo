package br.ufg.espmob.lista3.exercicio4;

import br.ufg.espmob.Utils;
import br.ufg.espmob.lista3.exercicio3.Cidade;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Main {

    public static void main(String[] args) {

        List cidades = new List(3);
        for (int i = 0; i < 50; i++) {
            Cidade cidade = new Cidade();
            cidades.adiciona(cidade);
        }

        Utils.print("Total de cidades: " + cidades.getTamanhoMaximo());
    }

}
