package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Receptivel;
import br.ufg.inf.pos.supermercado.util.Utils;

/**
 * Created by aluno on 13/05/17.
 */
public class Caixa implements Receptivel {

    private int codigo;
    private Integer codigoFuncionario;

    public Caixa(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public Integer getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(Integer codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    @Override
    public boolean isEmAtendimento() {
        return !Utils.isNullOrEmpty(codigoFuncionario);
    }

}
