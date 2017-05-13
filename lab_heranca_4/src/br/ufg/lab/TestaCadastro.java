package br.ufg.lab;

import br.ufg.lab.controller.CadastroPessoa;
import br.ufg.lab.model.Cliente;
import br.ufg.lab.model.Data;
import br.ufg.lab.model.Funcionario;
import br.ufg.lab.model.Gerente;

public class TestaCadastro {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Renato", new Data(18, 4, 1985), 25);
        Funcionario funcionario1 = new Funcionario("Sérgio", new Data(1, 1, 1980), 10000);
        Gerente gerente1 = new Gerente("Diego", new Data(2, 2, 1990), 9000, "Desenvolvimento");

        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        cadastroPessoa.cadastrarPessoa(cliente1);
        cadastroPessoa.cadastrarPessoa(funcionario1);
        cadastroPessoa.cadastrarPessoa(gerente1);

        cadastroPessoa.imprimirRelatorio();
    }
}
