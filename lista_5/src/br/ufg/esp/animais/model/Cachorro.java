package br.ufg.esp.animais.model;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/2017.
 */
public class Cachorro extends Quadrupede {

    @Override
    public void correr() {
        Utils.print("Cachorro correndo");
    }

    @Override
    public void emitirSom() {
        Utils.print("latir");
    }
}
