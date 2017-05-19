package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Ui {

    private static final String[] CASOS_POSITIVOS = new String[]{"Sim", "Ok", "S", "1"};
    private static final String[] CASOS_NEGATIVOS = new String[]{"Não", "not", "N", "0"};
    private static Scanner scanner = new Scanner(System.in);

    protected static boolean getRespostaSimOuNao(String mensagem) {
        boolean encontrouValorCorreto = true;

        while (encontrouValorCorreto) {
            print(mensagem + " <Sim/Não>");
            String entrada = scanner.next();

            if (!Utils.isNullOrEmpty(entrada)) {
                for (String casoNegativo : CASOS_NEGATIVOS) {
                    if (casoNegativo.equalsIgnoreCase(entrada)) {
                        return false;
                    }
                }

                for (String casoPositivo : CASOS_POSITIVOS) {
                    if (casoPositivo.equalsIgnoreCase(entrada)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    protected static void print(Map<Integer, Double> carrinho) {
        if (!Utils.isNullOrEmpty(carrinho)) {
            print("\n\n");
            print("<Carrinho>");
            for (Map.Entry<Integer, Double> item : carrinho.entrySet()) {
                print("Produto: " + item.getKey() + " / Quantidade: " + item.getValue());
            }
            print("\n\n");
        }
    }

    protected static void print(List list) {
        if (!Utils.isNullOrEmpty(list)) {
            for (int i = 0; i < list.size(); i++) {
                print(list.get(i).toString());
            }
        }
    }

    protected static void print(Exception e) {
        if (!Utils.isNullOrEmpty(e) && !Utils.isNullOrEmpty(e.getMessage())) {
            limparTela();
            print(String.format("[%s]", e.getMessage().toUpperCase()));
        } else {
            e.printStackTrace();
        }
    }

    protected static void print(String string) {
        if (!Utils.isNullOrEmpty(string)) {
            System.out.println(string.trim());
        }
    }

    protected static String listToString(List<Integer> l) {
        if (!Utils.isNullOrEmpty(l)) {
            StringBuffer stringBuffer = new StringBuffer();

            for (int i = 0; i < l.size(); i++) {
                Integer obj = l.get(i);
                stringBuffer.append(obj);

                if (l.size() - 1 != i) {
                    stringBuffer.append(", ");
                }
            }

            return stringBuffer.toString();
        }
        return Constantes.STRING_VAZIA;
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

