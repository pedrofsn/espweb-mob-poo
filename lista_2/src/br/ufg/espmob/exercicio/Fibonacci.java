package br.ufg.espmob.exercicio;

/**
 * Created by pedrofsn on 19/04/2017.
 */
public class Fibonacci {

    public int calculaFibonacci(int valor) {
        return valor > 2 ? calculaFibonacci(valor - 1) + calculaFibonacci(valor - 2) : valor;
    }

}