package br.ufg.lab.controller;

import br.ufg.lab.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aluno on 13/05/17.
 */
public class CadastroPessoa {

    private List<Pessoa> pessoasCadastradas = new ArrayList<>();
    private int qtdAtual;

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoasCadastradas.add(pessoa);
        imprimirCadastro(pessoa);
        ++qtdAtual;
    }

    private void imprimirCadastro(Pessoa pessoa) {
        pessoa.imprimirDados();
    }

    public void imprimirRelatorio() {
        System.out.println("\nO total de pessoas cadastradas no sistema é de " + getQtdAtual());
    }

    public int getQtdAtual() {
        return qtdAtual;
    }
}
