package br.ufg.espmob;

/**
 * Created by pedrofsn on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();

        f1.setNome("Sérgio");
        f1.setSalario(7000);
        f1.recebeAumento(1000);

        f1.mostra();
    }

}
