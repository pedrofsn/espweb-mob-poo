package br.ufg.espmob;

import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio7 {

    /*
    *   Faça um programa que leia um vetor de nove elementos inteiros, calcule e mostre os números ímpares e suas respectivas posições.
    */

    private static Integer[] vetor = new Integer[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < vetor.length; i++) {
            Utils.print("Insira o valor para ocupar a posição " + i + " do vetor");
            int valorInserido = scanner.nextInt();
            vetor[i] = valorInserido;

            if (valorInserido != 0 && valorInserido % 2 != 0) {
                stringBuffer.append("O valor " + valorInserido + " é ímpar e está na posição " + i + " do vetor\n");
            }
        }

        Utils.print(stringBuffer.toString());
    }
}
