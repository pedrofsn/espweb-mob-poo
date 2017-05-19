package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pedrofsn on 18/05/2017.
 */
public class Compra {

    private Map<Integer, Double> carrinho = new HashMap<>();
    private int tipoPagamento = Constantes.FORMA_PAGAMENTO_CARTAO;
    private Integer codigoCaixa = null;

    public void adicionarProdutoNaCompra(Produto produtoSelecionado, Double quantiaDesejada) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(produtoSelecionado)) {
            double quantidadeMaximaPermitida = produtoSelecionado.getQuantidade();

            if (quantiaDesejada <= quantidadeMaximaPermitida) {
                carrinho.put(produtoSelecionado.getCodigo(), quantiaDesejada);
            } else {
                throw new ValidacaoException("Não foi possível adicionar o produto ao carrinho: quantidade inválida");
            }
        } else {
            throw new ValidacaoException("Não foi possível adicionar o produto ao carrinho: produto inválido");
        }

    }

    public boolean isCaixaSelecionado() {
        return Constantes.VALOR_INVALIDO != codigoCaixa;
    }

    public Map<Integer, Double> getCarrinho() {
        return carrinho;
    }

    public boolean isCartao() {
        return Constantes.FORMA_PAGAMENTO_CARTAO == tipoPagamento;
    }

    public void alterarTipoPagamento() {
        this.tipoPagamento = isCartao() ? Constantes.FORMA_PAGAMENTO_DINHEIRO : Constantes.FORMA_PAGAMENTO_CARTAO;
    }

    public Integer getCodigoCaixa() {
        return codigoCaixa;
    }

    public void setCodigoCaixa(Integer codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }
}
