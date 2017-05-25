package br.ufg.esp.empresas;

/**
 * Created by pedrofsn on 24/05/2017.
 */
public class Comissao {

    private static final int VALOR_GERENTE = 1500;
    private static final int VALOR_SUPERVISOR = 600;
    private static final int VALOR_VENDEDOR = 250;

    public static final int TIPO_GERENTE = 0;
    public static final int TIPO_SUPERVISOR = 1;
    public static final int TIPO_VENDEDOR = 2;

    private int tipo;

    public Comissao(int tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        switch (tipo) {
            case TIPO_GERENTE:
                return VALOR_GERENTE;

            case TIPO_SUPERVISOR:
                return VALOR_SUPERVISOR;

            case TIPO_VENDEDOR:
                return VALOR_VENDEDOR;

            default:
                return 0.0;
        }
    }

}
