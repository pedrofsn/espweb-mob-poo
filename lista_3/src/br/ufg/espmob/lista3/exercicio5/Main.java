package br.ufg.espmob.lista3.exercicio5;

import br.ufg.espmob.Utils;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 35; i++) {
            Comerciario obj = new Comerciario();
            Utils.print(i + ") Salário Bruto: " + obj.getSalarioBruto());
            Utils.print(i + ") Salário Líquido: " + obj.getSalarioLiquido());
        }
    }

}
