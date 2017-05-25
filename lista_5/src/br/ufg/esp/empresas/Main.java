package br.ufg.esp.empresas;

import br.ufg.esp.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 24/05/2017.
 * 10. Refaça o enunciado 7 considerando que 10% dos funcionários são Gerentes, 20%
 * são Supervisores e 70% são Vendedores.
 */
public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario(0, new Estudo(Estudo.BASICO), new Comissao(Comissao.TIPO_GERENTE)));
        funcionarios.add(new Funcionario(1, new Estudo(Estudo.BASICO), new Comissao(Comissao.TIPO_SUPERVISOR)));
        funcionarios.add(new Funcionario(2, new Estudo(Estudo.BASICO), new Comissao(Comissao.TIPO_SUPERVISOR)));
        funcionarios.add(new Funcionario(3, new Estudo(Estudo.BASICO), new Comissao(Comissao.TIPO_VENDEDOR)));

        funcionarios.add(new Funcionario(4, new Estudo(Estudo.MEDIO), new Comissao(Comissao.TIPO_VENDEDOR)));
        funcionarios.add(new Funcionario(5, new Estudo(Estudo.MEDIO), new Comissao(Comissao.TIPO_VENDEDOR)));
        funcionarios.add(new Funcionario(6, new Estudo(Estudo.MEDIO), new Comissao(Comissao.TIPO_VENDEDOR)));
        funcionarios.add(new Funcionario(7, new Estudo(Estudo.MEDIO), new Comissao(Comissao.TIPO_VENDEDOR)));

        funcionarios.add(new Funcionario(8, new Estudo(Estudo.GRADUACAO), new Comissao(Comissao.TIPO_VENDEDOR)));
        funcionarios.add(new Funcionario(9, new Estudo(Estudo.GRADUACAO), new Comissao(Comissao.TIPO_VENDEDOR)));

        double totalSalariosSemEstudo = 0.0;
        double totalSalariosBasico = 0.0;
        double totalSalariosMedio = 0.0;
        double totalSalariosGraduacao = 0.0;

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEstudo().isSemEstudo()) {
                totalSalariosSemEstudo += funcionario.getRendaTotal();

            } else if (funcionario.getEstudo().isBasico()) {
                totalSalariosBasico += funcionario.getRendaTotal();

            } else if (funcionario.getEstudo().isMedio()) {
                totalSalariosMedio += funcionario.getRendaTotal();

            } else if (funcionario.getEstudo().isGraduacao()) {
                totalSalariosGraduacao += funcionario.getRendaTotal();
            }
        }

        double totalSalarios = totalSalariosSemEstudo + totalSalariosBasico + totalSalariosMedio + totalSalariosGraduacao;

        Utils.print("O salário total dos " + funcionarios.size() + " funcionários são de " + Utils.getValorMonetario(totalSalarios));
        Utils.print("A soma dos salários dos funcionários SEM ESTUDO é de " + Utils.getValorMonetario(totalSalariosSemEstudo));
        Utils.print("A soma dos salários dos funcionários COM NÍVEL BÁSICO é de " + Utils.getValorMonetario(totalSalariosBasico));
        Utils.print("A soma dos salários dos funcionários COM NÍVEL MÉDIO é de " + Utils.getValorMonetario(totalSalariosMedio));
        Utils.print("A soma dos salários dos funcionários COM GRADUAÇÃO é de " + Utils.getValorMonetario(totalSalariosGraduacao));

        Utils.print("\nVALORES:\n");
        for (Funcionario f : funcionarios) {
            Utils.print(f.toString());
        }
    }

}
