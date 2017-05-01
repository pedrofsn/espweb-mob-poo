package br.ufg.lab.diagramadois.applet.alunos;

public class Turma {
    Aluno[] aluno;
    int maximo;
    int atual = 0;

    public Turma(int maximo) {
        this.maximo = maximo;
        this.atual = 0;
        this.aluno = new Aluno[maximo];
    }

    public void adiciona(Aluno a) {
        turmaCheia();
        aluno[atual] = a;
        atual++;
    }

    public boolean turmaCheia() {
        if (atual >= maximo) {
            return true;
        }
        return false;
    }


    public double media() {
        double soma = 0;
        for (int i = 0; i < atual; i++)
            soma += aluno[i].media();
        return (soma / atual);
    }

    public Aluno maiorMedia() {
        Aluno melhorAluno = aluno[0];
        double maior = aluno[0].media();
        for (int i = 0; i < atual; i++)
            if (aluno[i].media() > maior) {
                melhorAluno = aluno[i];
                maior = aluno[i].media();
            }
        return melhorAluno;
    }

    public Aluno menorMedia() {
        Aluno piorAluno = aluno[0];
        double menor = aluno[0].media();
        for (int i = 1; i < atual; i++)
            if (aluno[i].media() < menor) {
                piorAluno = aluno[i];
                menor = aluno[i].media();
            }
        return piorAluno;
    }
}
