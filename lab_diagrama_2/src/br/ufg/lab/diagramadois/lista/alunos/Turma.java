package br.ufg.lab.diagramadois.lista.alunos;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Turma {
    LinkedList alunos;
    int max;

    public Turma(int max) {
        this.max = max;
        alunos = new LinkedList();
    }

    public boolean adicionaAluno(Aluno aluno) {

        boolean result;

        if (this.alunos.size() == this.max)
            result = false;
        else
            result = alunos.add(aluno);

        return result;
    }

    public boolean removeAluno(Aluno aluno) {

        return alunos.remove(aluno);

    }

    public Collection getAlunos() {
        return this.alunos;
    }

    public double media() {

        double soma = 0;

        Iterator i = this.alunos.iterator();
        while (i.hasNext()) {
            Aluno aluno = (Aluno) i.next();
            soma += aluno.media();
        }

        return (soma / alunos.size());

    }

    public Aluno maiorMedia() {

        Iterator i = alunos.iterator();

        Aluno melhorAluno = (Aluno) i.next();
        double maior = melhorAluno.media();

        while (i.hasNext()) {
            Aluno aluno = (Aluno) i.next();
            if (aluno.media() > maior) {
                melhorAluno = aluno;
                maior = aluno.media();
            }
        }

        return melhorAluno;
    }

    public Aluno menorMedia() {

        Iterator i = alunos.iterator();

        Aluno piorAluno = (Aluno) i.next();
        double menor = piorAluno.media();

        while (i.hasNext()) {
            Aluno aluno = (Aluno) i.next();
            if (aluno.media() > menor) {
                piorAluno = aluno;
                menor = aluno.media();
            }
        }

        return piorAluno;
    }
}