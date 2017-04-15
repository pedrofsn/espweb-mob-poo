package br.ufg.espmob;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Utils {

    public static void print(String string) {
        if (!isNullOrEmpty(string)) {
            System.out.println(string.trim());
        }
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

    public static String getValorMonetario(double valorEntrada) {
        try {
            BigDecimal valor = new BigDecimal(valorEntrada);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            return nf.format(valor);
        } catch (Exception e) {
            return "Erro ao obter valor monetário";
        }
    }

}
