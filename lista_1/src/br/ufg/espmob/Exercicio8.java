package br.ufg.espmob;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio8 {

    /*
    *   Construa um programa que leia um vetor de nove posições e a partir deste vetor, preencha uma matriz 3x3 com os mesmos valores.
    *   O preenchimento da matriz deve ser por linha.
    *   Ao final, imprima o vetor e a matriz gerada.
    */
    private static Integer[] vetor = new Integer[9];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < vetor.length; i++) {
            Utils.print("Insira o valor para ocupar a posição " + i + " do vetor");
            int valorInserido = scanner.nextInt();
            vetor[i] = valorInserido;
        }

        Utils.print("Vetor:");
        Utils.print(Arrays.toString(vetor));

        int maxVetor = vetor.length;

        Integer[][] matriz = new Integer[3][3];

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz.length; coluna++) {

                if (linha == 0) {
                    matriz[linha][coluna] = vetor[coluna + linha];

                } else if (linha == 1) {
                    matriz[linha][coluna] = vetor[coluna + matriz.length];

                } else if (linha == 2) {
                    matriz[linha][coluna] = vetor[coluna + linha + matriz.length + 1];

                }
            }
        }

        Utils.print("Matriz: ");
        for (Integer[] linha : matriz) {
            Utils.print(Arrays.toString(linha));
        }
    }
}
