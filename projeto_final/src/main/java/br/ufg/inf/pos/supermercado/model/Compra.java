package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Relatavel;
import br.ufg.inf.pos.supermercado.domain.Sessao;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pedrofsn on 18/05/2017.
 */
public class Compra implements Relatavel {

    private Map<Integer, Double> carrinho = new HashMap<>();
    private int tipoPagamento = Constantes.FORMA_PAGAMENTO_CARTAO;
    private Integer codigoCaixa = null;
    private Date date = new Date();

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

    public void finalizar() throws ValidacaoException {
        if (Utils.isNullOrEmpty(codigoCaixa)) {
            throw new ValidacaoException("Selecione um caixa");
        }

        if (Utils.isNullOrEmpty(Sessao.getInstance().getCaixaPeloCodigo(codigoCaixa))) {
            throw new ValidacaoException("Selecione um caixa com funcionário");
        }

        for (Map.Entry<Integer, Double> produtoCarrinho : carrinho.entrySet()) {
            Sessao.getInstance().getEstoque().removerProdutoEmEstoque(produtoCarrinho.getKey(), produtoCarrinho.getValue());
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

    public double getValor() {
        double valorTotal = 0.0;
        if (!Utils.isNullOrEmpty(carrinho)) {

            for (Map.Entry<Integer, Double> entry : carrinho.entrySet()) {
                for (Produto produto : Sessao.getInstance().getEstoque().getProdutosEmEstoque()) {
                    if (entry.getKey() == produto.getCodigo()) {
                        double valorPorProduto = entry.getValue() * produto.getPreco();
                        valorTotal += valorPorProduto;
                    }
                }
            }
        }

        return valorTotal;
    }

    @Override
    public String getRelatorio() {
        try {
            Integer codigoFuncionario = Sessao.getInstance().getCaixaPeloCodigo(codigoCaixa).getCodigoFuncionario();
            Funcionario funcionario = Sessao.getInstance().getFuncionarioPeloCodigo(codigoFuncionario);
            return funcionario.toString() + " efetuou uma venda no valor de " + getValor() + " na data " + date.toString();
        } catch (Exception e) {
            return "Não apurado";
        }
    }
}