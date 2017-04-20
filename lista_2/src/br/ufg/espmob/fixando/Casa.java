package br.ufg.espmob.fixando;

/**
 * Created by pedrofsn on 19/04/2017.
 */
public class Casa {

    private String cor;
    private Porta porta1;
    private Porta porta2;
    private Porta porta3;

    public void pinta(String cor) {
        setCor(cor);
    }

    @Override
    public String toString() {
        return "Quantidade de portas abertas na casa: " + quantasPortasEstaoAbertas();
    }

    public int quantasPortasEstaoAbertas() {
        int contador = 0;
        contador = porta1.isAberta() ? contador + 1 : contador;
        contador = porta2.isAberta() ? contador + 1 : contador;
        contador = porta3.isAberta() ? contador + 1 : contador;
        return contador;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Porta getPorta1() {
        return porta1;
    }

    public void setPorta1(Porta porta1) {
        this.porta1 = porta1;
    }

    public Porta getPorta2() {
        return porta2;
    }

    public void setPorta2(Porta porta2) {
        this.porta2 = porta2;
    }

    public Porta getPorta3() {
        return porta3;
    }

    public void setPorta3(Porta porta3) {
        this.porta3 = porta3;
    }
}
