package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Pessoa;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aluno on 13/05/17.
 */
public class Cliente extends Pessoa {

    private List<Integer> compraProdutos = new ArrayList<>();
    private Map<Integer, Double> carrinho = new HashMap<>();

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.CLIENTE;
    }

    public List<Integer> getCompraProdutos() {
        return compraProdutos;
    }

    public void adicionarProdutoNaCompra(Produto produtoSelecionado, Double quantiaDesejada) throws ValidacaoException {
        if (produtoSelecionado.isPorKg()) {

        } else {
            int quantidadeMaximaPermitida = produtoSelecionado.getQuantidade();
            Double quantidadePreviamenteAdicionada = 0.0;

            if (!carrinho.containsKey(produtoSelecionado.getCodigo())) {
                quantidadePreviamenteAdicionada = carrinho.get(produtoSelecionado.getCodigo());
            }

            if (quantiaDesejada + quantidadePreviamenteAdicionada <= quantidadeMaximaPermitida) {
                carrinho.put(produtoSelecionado.getCodigo(), quantiaDesejada);
            } else {
                throw new ValidacaoException("Quantidade não permitida");
            }
        }
    }
}
