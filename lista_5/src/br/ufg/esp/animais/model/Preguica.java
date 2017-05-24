package br.ufg.esp.animais.model;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Preguica extends Animal {

    @Override
    public void emitirSom() {
        Utils.print("Emitir som de preguiça");
    }

}
