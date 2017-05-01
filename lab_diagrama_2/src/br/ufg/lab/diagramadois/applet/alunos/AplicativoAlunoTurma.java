package br.ufg.lab.diagramadois.applet.alunos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AplicativoAlunoTurma extends JApplet implements ActionListener {

    int i = 1;
    private JLabel lTurma, lNome, lMatricula, lN1, lN2, lN3, lCont, lMaior,
            lMenor, lMedia, lEspaco1, lEspaco2, lEspaco3, lEspaco4,
            lHorizontal;
    private JTextField tTurma, tNome, tMatricula, tN1, tN2, tN3, tMaior,
            tMenor, tMedia, tCont;
    private JButton bDefinir, bCadastrar, bEstatistica;
    private Turma t = null;

    public void init() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        lTurma = new JLabel("Quantidade de alunos na turma:");
        lCont = new JLabel("Aluno:");
        lNome = new JLabel("Nome do aluno:");
        lMatricula = new JLabel("Matricula:");
        lN1 = new JLabel("Nota 1:");
        lN2 = new JLabel("Nota 2:");
        lN3 = new JLabel("Nota 3:");
        lMaior = new JLabel("A maior m�dia da turma � do aluno:");
        lMenor = new JLabel("A menor m�dia da turma � do aluno:");
        lMedia = new JLabel("M�dia geral da turma:                      ");
        lHorizontal = new JLabel("-------------------------------------------------------------");
        lEspaco1 = new JLabel("                                  ");
        lEspaco2 = new JLabel("                                                                                     ");
        lEspaco3 = new JLabel("                 ");
        lEspaco4 = new JLabel("                 ");
        tTurma = new JTextField(2);
        tCont = new JTextField(1);
        tCont.setText(String.valueOf(i));
        tNome = new JTextField(31);
        tMatricula = new JTextField(7);
        tN1 = new JTextField(4);
        tN2 = new JTextField(4);
        tN3 = new JTextField(4);
        tMaior = new JTextField(23);
        tMenor = new JTextField(23);
        tMedia = new JTextField(23);
        bDefinir = new JButton("Definir");
        bCadastrar = new JButton("Cadastrar");
        bEstatistica = new JButton("Estat�stica");
        bDefinir.addActionListener(this);
        bCadastrar.addActionListener(this);
        bEstatistica.addActionListener(this);

        c.add(lTurma);
        c.add(tTurma);
        c.add(bDefinir);
        c.add(lEspaco1);
        c.add(lCont);
        c.add(tCont);
        c.add(lEspaco2);
        c.add(lNome);
        c.add(tNome);
        c.add(lMatricula);
        c.add(tMatricula);
        c.add(lN1);
        c.add(tN1);
        c.add(lN2);
        c.add(tN2);
        c.add(lN3);
        c.add(tN3);
        c.add(lEspaco3);
        c.add(bCadastrar);
        c.add(bEstatistica);
        c.add(lEspaco4);
        c.add(lHorizontal);
        c.add(lMedia);
        c.add(tMedia);
        c.add(lMaior);
        c.add(tMaior);
        c.add(lMenor);
        c.add(tMenor);
        tCont.setEditable(false);
        tMaior.setEditable(false);
        tMenor.setEditable(false);
        tMedia.setEditable(false);

        desabilitaCampos();
    }

    public void actionPerformed(ActionEvent evento) {

        if (evento.getSource() == bDefinir) {
            tTurma.setEditable(false);
            t = new Turma(Integer.parseInt(tTurma.getText()));
            bDefinir.setVisible(false);
            habilitaCampos();
        }

        if (evento.getSource() == bCadastrar) {
            cadastraAluno();
            Update();
        }

        if (evento.getSource() == bEstatistica) {
            Update();
            Estatistica();
        }

    }


    public void habilitaCampos() {
        tMatricula.setEditable(true);
        tNome.setEditable(true);
        tN1.setEditable(true);
        tN2.setEditable(true);
        tN3.setEditable(true);
    }

    public void desabilitaCampos() {
        tMatricula.setEditable(false);
        tNome.setEditable(false);
        tN1.setEditable(false);
        tN2.setEditable(false);
        tN3.setEditable(false);
    }

    public void cadastraAluno() {
        int kMatricula = Integer.parseInt(tMatricula.getText());
        String kNome = String.valueOf(tNome.getText());
        double kN1 = Double.parseDouble(tN1.getText());
        double kN2 = Double.parseDouble(tN2.getText());
        double kN3 = Double.parseDouble(tN3.getText());

        Aluno aluno;
        aluno = new Aluno(kMatricula, kNome, kN1, kN2, kN3);
        t.adiciona(aluno);
        i++;
        if (t.turmaCheia()) {
            bCadastrar.setVisible(false);
            desabilitaCampos();
            Estatistica();
        }

    }

    public void Estatistica() {
        tMedia.setText(String.valueOf(t.media()));
        tMaior.setText(String.valueOf(t.maiorMedia().getNome()));
        tMenor.setText(String.valueOf(t.menorMedia().getNome()));
    }

    public void Update() {
        tCont.setText(String.valueOf(i));
        tNome.setText("");
        tMatricula.setText("");
        tN1.setText("");
        tN2.setText("");
        tN3.setText("");
    }

    public void Chega() {
        tNome.setEditable(false);
        tMatricula.setEditable(false);
        tN1.setEditable(false);
        tN2.setEditable(false);
        tN3.setEditable(false);
        bCadastrar.setVisible(false);
    }

}

/*

[14:25:35] <Shneider_FKU> declara o metodo no applet assim: private Turma t = null; criaTurma(int n) { t = new Turam(n); }
[14:26:05] <Shneider_FKU> dai os outros metodos acham o t :p
[14:26:19] <Access> humm
[14:26:37] <Access> vejo uma luz no fim do t�nel
[14:26:45] <Shneider_FKU> eh pq c vc faz isso criaTurma(int n) { Turma t = new Turma(n) }

*/
