package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.TipoUsuario;

/**
 * Created by aluno on 13/05/17.
 */
public class Gerente extends Funcionario {

    public Gerente(int codigo, String nome) {
        super(codigo, nome);
    }

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.GERENTE;
    }

}
