package br.ufg.inf.pos.supermercado.domain;

import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.*;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<Integer, Integer> funcionariosEmAtendimento;

    private Sessao() {
        gerente = new Gerente(0, "Pedro");
        estoque = new Estoque();
        funcionarios = new ArrayList<>();
        clientes = new ArrayList<>();
        caixas = new ArrayList<>();
        funcionariosEmAtendimento = new HashMap<>();
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
        funcionariosEmAtendimento.put(1, 2);
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Caixa getCaixaDisponivel(int codigo) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(funcionariosEmAtendimento) && funcionariosEmAtendimento.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : funcionariosEmAtendimento.entrySet()) {
                if (codigo == entry.getValue()) {
                    throw new ValidacaoException("Caixa em uso");
                }
            }
        }

        return caixas.get(codigo);
    }

    public Funcionario getFuncionarioDisponivel(int codigo) throws ValidacaoException {
        if (!Utils.isNullOrEmpty(funcionariosEmAtendimento) && funcionariosEmAtendimento.size() > 0) {
            for (Map.Entry<Integer, Integer> entry : funcionariosEmAtendimento.entrySet()) {
                if (codigo == entry.getKey()) {
                    throw new ValidacaoException("Funcionário em atendimento");
                }
            }
        }

        return funcionarios.get(codigo);
    }

//    public Funcionario getFuncionario(int codigo) {
//        if (!Utils.isNullOrEmpty(funcionariosEmAtendimento))
//            for (Map.Entry<Integer, Integer> entry : funcionariosEmAtendimento.entrySet()) {
//                System.out.println(entry.getKey() + "/" + entry.getValue());
//
//                if (codigo == entry.getKey()) {
//                    return funcionarios.get(codigo);
//                }
//            }
//        return null;
//    }
//
//    public List<Integer> getCaixasDisponiveis() {
//        List<Integer> disponiveis = new ArrayList<>();
//
//        for (Caixa c : caixas) {
//            if (Utils.isNullOrEmpty(getCaixa(c.getCodigo()))) {
//                disponiveis.add(c.getCodigo());
//            }
//        }
//
//        return disponiveis;
//    }


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
            if (!Utils.isNullOrEmpty(funcionariosEmAtendimento) && funcionariosEmAtendimento.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : funcionariosEmAtendimento.entrySet()) {
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
            if (!Utils.isNullOrEmpty(funcionariosEmAtendimento) && funcionariosEmAtendimento.size() > 0) {
                for (Map.Entry<Integer, Integer> entry : funcionariosEmAtendimento.entrySet()) {
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
        funcionariosEmAtendimento.put(funcionario, caixa);
    }

    public boolean hasFuncionarioEmAtendendimento() {
        return funcionariosEmAtendimento.size() > 0;
    }
}
