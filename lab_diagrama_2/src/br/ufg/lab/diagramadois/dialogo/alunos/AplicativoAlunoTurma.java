package br.ufg.lab.diagramadois.dialogo.alunos;

import javax.swing.*;

public class AplicativoAlunoTurma {
    public static void main(String a[]) {

        final int TOTAL_ALUNOS = 5;

        Aluno aluno[] = new Aluno[TOTAL_ALUNOS];

        for (int i = 0; i < aluno.length; i++) {

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

            aluno[i] = new Aluno(matr, nome, nota1, nota2, nota3);
        }

        Turma t = new Turma(aluno);

        String result = "Media da Turma: " +
                t.media() +
                "\nA maior media da turma e' do aluno " +
                t.maiorMedia().getNome() +
                "\nA menor media da turma e' do aluno " +
                t.menorMedia().getNome();

        JOptionPane.showMessageDialog(
                null, result, "Estatisticas", JOptionPane.PLAIN_MESSAGE);

        System.exit(0);

    }
}