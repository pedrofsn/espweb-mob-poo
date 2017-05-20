package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.utils.Utils;

/**
 * Created by pedrofsn on 20/05/2017.
 */
public class Log {

    private static Log ourInstance = new Log();
    private final StringBuilder stringBuilder = new StringBuilder();

    private Log() {
    }

    public static Log getInstance() {
        return ourInstance;
    }

    public void addLog(String tag, String string) {
        if (!Utils.isNullOrEmpty(tag) && !Utils.isNullOrEmpty(string)) {
            stringBuilder.append("\n");
            stringBuilder.append(tag.toUpperCase());
            stringBuilder.append(" : ");
            stringBuilder.append(string);
            System.out.println(stringBuilder.toString());
        }
    }
}
