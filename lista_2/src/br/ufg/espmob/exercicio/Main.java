package br.ufg.espmob.exercicio;

import br.ufg.espmob.Utils;

/**
 * Created by pedrofsn on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 6; i++) {
            Utils.print("" + fibonacci.calculaFibonacci(i));
        }
    }

}
