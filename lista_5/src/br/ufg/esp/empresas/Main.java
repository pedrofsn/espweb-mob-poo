package br.ufg.esp.empresas;

import br.ufg.esp.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 24/05/2017.
 * Crie um programa que simule uma empresa com 10 funcionários. Utilize um array,
 * sendo que a escolaridade dos funcionários seja distribuída da seguinte forma: 40% ensino
 * básico, 40% ensino médio e 20% nível superior. Calcule os custos da empresa com
 * salários totais e por nível de escolaridade. Utilize a classe funcionário desenvolvida no
 * enunciado anterior
 */
public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(0, new Estudo(Estudo.BASICO)));
        funcionarios.add(new Funcionario(1, new Estudo(Estudo.BASICO)));
        funcionarios.add(new Funcionario(2, new Estudo(Estudo.BASICO)));
        funcionarios.add(new Funcionario(3, new Estudo(Estudo.BASICO)));

        funcionarios.add(new Funcionario(4, new Estudo(Estudo.MEDIO)));
        funcionarios.add(new Funcionario(5, new Estudo(Estudo.MEDIO)));
        funcionarios.add(new Funcionario(6, new Estudo(Estudo.MEDIO)));
        funcionarios.add(new Funcionario(7, new Estudo(Estudo.MEDIO)));

        funcionarios.add(new Funcionario(8, new Estudo(Estudo.GRADUACAO)));
        funcionarios.add(new Funcionario(9, new Estudo(Estudo.GRADUACAO)));

        double totalSalariosSemEstudo = 0.0;
        double totalSalariosBasico = 0.0;
        double totalSalariosMedio = 0.0;
        double totalSalariosGraduacao = 0.0;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEstudo().isSemEstudo()) {
                totalSalariosSemEstudo += funcionario.getSalario();

            } else if (funcionario.getEstudo().isBasico()) {
                totalSalariosBasico += funcionario.getSalario();

            } else if (funcionario.getEstudo().isMedio()) {
                totalSalariosMedio += funcionario.getSalario();

            } else if (funcionario.getEstudo().isGraduacao()) {
                totalSalariosGraduacao += funcionario.getSalario();
            }
        }

        double totalSalarios = totalSalariosSemEstudo + totalSalariosBasico + totalSalariosMedio + totalSalariosGraduacao;

        Utils.print("O salário total dos " + funcionarios.size() + " funcionários são de " + Utils.getValorMonetario(totalSalarios));
        Utils.print("A soma dos salários dos funcionários SEM ESTUDO é de " + Utils.getValorMonetario(totalSalariosSemEstudo));
        Utils.print("A soma dos salários dos funcionários COM NÍVEL BÁSICO é de " + Utils.getValorMonetario(totalSalariosBasico));
        Utils.print("A soma dos salários dos funcionários COM NÍVEL MÉDIO é de " + Utils.getValorMonetario(totalSalariosMedio));
        Utils.print("A soma dos salários dos funcionários COM GRADUAÇÃO é de " + Utils.getValorMonetario(totalSalariosGraduacao));
    }

}
