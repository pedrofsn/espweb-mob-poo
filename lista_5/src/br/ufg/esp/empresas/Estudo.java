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

    public Estudo(String instituicao, int nivel) {
        this.instituicao = instituicao;
        this.nivel = nivel;
    }

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
}
