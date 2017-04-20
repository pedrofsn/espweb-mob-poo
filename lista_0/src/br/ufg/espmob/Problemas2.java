/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.espmob;

import java.util.Random;

/**
 * @author aluno
 */
public class Problemas2 {

    public static void main(String[] args) {
        casoContadorCaracteres("Pedrofsn");
        espacoEntreLinhas();
        casoMetodosString("PEDROFSN");
        espacoEntreLinhas();
        casoArredondamento(25.55);
        espacoEntreLinhas();
        casoMaiorMenor(25, 30);
        espacoEntreLinhas();
        casoAleatorio();
        espacoEntreLinhas();
        casoQuadradoComRaiz(25);
        espacoEntreLinhas();
        casoEquacoes(10, 20);
    }

    private static void casoContadorCaracteres(String nome) {
        if (nome != null) {
            System.out.println(nome.toUpperCase() + " tem " + nome.length() + " caracteres");
        }
    }

    private static void casoMetodosString(String nome) {
        // Exibe as duas últimas letras da string
        if (nome != null && nome.length() > 3) {
            nome = nome.trim();
            System.out.println("Os últimos 2 caracteres da string \"" + nome + "\" em caixa baixa '" + nome.substring(nome.length() - 2, nome.length()).toLowerCase() + "'");
        }
    }

    private static void casoArredondamento(double valor) {
        String floor = String.valueOf(Math.floor(valor));
        String ceil = String.valueOf(Math.ceil(valor));
        String round = String.valueOf(Math.round(valor));

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
        System.out.println("Round: " + round);
    }

    private static void casoMaiorMenor(int a, int b) {
        String maior = String.valueOf(Math.max(a, b));
        String menor = String.valueOf(Math.min(a, b));

        System.out.println("Maior: " + maior);
        System.out.println("Menor: " + menor);
    }

    private static void casoAleatorio() {
        System.out.println("Aleatório: " + new Random().nextInt(101));
    }

    private static void casoQuadradoComRaiz(int i) {
        String quadrado = String.valueOf(i * 2);
        String raiz = String.valueOf(Math.sqrt(i));

        System.out.println("Quadrado: " + quadrado);
        System.out.println("Raíz: " + raiz);
    }

    private static void casoEquacoes(int a, int b) {
        String soma = String.valueOf(a + a);
        String subtracao = String.valueOf(a - a);
        String multiplicacao = String.valueOf(a * a);
        String divisao = String.valueOf(a / a);

        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        System.out.println("Divisão: " + divisao);
    }

    private static void espacoEntreLinhas() {
        System.out.println("\n\t====\t\n");
    }

}
