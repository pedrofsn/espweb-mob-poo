/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.lab.diagramaum;

/**
 * @author maratona
 */
public class Time {

    private Jogador[] jogadores = new Jogador[23];
    private String nome;
    private int quantidadeJogadores;

    public Time() {
    }

    public Time(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeMaioresIdade() {
        if (jogadores.length > 0) {
            return jogadores.length - getQuantidadeMenoresIdade();
        }

        return 0;
    }

    public int getQuantidadeMenoresIdade() {
        int contador = 0;

        if (jogadores.length > 0) {
            for (Jogador jogador : jogadores) {
                if (jogador != null && jogador.getIdade() < 18) {
                    contador++;
                }
            }
        }

        return contador;
    }

    public String getNomeEmCaixaAlta() {
        return nome == null ? "" : nome.toUpperCase();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void incluiJogador(String nomeJog, int idade, float peso) {
        if (quantidadeJogadores < jogadores.length) {
            Jogador novoJogador = new Jogador();
            novoJogador.setNome(nomeJog);
            novoJogador.setIdade(idade);
            novoJogador.setPeso(peso);
            jogadores[quantidadeJogadores] = novoJogador;
            quantidadeJogadores++;
        } else {
            System.out.println("\nNao pode ser incluido mais jogadores!");
        }
    }

    public float calcularPesoMedioTime() {
        float pesoMedio = 0;

        for (int i = 0; i < jogadores.length; i++) {
            pesoMedio = (pesoMedio + jogadores[i].getPeso());
        }
        pesoMedio = pesoMedio / jogadores.length;

        return pesoMedio;
    }

    public float calcularIdadeMedioTime() {
        float idadeMedia = 0;

        for (int i = 0; i < jogadores.length; i++) {
            idadeMedia = (idadeMedia + jogadores[i].getIdade());
        }
        idadeMedia = idadeMedia / jogadores.length;

        return idadeMedia;
    }
}
