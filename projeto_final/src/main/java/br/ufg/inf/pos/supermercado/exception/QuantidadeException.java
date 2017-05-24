package br.ufg.inf.pos.supermercado.exception;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class QuantidadeException extends IndexOutOfBoundsException {

    public QuantidadeException(String message) {
        super("[NÃO FOI POSSÍVEL ADICIONAR O PRODUTO AO CARRINHO: Código Inválido]");
    }
}
