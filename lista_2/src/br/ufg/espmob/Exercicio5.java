package br.ufg.espmob;

import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio5 {

    /*
    *   Numa determinada região, o imposto sobre propriedade é calculado a partir de duas informações, a área total do terreno (m2) e
    *   a área construída do terreno (m2). O imposto é cobrado da seguinte maneira:
    *
    *   - R$ 5,00 para cada metro quadrado construído.
    *   - R$ 3,80 para cada metro quadrado não construído.
    *
    *   Faça um programa que leia a área total do terreno, a área construída do terreno, calcule e imprima o
    *   valor total a ser pago.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira a área total do terreno (m²):");
        float total = scanner.nextFloat();

        System.out.println("Insira a área construída no terreno (m²):");
        float construcao = scanner.nextFloat();

        float areaNaoConstruida = total - construcao;

        float valorTotal = (float) (5 * construcao + 3.80 * areaNaoConstruida);
        Utils.print("Valor total a ser pago: " + Utils.getValorMonetario(valorTotal));
    }

}
