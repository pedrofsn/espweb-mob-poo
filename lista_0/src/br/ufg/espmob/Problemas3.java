/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.espmob;

import javax.swing.*;
import java.util.Scanner;

/**
 * @author aluno
 */
public class Problemas3 {

    public static void main(String[] args) {
//        validarCadastro();
        validarCPF();
    }

    public static void validarCadastro() {
        Scanner scanner = new Scanner(System.in);

        String nome, telefone;

        System.out.println("Insira um nome: ");
        nome = scanner.nextLine();

        System.out.println("Insira um telefone: ");
        telefone = scanner.nextLine();

        if (nome == null) {
            System.out.println("Nome vazio!");
            return;
        }

        if (telefone == null) {
            System.out.println("Número vazio!");
            return;
        }

        for (int i = 0; i < nome.length(); i++) {
            char c = nome.charAt(i);

            if (!Character.isAlphabetic(c)) {
                System.out.println("O nome deve possuir apenas letras! Você inseriu: " + c);
                return;
            }
        }

        System.out.println("O nome \"" + nome + "\" é válido");

        for (int i = 0; i < telefone.length(); i++) {
            char c = telefone.charAt(i);

            if (!Character.isDigit(c)) {
                System.out.println("O telefone deve possuir apenas números! Você inseriu: " + c);
                return;
            }
        }

        System.out.println("O número \"" + telefone + "\" é válido");
    }

    public static void validarCPF() {
        String cpf = JOptionPane.showInputDialog("Insira o CPF a ser validado");
        JOptionPane.showMessageDialog(null, "O CPF \"" + cpf + "\" é " + (isCPF(cpf) ? "válido" : "inválido"));
    }

    private static String calcularDigitoVerificador(String num) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer(0);
        else
            primDig = new Integer(11 - (soma % 11));
        soma = 0;
        peso = 11;
        for (int i = 0; i < num.length(); i++)
            soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer(0);
        else
            segDig = new Integer(11 - (soma % 11));
        return primDig.toString() + segDig.toString();
    }

    public static boolean isCPF(String cpf) {
        if (cpf != null && cpf.length() != 11)
            return false;
        String numDig = cpf.substring(0, 9);
        return calcularDigitoVerificador(numDig).equals(cpf.substring(9, 11));
    }
}
