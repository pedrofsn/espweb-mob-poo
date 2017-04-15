package br.ufg.espmob;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio10 {

    private static int linhas = 5;
    private static int colunas = 7;

    /*
    *    Elabore um programa que leia uma matriz A de dimensão 5 x 7 de inteiros e verifique qual é seu
    *    maior elemento e imprima-o juntamente com sua posição na matriz (linha e coluna).
    */
    public static void main(String[] args) {
        int[][] matriz = new int[linhas][colunas];
        popularMatriz(matriz);
        detectarMaiorElemento(matriz);
    }

    private static void detectarMaiorElemento(int[][] matriz) {
        int maiorElemento = 0;
        int linhaPosicao = 0;
        int colunaPosicao = 0;

        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {

                if (matriz[linha][coluna] > maiorElemento) {
                    maiorElemento = matriz[linha][coluna];
                    linhaPosicao = linha;
                    colunaPosicao = coluna;
                }

            }
        }

        Utils.print(String.format("MAIOR: matriz[%d][%d] = %d", linhaPosicao, colunaPosicao, maiorElemento));
    }

    private static void popularMatriz(int[][] matriz) {
        Random random = new Random();

        for (int linha = 0; linha < linhas; linha++) {
            for (int coluna = 0; coluna < colunas; coluna++) {
                matriz[linha][coluna] = random.nextInt(10);
            }
        }

        Utils.print("Matriz populada:");
        printarMatriz(matriz);
    }

    private static void printarMatriz(int[][] matriz) {
        for (int[] linha : matriz) {
            Utils.print(Arrays.toString(linha));
        }
    }
}
