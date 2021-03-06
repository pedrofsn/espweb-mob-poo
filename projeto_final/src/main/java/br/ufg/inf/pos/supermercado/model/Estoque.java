package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Mock;
import br.ufg.inf.pos.supermercado.exception.ValidacaoException;
import br.ufg.inf.pos.supermercado.util.Constantes;
import br.ufg.inf.pos.supermercado.util.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Estoque extends Mock {

    private List<Produto> produtosEmEstoque = new ArrayList<>();
    private List<String> registros;

    public Estoque() {
        registros = new ArrayList<>();
        popularValoresDefault();
    }

    @Override
    public void popularValoresDefault() {
        if (Utils.isNullOrEmpty(produtosEmEstoque)) {
            produtosEmEstoque.add(new Produto(0, "Arroz", 9, 10.00));
            produtosEmEstoque.add(new Produto(1, "Feijão", 8, 10.00));
            produtosEmEstoque.add(new Produto(2, "Carne", 10.00, 7.5));
            produtosEmEstoque.add(new Produto(3, "Macarrão", 5, 10.00));
            produtosEmEstoque.add(new Produto(4, "Leite", 4, 10.00));
            produtosEmEstoque.add(new Produto(5, "Cuscuz", 1, 10.00));
            produtosEmEstoque.add(new Produto(6, "Requeijão", 2, 10.00));
            produtosEmEstoque.add(new Produto(7, "Fralda", 3, 10.00));
            produtosEmEstoque.add(new Produto(8, "Laranja", 5.5, 10.00));
        }
    }

    public List<Produto> getProdutosEmEstoque() {
        return produtosEmEstoque;
    }

    public Produto getProduto(int codigo) {
        if (!Utils.isNullOrEmpty(produtosEmEstoque)) {
            for (int i = 0; i < produtosEmEstoque.size(); i++) {
                if ((produtosEmEstoque.get(i).getCodigo() == codigo)) {
                    return produtosEmEstoque.get(i);
                }
            }
        }

        return null;
    }

    public void adicionarProdutoEmEstoque(Produto novo) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(novo)) {
            if (Utils.isNullOrEmpty(novo.getNome())) {
                throw new ValidacaoException("Produto sem nome");
            }

            if (!Utils.isNullOrEmpty(novo.getCodigo()) && novo.getCodigo() <= Constantes.VALOR_INVALIDO) {
                throw new ValidacaoException("Produto sem código");
            }

            if (!Utils.isNullOrEmpty(novo.getQuantidade()) && novo.getQuantidade() <= Constantes.VALOR_INVALIDO) {
                throw new ValidacaoException("Produto sem quantidade");
            }

            if (Utils.isNullOrEmpty(novo.getPreco())) {
                throw new ValidacaoException("Produto sem preço");
            }

            if (hasProdutoEmEstoque(novo)) {
                throw new ValidacaoException("Este produto já foi previamente cadastrado em estoque");
            }

            produtosEmEstoque.add(novo);

            String mensagem = "\nFoi adicionado " + novo.getQuantidade() + " " + novo.getTipoEmString() + " do produto " + novo.getNome() + " (" + novo.getCodigo() + ") em " + new Date().toString();
            registros.add(mensagem);
        }
    }

    public void removerProdutoEmEstoque(Integer key, Double value) {
        if (!Utils.isNullOrEmpty(key) && !Utils.isNullOrEmpty(value)) {
            for (Produto produto : produtosEmEstoque) {
                if (produto.getCodigo() == key) {
                    Double quantidade = produto.getQuantidade();
                    quantidade = quantidade - value;

                    String mensagem = "\nFoi removido " + value + " " + produto.getTipoEmString() + " do produto " + produto.getNome() + " (" + key + ") em " + new Date().toString();
                    registros.add(mensagem);

                    produto.setQuantidade(quantidade);
                }
            }
        }
    }

    private boolean hasProdutoEmEstoque(Produto novo) throws ValidacaoException {
        for (Produto produto : produtosEmEstoque) {
            if (produto.getCodigo() == novo.getCodigo()) {
                throw new ValidacaoException("Código já cadastrado");
            }

            if (produto.getNome().equalsIgnoreCase(novo.getNome())) {
                throw new ValidacaoException("Nome já cadastrado");
            }
        }

        return false;
    }

    public List<String> getRelatorioEstoque() {
        return registros;
    }
}
