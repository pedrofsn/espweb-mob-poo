/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.lab.diagramaum;

/**
 * @author maratona
 */
public class Main {

    public static void main(String[] args) {

        Torneio torneio = new Torneio();

        Time time1 = new Time();
        Time time2 = new Time();

        time1.setNome("Vila Nova");
        time1.incluiJogador("A", 17, 70);
        time1.incluiJogador("B", 18, 90);
        time1.incluiJogador("C", 19, 70);
        time1.incluiJogador("D", 20, 70);
        time1.incluiJogador("E", 15, 70);
        time1.incluiJogador("F", 21, 70);
        time1.incluiJogador("G", 30, 70);
        time1.incluiJogador("H", 31, 70);
        time1.incluiJogador("I", 32, 65);
        time1.incluiJogador("L", 34, 70);
        time1.incluiJogador("M", 30, 70);
        time1.incluiJogador("N", 22, 70);
        time1.incluiJogador("O", 20, 70);
        time1.incluiJogador("P", 20, 50);
        time1.incluiJogador("Q", 21, 70);
        time1.incluiJogador("R", 20, 70);
        time1.incluiJogador("S", 15, 65);
        time1.incluiJogador("T", 16, 70);
        time1.incluiJogador("U", 17, 70);
        time1.incluiJogador("V", 18, 70);
        time1.incluiJogador("X", 19, 70);
        time1.incluiJogador("Z", 21, 70);
        time1.incluiJogador("Y", 22, 70);

        time2.setNome("Goiás");
        time2.incluiJogador("AD", 17, 70);
        time2.incluiJogador("BD", 18, 70);
        time2.incluiJogador("CD", 19, 70);
        time2.incluiJogador("DD", 20, 70);
        time2.incluiJogador("ED", 15, 70);
        time2.incluiJogador("FD", 15, 70);
        time2.incluiJogador("GD", 18, 70);
        time2.incluiJogador("HD", 17, 70);
        time2.incluiJogador("ID", 16, 65);
        time2.incluiJogador("LD", 17, 55);
        time2.incluiJogador("MD", 30, 50);
        time2.incluiJogador("ND", 22, 45);
        time2.incluiJogador("OD", 20, 50);
        time2.incluiJogador("PD", 20, 50);
        time2.incluiJogador("QD", 21, 60);
        time2.incluiJogador("RD", 20, 55);
        time2.incluiJogador("SD", 15, 65);
        time2.incluiJogador("TD", 16, 70);
        time2.incluiJogador("UD", 17, 55);
        time2.incluiJogador("VD", 18, 60);
        time2.incluiJogador("XD", 19, 60);
        time2.incluiJogador("ZD", 21, 65);
        time2.incluiJogador("YD", 22, 70);

        torneio.incluirTime(time1);
        //torneio.incluirTime(time2);

        System.out.println("Time: " + time1.getNome());
        System.out.println("Media peso:" + time1.calcularPesoMedioTime());
        System.out.println("Media idade:" + time1.calcularIdadeMedioTime());

        System.out.println("Time: " + time2.getNome());
        System.out.println("Media peso:" + time2.calcularPesoMedioTime());
        System.out.println("Media idade:" + time2.calcularIdadeMedioTime());

        System.out.println("Quantidade times no torneio:" + torneio.quantidadeTime());

        System.out.println("Peso medio dos participantes:" + torneio.calcularPesoMedioParticipantes());
        System.out.println("Idade media dos participantes:" + torneio.calcularIdadeMediaParticipantes());
    }

}
