package br.ufg.espmob;

import javax.swing.*;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio2 {

    /*
    *   Crie um programa para cálculo do salário líquido em que três valores devem ser informados pelo
    *   usuário em janelas de entrada: a quantidade de horas trabalhadas, o salário hora e o número de
    *   dependentes. O programa deve mostrar em janela de saída com as seguintes informações:
    *
    *   Informação dos Cálculos:
    *       Salário Bruto: Horas trabalhadas * salário hora + (50 * número de dependentes)
    *
    *   Desconto INSS:
    *       Se salário bruto <= 1000 INSS=salário bruto * 8.5/100
    *       Se salário bruto > 1000 INSS=salário bruto * 9/100
    *
    *   Desconto IR:
    *       Se salário bruto <= 500 IR=0
    *       Se salário bruto > 500 e <= 1000 IR=salário bruto*5/100
    *       Se salário bruto > 1000 IR=salário bruto*7/100
    *
    *   Salário líquido:
    *       Salário bruto - INSS – IR
    * */
    public static void main(String[] args) {
        double horasTrabalhadas = obterValor("horas trabalhadas");
        double salarioHora = obterValor("salário hora");
        double numeroDependentes = obterValor("número de dependentes");

        if (horasTrabalhadas > 0 && salarioHora > 0) {

            double salarioBruto = calcularSalarioBruto(horasTrabalhadas, salarioHora, numeroDependentes);
            double descontoINSS = calcularDescontoINSS(salarioBruto);
            double valorIR = calcularIR(salarioBruto);
            calcularSalarioLiquido(salarioBruto, descontoINSS, valorIR);

        } else {
            JOptionPane.showMessageDialog(null, "Confira os valores de entrada");
        }
    }

    private static void calcularSalarioLiquido(double salarioBruto, double descontoINSS, double valorIR) {
        double salarioLiquido = salarioBruto - descontoINSS - valorIR;
        System.out.println("Salário líquido: " + Utils.getValorMonetario(salarioLiquido));
    }

    private static double calcularIR(double salarioBruto) {
        double valorIR = 0;

        if (salarioBruto <= 500) {
            valorIR = 0;

        } else if (salarioBruto > 500 && salarioBruto <= 1000) {
            valorIR = salarioBruto * (double) 5 / 100;

        } else if (salarioBruto > 1000) {
            valorIR = salarioBruto * (double) 7 / 100;
        }

        System.out.println("Valor do IR: " + Utils.getValorMonetario(valorIR));
        return valorIR;
    }

    private static double calcularDescontoINSS(double salarioBruto) {
        double descontoINSS = 0;

        if (salarioBruto <= 100) {
            descontoINSS = salarioBruto * (double) 8.5 / 100;
        } else {
            descontoINSS = salarioBruto * (double) 9 / 100;
        }

        System.out.println("Desconto do INSS: " + Utils.getValorMonetario(descontoINSS));
        return descontoINSS;
    }

    private static double calcularSalarioBruto(double horasTrabalhadas, double salarioHora, double numeroDependentes) {
        double salarioBruto = horasTrabalhadas * salarioHora + (50 * (int) numeroDependentes);
        System.out.println("Salário bruto: " + Utils.getValorMonetario(salarioBruto));
        return salarioBruto;
    }

    private static double obterValor(String mensagem) {
        String valorEntrada = JOptionPane.showInputDialog("Insira o valor de " + mensagem);
        String mensagemErro = "Valor vazio ou inválido";
        double valorProduto;

        if (valorEntrada == null || "".equals(valorEntrada.trim())) {
            JOptionPane.showMessageDialog(null, mensagemErro);
        } else {
            try {
                valorProduto = Double.valueOf(valorEntrada);
                return valorProduto;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, mensagemErro);
            }
        }

        return -1;
    }

}
