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

    private Gerente gerente = new Gerente(0, "Pedro");
    private Estoque estoque = new Estoque();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Caixa> caixas = new ArrayList<>();

    private Sessao() {
        caixas.add(new Caixa(1));
        caixas.add(new Caixa(2));
        caixas.add(new Caixa(3));

        funcionarios.add(new Funcionario(1, "João Pedro"));
        funcionarios.add(new Funcionario(2, "Luatane"));
        funcionarios.add(new Funcionario(3, "Edvaldo"));
        funcionarios.add(new Funcionario(4, "Beatriz"));
        funcionarios.add(new Funcionario(5, "Lorene"));
    }

    public static Sessao getInstance() {
        return ourInstance;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Caixa getCaixa(int codigo) {
        for (int i = 0; i < caixas.size(); i++) {
            if (codigo == caixas.get(i).getCodigo()) {
                return caixas.get(i);
            }
        }

        return null;
    }

    public Funcionario getFuncionario(int codigo) {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (codigo == funcionarios.get(i).getCodigo()) {
                return funcionarios.get(i);
            }
        }

        return null;
    }

    public List<Integer> getCaixasDisponiveis() {
        List<Integer> disponiveis = new ArrayList<>();

        for (Caixa c : caixas) {
            if (c.isDisponivel()) {
                disponiveis.add(c.getCodigo());
            }
        }

        return disponiveis;
    }

    public List<Integer> getFuncionariosDisponiveis() {
        List<Integer> funcionariosDisponiveis = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (f.isDisponivel()) {
                funcionariosDisponiveis.add(f.getCodigo());
            }
        }

        return funcionariosDisponiveis;
    }

    public Estoque getEstoque() {
        return estoque;
    }
}
