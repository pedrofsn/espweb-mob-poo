/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.lab.diagramaum;

/**
 * @author maratona
 */
public class Jogador {

    private String nome;
    private float peso;
    private int idade;

    public Jogador() {
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNomeEmCaixaAlta() {
        return nome == null ? "" : nome.toUpperCase();
    }

    public float getPesoArredondado() {
        return peso != 0 ? Math.round(peso) : 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
