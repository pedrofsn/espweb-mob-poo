package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Receptivel;
import br.ufg.inf.pos.supermercado.util.Utils;

/**
 * Created by aluno on 13/05/17.
 */
public class Funcionario extends Pessoa implements Receptivel {

    private int codigo;
    private Integer codigoCaixa;

    public Funcionario(int codigo, String nome) {
        setNome(nome);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoCaixa() {
        return codigoCaixa;
    }

    public void setCodigoCaixa(Integer codigoCaixa) {
        this.codigoCaixa = codigoCaixa;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.FUNCIONARIO;
    }

    @Override
    public String toString() {
        return "CÓDIGO: " + codigo + " | FUNCIONÁRIO: " + getNome() + " | CAIXA: " + (Utils.isNullOrEmpty(codigoCaixa) ? "?" : codigoCaixa);
    }

    @Override
    public boolean isEmAtendimento() {
        return !Utils.isNullOrEmpty(codigoCaixa);
    }
}
