/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.espmob;

/**
 * @author aluno
 */
public class Problemas1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        casoMaiorMenor(20, 100, 5);
        System.out.println("=========");
        casoIncrementacao();
        System.out.println("=========");
        casoNumerosQuadrados();
        System.out.println("=========");
        casoNumerosImpares();
        System.out.println("=========");
        casoSomatorium();
        System.out.println("=========");
        casoFatorial();
        System.out.println("=========");
        casoBhaskara(1, 12, -13);
    }

    private static void casoMaiorMenor(int valor1, int valor2, int valor3) {
        int maiorValor = valor1;
        int menorValor = valor1;

        // Maior
        if (valor1 > valor2) {
            maiorValor = valor1;
        }

        if (valor2 > maiorValor) {
            maiorValor = valor2;
        }

        if (valor3 > maiorValor) {
            maiorValor = valor3;
        }

        // Menor
        if (valor1 < valor2) {
            menorValor = valor1;
        }

        if (valor2 < menorValor) {
            menorValor = valor2;
        }

        if (valor3 < menorValor) {
            menorValor = valor3;
        }

        System.out.println("Maior: " + maiorValor);
        System.out.println("Menor: " + menorValor);
    }

    private static void casoIncrementacao() {
        for (int i = 1; i < 21; i++) {
            System.out.println("Valor: " + i);
        }
    }

    private static void casoNumerosQuadrados() {
        for (int i = 1; i < 21; i++) {
            System.out.println("O quadrado de " + i + " é " + (i * i));
        }
    }

    private static void casoNumerosImpares() {
        for (int i = 1; i < 51; i++) {
            if (i % 2 != 0) {
                System.out.println("Ímpar =  " + i);
            }
        }
    }

    private static void casoSomatorium() {
        int somatorium = 0;
        for (int i = 1; i < 51; i++) {
            somatorium = somatorium + i;
        }

        System.out.println("Somatorium = " + somatorium);
    }

    private static void casoFatorial() {
        for (int i = 1; i < 11; i++) {
            System.out.println("O fatorial de " + i + " é " + fatorial(i));
        }
    }

    private static int fatorial(int numero) {
        return numero == 0 ? 1 : numero * fatorial(numero - 1);
    }

    private static void casoBhaskara(int a, int b, int c) {
        double delta = (b * b) - 4 * a * c;
        double raiz = Math.sqrt(delta);
        double fase1 = (b * -1);
        double divisao = 2 * a;

        double x1 = (fase1 - raiz) / divisao;
        double x2 = (fase1 + raiz) / divisao;

        System.out.println("X1 = " + x1);
        System.out.println("X2 = " + x2);
    }

}
