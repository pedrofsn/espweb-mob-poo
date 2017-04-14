package br.ufg.espmob;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Utils {

    public static String getValorMonetario(float valorEntrada) {
        try {
            BigDecimal valor = new BigDecimal(valorEntrada);
            NumberFormat nf = NumberFormat.getCurrencyInstance();
            return nf.format(valor);
        } catch (Exception e) {
            return "Erro ao obter valor monetário";
        }
    }

}
