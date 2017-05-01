package br.ufg.lab.diagramadois.dialogo.alunos;

public class Turma {
    Aluno[] aluno;

    public Turma(Aluno[] aluno) {
        this.aluno = aluno;
    }

    public double media() {
        double soma = 0;
        for (int i = 0; i < aluno.length; i++)
            soma += aluno[i].media();
        return (soma / aluno.length);
    }

    public Aluno maiorMedia() {
        Aluno melhorAluno = aluno[0];
        double maior = aluno[0].media();
        for (int i = 0; i < aluno.length; i++)
            if (aluno[i].media() > maior) {
                melhorAluno = aluno[i];
                maior = aluno[i].media();
            }
        return melhorAluno;
    }

    public Aluno menorMedia() {
        Aluno piorAluno = aluno[0];
        double menor = aluno[0].media();
        for (int i = 1; i < aluno.length; i++)
            if (aluno[i].media() < menor) {
                piorAluno = aluno[i];
                menor = aluno[i].media();
            }
        return piorAluno;
    }
}


