package br.ufg.espmob.lista3.exercicio6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Main {

    public static void main(String[] args) {

        List<Trabalhador> lista = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            Trabalhador obj = new Trabalhador();
            lista.add(obj);
        }

        ControllerTrabalhador controllerTrabalhador = new ControllerTrabalhador();
        controllerTrabalhador.fazTudo(lista);
    }

}
