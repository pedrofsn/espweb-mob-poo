package br.ufg.espmob.lista3.exercicio2;

import br.ufg.espmob.Utils;

import java.util.ArrayList;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Racional {

    private int numerador;
    private int denominador;

    public Racional() {
        this.numerador = 1;
        this.denominador = 2;
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public Racional soma(Racional r1, Racional r2) {
        if(r1 != null && r2 != null) {
            if(isDenominadoresComum(r1, r2)) {
                int resultadoNumerador = r1.getNumerador() + r2.getNumerador();
                return new Racional(resultadoNumerador, r1.getDenominador());
            } else {
                // CASO DO MMC

            }
        }

        return null;
    }

    private boolean isDenominadoresComum(Racional r1, Racional r2) {
        return r1.getDenominador() == r2.getDenominador();
    }

    public boolean isDenominadoresIguais(Racional r1, Racional r2) {
        return !Utils.isNullOrEmpty(r1);
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    private static  int mmc(int a,int b){
        boolean bol = true;
        int aa = a;
        int bb = b;
        a =0;
        b =0;
        ArrayList aaa = new ArrayList();
        ArrayList bbb = new ArrayList();
        while(bol){
            a = a + aa;
            b = b + bb;
            aaa.add(a);
            bbb.add(b);
            for (int i =0;i < aaa.size();i++){
                for(int o =0;o < bbb.size();o++){
                    if(aaa.get(i) == bbb.get(o) && Integer.parseInt(aaa.get(i).toString()) != 0){
                        bol = false;
                        return Integer.parseInt(aaa.get(i).toString());
                    }
                }
            }
        }
        return 0;
    }
}
