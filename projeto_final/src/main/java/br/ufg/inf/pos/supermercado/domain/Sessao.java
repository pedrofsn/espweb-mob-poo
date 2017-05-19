package br.ufg.inf.pos.supermercado.domain;

import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.Caixa;
import br.ufg.inf.pos.supermercado.model.Estoque;
import br.ufg.inf.pos.supermercado.model.Funcionario;
import br.ufg.inf.pos.supermercado.model.Gerente;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Sessao {

    private static Sessao ourInstance = new Sessao();

    private Gerente gerente = new Gerente(0, "Pedro");
    private Estoque estoque = new Estoque();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Caixa> caixas = new ArrayList<>();
    private Map<Integer, Integer> funcionariosEmAtendimento = new HashMap<>();

    private Sessao() {
        caixas.add(new Caixa(0));
        caixas.add(new Caixa(1));
        caixas.add(new Caixa(2));

        funcionarios.add(new Funcionario(0, "João Pedro"));
        funcionarios.add(new Funcionario(1, "Luatane"));
        funcionarios.add(new Funcionario(2, "Edvaldo"));
        funcionarios.add(new Funcionario(3, "Beatriz"));
        funcionarios.add(new Funcionario(4, "Lorene"));
    }

    public static Sessao getInstance() {
        return ourInstance;
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


    public List<Integer> getCodigosCaixasDisponiveis() {
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

    public List<Integer> getCodigosFuncionariosDisponiveis() {
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

    public Map<Integer, Integer> getFuncionariosEmAtendimento() {
        return funcionariosEmAtendimento;
    }
}
