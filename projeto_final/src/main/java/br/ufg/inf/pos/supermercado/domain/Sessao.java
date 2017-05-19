package br.ufg.inf.pos.supermercado.domain;

import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.*;
import br.ufg.inf.pos.supermercado.utils.CustomHashMap;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Sessao extends Mock {

    private static Sessao ourInstance = new Sessao();

    private Gerente gerente;
    private Estoque estoque;
    private List<Funcionario> funcionarios;
    private List<Cliente> clientes;
    private List<Caixa> caixas;
    private CustomHashMap<Integer, Integer> vinculoFuncionarioComCaixa;

    private Sessao() {
        gerente = new Gerente(0, "Pedro");
        estoque = new Estoque();
        funcionarios = new ArrayList<>();
        clientes = new ArrayList<>();
        caixas = new ArrayList<>();
        vinculoFuncionarioComCaixa = new CustomHashMap<>();
        popularValoresDefault();
    }

    public static Sessao getInstance() {
        return ourInstance;
    }

    @Override
    public void popularValoresDefault() {
        caixas.add(new Caixa(0));
        caixas.add(new Caixa(1));
        caixas.add(new Caixa(2));

        funcionarios.add(new Funcionario(0, "João Pedro"));
        funcionarios.add(new Funcionario(1, "Luatane"));
        funcionarios.add(new Funcionario(2, "Edvaldo"));
        funcionarios.add(new Funcionario(3, "Beatriz"));
        funcionarios.add(new Funcionario(4, "Lorene"));

        //TODO: REMOVER, apenas pra facilitar os testes
        vinculoFuncionarioComCaixa.put(1, 2);
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Caixa getCaixaDisponivel(int codigo) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(vinculoFuncionarioComCaixa) && vinculoFuncionarioComCaixa.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : vinculoFuncionarioComCaixa.entrySet()) {
                if (codigo == entry.getValue()) {
                    throw new ValidacaoException("Caixa em uso");
                }
            }
        }

        return caixas.get(codigo);
    }

    public Funcionario getFuncionarioDisponivel(int codigo) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(vinculoFuncionarioComCaixa) && vinculoFuncionarioComCaixa.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : vinculoFuncionarioComCaixa.entrySet()) {
                if (codigo == entry.getKey()) {
                    throw new ValidacaoException("Funcionário em atendimento");
                }
            }
        }

        return funcionarios.get(codigo);
    }

    public List<Integer> getCodigosCaixasAbertosParaAtendimento() {
        List<Integer> codigosCaixasSemAlocacao = getCodigosCaixasSemAlocacao();
        List<Integer> todosCaixas = new ArrayList<>();

        for (Caixa caixa : caixas) {
            todosCaixas.add(caixa.getCodigo());
        }

        List<Integer> temp = new ArrayList<>(todosCaixas);
        temp.removeAll(codigosCaixasSemAlocacao);
        return temp;
    }

    public List<Integer> getCodigosCaixasSemAlocacao() {
        List<Integer> disponiveis = new ArrayList<>();

        for (Caixa c : caixas) {
            if (!Utils.isNullOrEmpty(vinculoFuncionarioComCaixa) && vinculoFuncionarioComCaixa.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : vinculoFuncionarioComCaixa.entrySet()) {
                    if (c.getCodigo() != entry.getValue()) {
                        disponiveis.add(c.getCodigo());
                    }
                }
            } else {
                disponiveis.add(c.getCodigo());
            }
        }

        return disponiveis;
    }

    public List<Integer> getCodigosFuncionariosSemAlocacao() {
        List<Integer> disponiveis = new ArrayList<>();

        for (Funcionario f : funcionarios) {
            if (!Utils.isNullOrEmpty(vinculoFuncionarioComCaixa) && vinculoFuncionarioComCaixa.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : vinculoFuncionarioComCaixa.entrySet()) {
                    if (f.getCodigo() != entry.getKey()) {
                        disponiveis.add(f.getCodigo());
                    }
                }
            } else {
                disponiveis.add(f.getCodigo());
            }
        }

        return disponiveis;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void posicionarFuncionarioEmAtendimento(int funcionario, int caixa) {
        vinculoFuncionarioComCaixa.put(funcionario, caixa);
    }

    public boolean hasFuncionarioEmAtendendimento() {
        return vinculoFuncionarioComCaixa.size() > 0;
    }

    public List<String> getFuncionarios() {
        List<String> lista = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            lista.add(f.toString());
        }
        return lista;
    }

    public Integer getCodigoCaixaDoFuncionarioEmAtendimento(int codigo) {
        return vinculoFuncionarioComCaixa.get(codigo);
    }

    public Integer getCodigoFuncionarioDoCaixaEmAtendimento(int codigo) {
        return vinculoFuncionarioComCaixa.getKey(codigo);
    }
}
