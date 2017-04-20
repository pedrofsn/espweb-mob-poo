package br.ufg.espmob.fixando;

import br.ufg.espmob.Utils;

/**
 * Created by pedrofsn on 18/04/2017.
 */
public class Main {

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Pedrofsn", 21);
        Utils.print(pessoa.toString());

        for (int i = 0; i < 5; i++) {
            pessoa.fazAniversario();
            Utils.print(pessoa.toString());
        }

//        Crie uma porta, abra e feche a mesma, pinte-a de diversas cores, altere suas dimensões e use o método
//        estaAberta para vericar se ela está aberta.

        Porta porta = new Porta();
        porta.abre();
        porta.fecha();
        porta.pinta("vermelho");
        porta.setDimensaoX(10);
        porta.setDimensaoY(10);
        porta.setDimensaoZ(10);
        Utils.print("A porta está " + (porta.estaAberta() ? "aberta" : "fechada"));

        Casa casa = new Casa();
        casa.pinta("vermelho");
        casa.setPorta1(new Porta());
        casa.setPorta2(new Porta());
        casa.setPorta3(new Porta());

        casa.getPorta1().fecha();
        casa.getPorta2().abre();
        casa.getPorta3().fecha();

        Utils.print(casa.toString());
    }

}
