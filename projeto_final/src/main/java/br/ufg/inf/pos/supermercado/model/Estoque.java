package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Estoque {

    private List<Produto> produtosEmEstoque = new ArrayList<>();

    public Estoque() {
        popularEstoque();
    }

    private void popularEstoque() {
        if (Utils.isNullOrEmpty(produtosEmEstoque)) {
            produtosEmEstoque.add(new Produto(0, "Arroz"));
            produtosEmEstoque.add(new Produto(1, "Feijão"));
            produtosEmEstoque.add(new Produto(2, "Carne"));
            produtosEmEstoque.add(new Produto(3, "Macarrão"));
            produtosEmEstoque.add(new Produto(4, "Leite"));
            produtosEmEstoque.add(new Produto(5, "Cuscuz"));
            produtosEmEstoque.add(new Produto(6, "Requeijão"));
            produtosEmEstoque.add(new Produto(7, "Fralda"));
        }
    }

    public List<Produto> getProdutosEmEstoque() {
        return produtosEmEstoque;
    }

    public void adicionarProdutoEmEstoque(int codigo, String nome) {
        if (Utils.isNullOrEmpty(nome)) {
            throw new RuntimeException("Produto sem nome");
        }

        if (codigo <= Constantes.VALOR_INVALIDO) {
            throw new RuntimeException("Produto sem nome");
        }

        Produto novo = new Produto(codigo, nome);
        if (hasProdutoEmEstoque(novo)) {
            throw new RuntimeException("Produto já cadastrado em estoque");
        }
    }

    private boolean hasProdutoEmEstoque(Produto novo) {
        for (Produto produto : produtosEmEstoque) {
            if (produto.getCodigo() == novo.getCodigo() && produto.getNome().equalsIgnoreCase(novo.getNome())) {
                return true;
            }
        }

        return false;
    }
}
