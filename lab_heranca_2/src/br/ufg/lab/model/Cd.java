package br.ufg.lab.model;

import br.ufg.lab.domain.Multimidia;

/**
 * Created by aluno on 13/05/17.
 */
public class Cd extends Multimidia {

    private String artista;
    private int quantidadeFaixas;

    public Cd() {
        this.artista = getRandom().nextBoolean() ? "Diego" : "Tarcísio";
        this.quantidadeFaixas = getRandom().nextInt(15);
    }

    @Override
    public String toString() {
        return "CD com " + quantidadeFaixas + " faixas do " + artista + ", " + super.toString();
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getQuantidadeFaixas() {
        return quantidadeFaixas;
    }

    public void setQuantidadeFaixas(int quantidadeFaixas) {
        this.quantidadeFaixas = quantidadeFaixas;
    }
}
