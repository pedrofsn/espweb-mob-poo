package br.ufg.lab.diagramadois.applet.alunos;

public class Aluno {

    private int matr;
    private String nome;
    private double nota1;
    private double nota2;
    private double nota3;

    public Aluno(int matr, String nome) {
        setMatr(matr);
        setNome(nome);
        setNotas(0, 0, 0);
    }

    public Aluno(int matr, String nome, double nota1, double nota2, double nota3) {
        setMatr(matr);
        setNome(nome);
        setNotas(nota1, nota2, nota3);
    }

    public void setNotas(double nota1, double nota2, double nota3) {
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public int getMatr() {
        return matr;
    }

    public void setMatr(int matr) {
        this.matr = matr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota13() {
        return nota3;
    }

    public double maiorNota() {

        double maior = nota1;

        if (nota2 > maior)
            maior = nota2;
        if (nota3 > maior)
            maior = nota3;

        return maior;
    }

    public double media() {
        return ((nota1 + nota2 + nota3) / 3);
    }

    public boolean aprovado() {
        return (media() >= 7);
    }
}
