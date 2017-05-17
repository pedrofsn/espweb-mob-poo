package br.ufg.inf.pos.supermercado.domain;

import br.ufg.inf.pos.supermercado.model.Caixa;
import br.ufg.inf.pos.supermercado.model.Estoque;
import br.ufg.inf.pos.supermercado.model.Funcionario;
import br.ufg.inf.pos.supermercado.model.Gerente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Sessao {

    private static Sessao ourInstance = new Sessao();

    private Gerente gerente = new Gerente(0);
    private Estoque estoque = new Estoque();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Caixa> caixas = new ArrayList<>();

    private Sessao() {
        caixas.add(new Caixa(1));
        caixas.add(new Caixa(2));
        caixas.add(new Caixa(3));

        funcionarios.add(new Funcionario(1));
        funcionarios.add(new Funcionario(2));
        funcionarios.add(new Funcionario(3));
        funcionarios.add(new Funcionario(4));
        funcionarios.add(new Funcionario(5));
    }

    public static Sessao getInstance() {
        return ourInstance;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public List<Caixa> getCaixas() {
        return caixas;
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
