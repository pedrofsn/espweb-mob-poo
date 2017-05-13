package br.ufg.lab;

import br.ufg.lab.domain.Multimidia;
import br.ufg.lab.model.Cd;
import br.ufg.lab.model.Filme;
import br.ufg.lab.model.Jogo;

/*
*
* Criar 10 filmes, cds e jogos, atribuindo os valores através de construtores ou através de métodos sets.
* Armazenar os itens criados em um vetor.
* Percorrer o vetor mostrando os dados dos itens armazenados (dados comuns + dados específicos de cada item)
* Quando for jogo, mostrar separadamente a plataforma
*
* */
public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            printar(new Filme());
            printar(new Cd());
            printar(new Jogo());
        }
    }

    private static void printar(Multimidia multimidia) {
        if (multimidia != null) {

            if (multimidia instanceof Jogo) {
                System.out.println("JOGO >>> " + multimidia.toString() + "\n");
            }

            System.out.println(multimidia.toString() + "\n");
        }
    }
}