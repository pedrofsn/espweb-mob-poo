package br.ufg.inf.pos.supermercado.utils;

import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Utils {

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

}
