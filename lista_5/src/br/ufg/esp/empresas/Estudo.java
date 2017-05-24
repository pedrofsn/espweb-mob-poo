package br.ufg.esp.empresas;

/**
 * Created by pedrofsn on 24/05/17.
 */
public class Estudo {

    public static final int SEM_ESTUDO = 0;
    public static final int BASICO = 1;
    public static final int MEDIO = 2;
    public static final int GRADUACAO = 3;

    private String instituicao;
    private int nivel;

    public Estudo(int nivel) {
        this.instituicao = "Instituição " + nivel;
        this.nivel = nivel;
    }

    public boolean isSemEstudo(){return SEM_ESTUDO == nivel;};

    public boolean isBasico(){return BASICO == nivel;};

    public boolean isMedio(){return MEDIO == nivel;};

    public boolean isGraduacao(){return GRADUACAO == nivel;};

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public double calcularSalario(double renda) {
        double valor = 0.0;

        if (nivel > SEM_ESTUDO) {
            if (nivel <= BASICO) {
                valor += (10/100) * renda + renda;
            }

            if (nivel <= MEDIO) {
                valor += (50/100) * renda + renda;
            }

            if (nivel <= GRADUACAO) {
                valor += (100/100) * renda + renda;
            }
        }

        return valor;
    }

}
