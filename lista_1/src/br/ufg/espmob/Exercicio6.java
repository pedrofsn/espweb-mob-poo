package br.ufg.espmob;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio6 {

    /*
    *   Construa um programa que gere um vetor de 50 elementos reais, da seguinte forma: a primeira e a
    *   última posições com o valor 100 e as demais posições do vetor preenchidas com a soma do
    *   quadrado do índice do elemento anterior e a raiz quadrada do índice do elemento seguinte. Ao final
    *   imprima o vetor gerado. Os elementos serão: 100, 02 2 , 12 3 , 22 4 ,..., 100
    */

    private static Double[] vetor = new Double[50];

    public static void main(String[] args) {
        int lastPosition = vetor.length - 1;

        vetor[0] = 100.0;
        vetor[lastPosition] = vetor[0];

        printar(0);

        for (int i = 1; i < lastPosition; i++) {
            vetor[i] = (i - 1) * (i - 1) + Math.sqrt(i + 1);
            printar(i);
        }
        printar(lastPosition);

    }

    private static void printar(int i) {
        Utils.print("vetor[" + i + "] = " + vetor[i]);
    }
}
