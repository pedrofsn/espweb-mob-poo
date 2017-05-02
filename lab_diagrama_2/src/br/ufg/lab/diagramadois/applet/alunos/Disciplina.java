package br.ufg.lab.diagramadois.applet.alunos;

/**
 * Created by pedrofsn on 01/05/2017.
 */
public class Disciplina {

    private String nome;
    private int cargaHoraria;

    public Disciplina(String nome) {
        this.nome = nome;
    }

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }

    public boolean is64h() {
        return 64 == cargaHoraria;
    }
}
