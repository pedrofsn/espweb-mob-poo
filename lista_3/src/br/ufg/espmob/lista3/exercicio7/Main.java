package br.ufg.espmob.lista3.exercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Main {

    public static void main(String[] args) {

        List<Candidato> lista = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            Candidato obj = new Candidato();
            lista.add(obj);
        }

        Controller controller = new Controller();
        controller.fazTudo(lista);
    }

}
