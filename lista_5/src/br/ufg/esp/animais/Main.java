package br.ufg.esp.animais;

import br.ufg.esp.animais.model.*;

public class Main {

    public static void main(String[] args) {

        // Exercício 1
        Cavalo cavalo = new Cavalo();
        Cachorro cachorro = new Cachorro();
        Preguica preguica = new Preguica();

        Animal[] animais = new Animal[]{cavalo, cachorro, preguica};

        // Exercício 2
        for (Animal animal : animais) {
            animal.emitirSom();
        }

        // Exercício 3
        Veterinario veterinario = new Veterinario();
        veterinario.examinar(animais);

        // Exercício 4
        Zoologico zoologico = new Zoologico();
        zoologico.getJaulas()[0] = new Cavalo();
        zoologico.getJaulas()[1] = new Cachorro();
        zoologico.getJaulas()[2] = new Preguica();
        zoologico.getJaulas()[3] = new Preguica();
        zoologico.getJaulas()[4] = new Cavalo();
        zoologico.getJaulas()[5] = new Cachorro();
        zoologico.getJaulas()[6] = new Cavalo();
        zoologico.getJaulas()[7] = new Preguica();
        zoologico.getJaulas()[8] = new Cavalo();
        zoologico.getJaulas()[9] = new Cachorro();
        zoologico.executar();

    }
}
