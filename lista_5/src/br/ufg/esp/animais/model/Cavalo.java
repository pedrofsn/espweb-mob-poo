package br.ufg.esp.animais.model;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Cavalo extends Quadrupede {

    @Override
    public void correr() {
        Utils.print("Trotando");
    }

    @Override
    public void emitirSom() {
        Utils.print("relinchar");
    }
}
