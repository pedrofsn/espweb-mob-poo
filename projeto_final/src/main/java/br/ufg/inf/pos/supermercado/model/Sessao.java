package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.controller.ControllerOperadorCaixa;
import br.ufg.inf.pos.supermercado.domain.Mock;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class Sessao extends Mock {

    private static Sessao ourInstance;

    private Gerente gerente;
    private Estoque estoque;
    private List<Funcionario> funcionarios;
    private List<Caixa> caixas;
    private List<Compra> comprasRealizadas;
    private ControllerOperadorCaixa controllerOperadorCaixa;

    private Sessao() {
        comprasRealizadas = new ArrayList<>();
        controllerOperadorCaixa = new ControllerOperadorCaixa();
        gerente = new Gerente(0, "Pedro");
        estoque = new Estoque();
        funcionarios = new ArrayList<>();
        caixas = new ArrayList<>();
        popularValoresDefault();
    }

    public static Sessao getInstance() {
        if (ourInstance == null) {
            ourInstance = new Sessao();
        }
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

        try {
            posicionarFuncionarioEmAtendimento(0, 0);
        } catch (ValidacaoException e) {
            e.printStackTrace();
        }
    }

    public Gerente getGerente() {
        return gerente;
    }

    public Funcionario getFuncionarioPeloCodigo(int codigo) {
        return codigo <= funcionarios.size() - 1 ? funcionarios.get(codigo) : null;
    }

    public Caixa getCaixaPeloCodigo(int codigo) {
        return codigo <= caixas.size() - 1 ? caixas.get(codigo) : null;
    }

    public List<Integer> getCodigosCaixasSemFuncionario() {
        return getCodigosCaixas(true);
    }

    public List<Integer> getCodigosCaixasComFuncionario() {
        return getCodigosCaixas(false);
    }

    private List<Integer> getCodigosCaixas(boolean comFuncionario) {
        List<Integer> caixasSemAtendimento = new ArrayList<>();

        for (Caixa caixa : caixas) {
            if (comFuncionario) {
                if (!caixa.isEmAtendimento()) {
                    caixasSemAtendimento.add(caixa.getCodigo());
                }
            } else {
                if (caixa.isEmAtendimento()) {
                    caixasSemAtendimento.add(caixa.getCodigo());
                }
            }
        }

        return caixasSemAtendimento;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void posicionarFuncionarioEmAtendimento(int codigoFuncionario, int codigoCaixa) throws ValidacaoException {
        controllerOperadorCaixa.assumirCaixa(funcionarios, caixas, codigoFuncionario, codigoCaixa);
    }

    public boolean hasFuncionarioEmAtendendimento() {
        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).isEmAtendimento()) {
                return true;
            }
        }

        return false;
    }

    public List<String> getFuncionariosEmString() {
        List<String> lista = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            lista.add(f.toString());
        }
        return lista;
    }

    public List<String> getRelatorioVenda() {
        List<String> lista = new ArrayList<>();
        for (Compra comprasRealizada : comprasRealizadas) {
            lista.add(comprasRealizada.toString());
        }
        return lista;
    }

    public List<String> getRelatorioEstoque() {
        return estoque.getRelatorioEstoque();
    }

    public void salvarCompra(Compra compra) {
        comprasRealizadas.add(compra);
    }
}
