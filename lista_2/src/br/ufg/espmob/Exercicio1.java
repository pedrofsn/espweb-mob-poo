package br.ufg.espmob;

import javax.swing.*;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio1 {

    /*
    *   Crie um programa que receba por janela JOptionPane o valor de um produto e um código de
    *   aumento. Calcule o novo valor e por fim, acrescente a este, um imposto.
    *
    *   Os códigos do aumento são: 1 – 10%; 2 – 25%; 3 – 30%; 4 – 50%
    *
    *   O Imposto é calculado após o aumento do valor, sendo 1% para produtos com valores entre 1.000,00
    *   e 5.000,00; 2% de 5.000,01 a 10.0000,00 e 3% acima de 10.000,01.
    *
    *   Utilizando a estrutura switch-case para o aumento, calcule novo valor do produto. Ao final mostre o
    *   valor total com o imposto.
    * */
    public static void main(String[] args) {
        String valorEntrada = JOptionPane.showInputDialog("Insira o valor de um produto");
        String mensagemErro = "Valor vazio ou inválido";
        float valorProduto;

        if (valorEntrada == null || "".equals(valorEntrada.trim())) {
            JOptionPane.showMessageDialog(null, mensagemErro);
            return;
        } else {
            try {
                valorProduto = Float.valueOf(valorEntrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, mensagemErro);
                return;
            }
        }

        String[] fatorAumento = new String[]{"1 - 10%", "2 - 25%", "3 - 30%", "4 - 50%"};
        String aumentoEntrada = (String) JOptionPane.showInputDialog(null, "Selecione o código de aumento desejado", "Opções", 1, null, fatorAumento, fatorAumento[0]);

        int caso = Integer.valueOf(aumentoEntrada.substring(0, 1));
        float aumentoPercentual = 0;
        switch (caso) {
            case 1:
                aumentoPercentual = 10;
                break;
            case 2:
                aumentoPercentual = 25;
                break;
            case 3:
                aumentoPercentual = 30;
                break;
            case 4:
                aumentoPercentual = 40;
                break;
            default:
                System.out.println("Falha no sistema");
                System.exit(0);
        }

        float novoValorProduto = acrescentarPercentagem(valorProduto, aumentoPercentual);

        System.out.println("Valor inserido: R$ " + formatarValor(valorProduto));
        System.out.println("Aumento selecionado: " + formatarValor(aumentoPercentual) + "%");
        System.out.println("Valor calculado: R$ " + formatarValor(novoValorProduto));

        float novoAumento = 0;

        if (novoValorProduto > 1000 && novoValorProduto < 5000) {
            novoAumento = 1;

        } else if (novoValorProduto >= 5000.01 && novoValorProduto <= 10000) {
            novoAumento = 2;

        } else if (novoValorProduto > 10000.01) {
            novoAumento = 3;

        }

        if (novoAumento != 0) {
            System.out.println("Percentual do imposto: " + formatarValor(novoAumento) + "%");
            System.out.println("Valor com o imposto: R$ " + formatarValor(acrescentarPercentagem(novoValorProduto, novoAumento)));
        } else {
            System.out.println("Não foi necessário aplicar o imposto");
        }
    }

    private static String formatarValor(float valor) {
        return String.format("%.2f", valor);
    }

    private static float acrescentarPercentagem(float valorProduto, float aumentoPercentual) {
        return (((aumentoPercentual / 100) + 1) * valorProduto);
    }

}
