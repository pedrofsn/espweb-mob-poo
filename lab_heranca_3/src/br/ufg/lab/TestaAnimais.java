package br.ufg.lab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 13/05/17.
 */
public class TestaAnimais {

    public static void main(String[] args) {
        testar();
    }

    private static void testar() {
        List<Animal> lista = getListaPopulada();

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).som());
        }
    }

    private static List<Animal> getListaPopulada() {
        List<Animal> lista = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0) {
                lista.add(new Boi());

            } else if (i % 3 == 0) {
                lista.add(new Cachorro());

            } else {
                lista.add(new Sapo());
            }
        }

        return lista;
    }
}
