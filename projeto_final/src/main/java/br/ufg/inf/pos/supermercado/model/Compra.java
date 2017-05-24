package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.controller.ControllerTrocoDinheiro;
import br.ufg.inf.pos.supermercado.exception.ValidacaoException;
import br.ufg.inf.pos.supermercado.util.Constantes;
import br.ufg.inf.pos.supermercado.util.Utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pedrofsn on 18/05/2017.
 */
public class Compra {

    private ControllerTrocoDinheiro controllerTrocoDinheiro = new ControllerTrocoDinheiro();
    private Map<Integer, Double> carrinho = new HashMap<>();
    private int tipoPagamento = Constantes.FORMA_PAGAMENTO_CARTAO;
    private Integer codigoCaixa = null;
    private Date date;

    public Compra() {
        date = new Date();
    }

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

    public String finalizar(Double valorPagoEmDinheiro) throws ValidacaoException {
        if (Utils.isNullOrEmpty(codigoCaixa)) {
            throw new ValidacaoException("Selecione um caixa");
        }

        if (Utils.isNullOrEmpty(Sessao.getInstance().getCaixaPeloCodigo(codigoCaixa))) {
            throw new ValidacaoException("Selecione um caixa com funcionário");
        }

        if (isDinheiro() && !isDinheiroSuficiente(valorPagoEmDinheiro)) {
            String mensagem = controllerTrocoDinheiro.calculaTroco(getValor(), valorPagoEmDinheiro);
            throw new ValidacaoException(mensagem.trim());
        }

        for (Map.Entry<Integer, Double> produtoCarrinho : carrinho.entrySet()) {
            Sessao.getInstance().getEstoque().removerProdutoEmEstoque(produtoCarrinho.getKey(), produtoCarrinho.getValue());
        }

        Sessao.getInstance().salvarCompra(this);

        String resultado = Constantes.STRING_VAZIA;

        if (isDinheiroSuficiente(valorPagoEmDinheiro)) {
            resultado = controllerTrocoDinheiro.calculaTroco(getValor(), valorPagoEmDinheiro);
        }

        return resultado + "\n[COMPRA REALIZADA COM SUCESSO]";
    }

    public boolean isDinheiroSuficiente(Double valorPagoEmDinheiro) {
        return isDinheiro() && !Utils.isNullOrEmpty(valorPagoEmDinheiro) && valorPagoEmDinheiro >= getValor();
    }

    public Map<Integer, Double> getCarrinho() {
        return carrinho;
    }

    public boolean isCartao() {
        return Constantes.FORMA_PAGAMENTO_CARTAO == tipoPagamento;
    }

    public boolean isDinheiro() {
        return Constantes.FORMA_PAGAMENTO_DINHEIRO == tipoPagamento;
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

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        Funcionario funcionario = Sessao.getInstance().getFuncionarioPeloCodigo(codigoCaixa);
        String formaVenda = isDinheiro() ? "dinheiro" : "cartão de crédito";
        return funcionario.toString() + " : efetuou uma venda no " + formaVenda + ", no valor de R$ " + getValor() + " | " + getDate();
    }
}