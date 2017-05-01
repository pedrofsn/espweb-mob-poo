package br.ufg.lab.diagramadois.lista.alunos;

import javax.swing.*;

public class AplicativoAlunoTurma {
    public static void main(String a[]) {

        final int TOTAL_ALUNOS = 5;

        Aluno aluno;
        Turma turma = new Turma(40);

        for (int i = 0; i < TOTAL_ALUNOS; i++) {

            int k = i + 1;
            String nome =
                    JOptionPane.showInputDialog("Nome do " + k + "o. aluno: ");

            String matrAux =
                    JOptionPane.showInputDialog("Matricula do " + k + "o. aluno: ");
            int matr = Integer.parseInt(matrAux);

            String nota1Aux =
                    JOptionPane.showInputDialog("Nota 1 do " + k + "o. aluno: ");
            int nota1 = Integer.parseInt(nota1Aux);

            String nota2Aux =
                    JOptionPane.showInputDialog("Nota 2 do " + k + "o. aluno: ");
            int nota2 = Integer.parseInt(nota2Aux);

            String nota3Aux =
                    JOptionPane.showInputDialog("Nota 3 do " + k + "o. aluno: ");
            int nota3 = Integer.parseInt(nota3Aux);

            aluno = new Aluno(matr, nome, nota1, nota2, nota3);
            turma.adicionaAluno(aluno);
        }

        String result = "Media da Turma: " +
                turma.media() +
                "\nA maior media da turma e' do aluno " +
                turma.maiorMedia().getNome() +
                "\nA menor media da turma e' do aluno " +
                turma.menorMedia().getNome();

        JOptionPane.showMessageDialog(
                null, result, "Estatisticas", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);

    }
}