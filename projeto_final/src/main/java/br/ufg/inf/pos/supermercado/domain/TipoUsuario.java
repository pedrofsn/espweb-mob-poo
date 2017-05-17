package br.ufg.inf.pos.supermercado.domain;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public enum TipoUsuario {

    GERENTE(1), FUNCIONARIO(2), CLIENTE(3);

    private final int tipo;

    TipoUsuario(int tipo) {
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}
