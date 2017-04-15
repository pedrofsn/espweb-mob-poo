package br.ufg.espmob;

import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio4 {

    /*
    *   A condição física de uma pessoa pode ser medida com base no cálculo do índice de Massa Corporal
    *   (IMC). O mesmo é calculado dividindo-se o peso desta pessoa pelo quadrado da altura. Escreva um
    *   programa que leia o peso em kg e a altura de uma pessoa em m, calcule e mostre o IMC.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Utils.print("Qual é o seu peso (Kg) ?");
        float peso = scanner.nextFloat();

        Utils.print("Qual é a sua altura (m) ?");
        float altura = scanner.nextFloat();

        float imc = peso / (altura * altura);

        Utils.print("O seu IMC é " + imc);
    }

}
