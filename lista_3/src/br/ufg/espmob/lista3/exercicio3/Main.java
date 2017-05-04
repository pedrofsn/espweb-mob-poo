package br.ufg.espmob.lista3.exercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Main {

    public static void main(String[] args) {

        List<Cidade> cidades = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            Cidade cidade = new Cidade();

            // GERANDO DADOS específicos
            switch (i) {
                case 97:
                    cidade.setCodigo(62);
                    cidade.setNome("Trindade");
                    cidade.setEstado("Goiás");
                    cidade.setAcidentesTransito(10);
                    break;

                case 98:
                    cidade.setCodigo(62);
                    cidade.setNome("Goianésia");
                    cidade.setEstado("Goiás");
                    cidade.setAcidentesTransito(10);
                    break;

                case 99:
                    cidade.setCodigo(62);
                    cidade.setNome("Anápolis");
                    cidade.setEstado("Goiás");
                    cidade.setAcidentesTransito(10);
                    break;

                case 100:
                    cidade.setCodigo(62);
                    cidade.setNome("Goiânia");
                    cidade.setEstado("Goiás");
                    cidade.setAcidentesTransito(10);
                    break;
            }
            cidades.add(cidade);
        }

        Cidade cidade = new Cidade();
        cidade.printCidadeComMaisAcidentesDeTransito(cidades);
        cidade.printCidadeComMenosAcidentesDeTransito(cidades);
        cidade.printMediaVeiculosPasseio(cidades);
        cidade.printMediaAcidentes(cidades, "Goiás");
    }

}
