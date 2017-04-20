package br.ufg.espmob.desafio;

import java.util.Calendar;

/**
 * Created by pedrofsn on 18/04/2017.
 */
public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data() {
        this.dia = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        this.mes = Calendar.getInstance().get(Calendar.MONTH) + 1;
        this.ano = Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String formatada() {
        return dia + "/" + mes + "/" + ano;
    }
}
