package br.ufg.espmob;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Utils {

    public static void print(String string) {
        if (!isNullOrEmpty(string)) {
            System.out.println(string.trim());
        }
    }

    public static boolean isNullOrEmpty(Object o) {
        if (o != null) {
            if (o instanceof String) {
                return ((String) o).isEmpty();

            } else if (o instanceof List && ((List) o).size() == 0) {
                return true;
            }
            return false;
        }
        return true;
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
