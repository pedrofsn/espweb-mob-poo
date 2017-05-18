package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Pessoa;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;

/**
 * Created by aluno on 13/05/17.
 */
public class Funcionario extends Pessoa {

    private boolean disponivel;
    private int codigo;

    public Funcionario(int codigo, String nome) {
        setNome(nome);
        this.codigo = codigo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.FUNCIONARIO;
    }
}
