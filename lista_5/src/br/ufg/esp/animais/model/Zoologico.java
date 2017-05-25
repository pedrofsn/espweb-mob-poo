package br.ufg.esp.animais.model;

import br.ufg.esp.Utils;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Zoologico {

    private Animal[] jaulas = new Animal[10];

    public void executar() {
        if (!Utils.isNullOrEmpty(jaulas)) {
            Utils.print("\n\nEXECUTANDO O ZOOLÓGICO:\n");
            for (Animal animal : jaulas) {

                animal.emitirSom();

                if (animal instanceof Quadrupede) {
                    ((Quadrupede) animal).correr();
                }
            }
        }
    }

    public Animal[] getJaulas() {
        return jaulas;
    }
}
