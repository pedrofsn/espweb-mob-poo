package br.ufg.lab.controller;

import br.ufg.lab.model.Cliente;
import br.ufg.lab.model.Funcionario;
import br.ufg.lab.model.Gerente;
import br.ufg.lab.model.Pessoa;

import java.util.ArrayList;
import java.util.Iterator;
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
        printarQuantidades();
        printarMaiorSalario();
    }

    private void printarMaiorSalario() {
        float maiorSalario = 0;
        Funcionario funcionarComMaiorSalario = null;

        for (Pessoa pessoa : pessoasCadastradas) {
            if (pessoa instanceof Funcionario) {

                Funcionario funcionario = (Funcionario) pessoa;

                if (maiorSalario == 0 || funcionario.getSalario() > maiorSalario) {
                    maiorSalario = funcionario.getSalario();
                    funcionarComMaiorSalario = funcionario;
                }

            }
        }

        if (funcionarComMaiorSalario != null) {
            System.out.println(funcionarComMaiorSalario.getNome() + " tem o maior salário (" + maiorSalario + ")");
        } else {
            System.out.println("Você não possui funcionários cadastrados");
        }

    }

    private void printarQuantidades() {
        Iterator iterator = pessoasCadastradas.iterator();
        int contadorCliente = 0;
        int contadorGerente = 0;
        int contadorFuncionario = 0;

        while (iterator.hasNext()) {
            Pessoa pessoa = (Pessoa) iterator.next();

            if (pessoa instanceof Cliente) {
                ++contadorCliente;

            } else if (pessoa instanceof Gerente) {
                ++contadorGerente;

            } else if (pessoa instanceof Funcionario) {
                ++contadorFuncionario;

            }
        }

        System.out.println("\nQuantidade de cliente(s): " + contadorCliente);
        System.out.println("\nQuantidade de gerente(s): " + contadorGerente);
        System.out.println("\nQuantidade de funcionário(s): " + contadorFuncionario);
        System.out.println("\nQuantidade total: " + qtdAtual);
    }
}
