package br.ufg.esp.animais.model;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Veterinario {

    public void examinar(Animal[] animais) {
        if (!Utils.isNullOrEmpty(animais)) {
            for (Animal animal : animais) {
                examinar(animal);
            }
        }
    }

    public void examinar(Animal animal) {
        if (!Utils.isNullOrEmpty(animal)) {
            Utils.print("Examinando...");
            animal.emitirSom();
        }
    }

}
