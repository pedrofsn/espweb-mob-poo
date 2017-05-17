package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.utils.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class MyUI {

    private static Scanner scanner = new Scanner(System.in);

    protected static void print(Exception e) {
        if (!Utils.isNullOrEmpty(e)) {
            limparTela();
            print(String.format("[%s]", e.getMessage().toUpperCase()));
        }
    }

    protected static void print(String string) {
        if (!Utils.isNullOrEmpty(string)) {
            System.out.println(string.trim());
        }
    }

    protected static void limparTela() {
        // FAKE
        // Reference: http://stackoverflow.com/a/38365871/1565769
        for (int i = 0; i < 80 * 300; i++)//Default Height of cmd is 300 and Default width is 80
            System.out.println("\b");//prints a backspace
    }

    protected static String getValorMonetario(double valorEntrada) {
        try {
            BigDecimal valor = new BigDecimal(valorEntrada);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            return nf.format(valor);
        } catch (Exception e) {
            return "Erro ao obter valor monetário";
        }
    }

    protected static Scanner getScanner() {
        return scanner;
    }
}
