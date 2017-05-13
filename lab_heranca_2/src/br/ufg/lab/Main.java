package br.ufg.lab;

import br.ufg.lab.model.Cd;
import br.ufg.lab.model.Filme;
import br.ufg.lab.model.Jogo;
import br.ufg.lab.model.MinhaLista;

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

        MinhaLista minhaLista = new MinhaLista();

        Jogo jogo = new Jogo();
        Filme filme = new Filme();
        Cd cd = new Cd();

        minhaLista.add(jogo);
        minhaLista.add(filme);
        minhaLista.add(cd);
        minhaLista.remove(cd);

        System.out.println("Quantidade de Jogos: " + minhaLista.getQuantidadeJogo());
        System.out.println("Quantidade de CD: " + minhaLista.getQuantidadeCd());
        System.out.println("Quantidade de Filmes: " + minhaLista.getQuantidadeFilme());
    }


}