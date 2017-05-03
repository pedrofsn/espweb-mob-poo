package br.ufg.espmob.lista3.exercicio1;

/**
 * Created by pedrofsn on 02/05/2017.
 */
public class Complexo {

    private float parteReal;
    private float parteImaginaria;

    public Complexo(float parteReal) {
        this.parteReal = parteReal;
    }

    public Complexo() {
        this.parteReal = 10;
        this.parteImaginaria = 10;
    }

    public float somar(Complexo c1, Complexo c2) {
        return c1.getParteReal() + c2.getParteReal() + c1.getParteImaginaria() + c2.getParteImaginaria();
    }

    public float subtrair(Complexo c1, Complexo c2) {
        return c1.getParteReal() - c2.getParteReal() + c1.getParteImaginaria() - c2.getParteImaginaria();
    }

    public String printar() {
        return printar(this);
    }

    public String printar(Complexo complexo) {
        return "(" + complexo.getParteReal() + ", " + complexo.getParteImaginaria() + ")";
    }

    public float getComplexo() {
        return (float) (parteReal + parteImaginaria * Math.sqrt(-1));
    }

    public float getParteReal() {
        return parteReal;
    }

    public void setParteReal(float parteReal) {
        this.parteReal = parteReal;
    }

    public float getParteImaginaria() {
        return parteImaginaria;
    }

    public void setParteImaginaria(float parteImaginaria) {
        this.parteImaginaria = parteImaginaria;
    }
}
