package br.ufg.espmob;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio9 {

    /*
    *   Construa um programa que leia duas matrizes de mesma dimensão, efetue a soma das mesmas e imprima a matriz soma no final
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utils.print("Qual é a dimensão das matrizes?");
        int dimensao = scanner.nextInt();

        if (dimensao < 2) {
            Utils.print("Valor inválido");
            return;
        }

        int[][] matrizA = new int[dimensao][dimensao];
        int[][] matrizB = new int[dimensao][dimensao];

        popularMatriz("A", matrizA, dimensao);
        popularMatriz("B", matrizB, dimensao);

        Utils.print("\nO resultado da soma destas matrizes é:\n");

        int[][] matrizComputada = new int[dimensao][dimensao];

        for (int linha = 0; linha < dimensao; linha++) {
            for (int coluna = 0; coluna < dimensao; coluna++) {
                matrizComputada[linha][coluna] = matrizA[linha][coluna] + matrizB[linha][coluna];
            }
        }

        printarMatriz(matrizComputada);
    }

    private static void popularMatriz(String letra, int[][] matriz, int dimensao) {
        Scanner scanner = new Scanner(System.in);

        for (int linha = 0; linha < dimensao; linha++) {
            for (int coluna = 0; coluna < dimensao; coluna++) {
                Utils.print("Insira o valor para matriz" + letra + "[" + linha + "][" + coluna + "]:");
                int valorInserido = scanner.nextInt();
                matriz[linha][coluna] = valorInserido;
            }
        }

        Utils.print("matriz" + letra + ":");
        printarMatriz(matriz);
    }

    private static void printarMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            Utils.print(Arrays.toString(linha));
        }
    }
}
