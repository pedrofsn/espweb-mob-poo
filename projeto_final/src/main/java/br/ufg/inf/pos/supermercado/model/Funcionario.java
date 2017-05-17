package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Pessoa;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;

/**
 * Created by aluno on 13/05/17.
 */
public class Funcionario extends Pessoa {

    private int codigo;

    public Funcionario(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.FUNCIONARIO;
    }
}