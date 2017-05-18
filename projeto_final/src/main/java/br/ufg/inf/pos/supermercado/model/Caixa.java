package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.utils.Utils;

/**
 * Created by aluno on 13/05/17.
 */
public class Caixa {

    private Integer codigoFuncionarioOperador;
    private int codigo;

    public Caixa(int codigo) {
        this.codigo = codigo;
    }

    public boolean isDisponivel() {
        return !Utils.isNullOrEmpty(codigoFuncionarioOperador);
    }

    public Integer getCodigoFuncionarioOperador() {
        return codigoFuncionarioOperador;
    }

    public void setCodigoFuncionarioOperador(Integer codigoFuncionarioOperador) {
        this.codigoFuncionarioOperador = codigoFuncionarioOperador;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
