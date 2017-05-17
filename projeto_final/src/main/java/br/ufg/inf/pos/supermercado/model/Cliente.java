package br.ufg.inf.pos.supermercado.model;

import br.ufg.inf.pos.supermercado.domain.Pessoa;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;

/**
 * Created by aluno on 13/05/17.
 */
public class Cliente extends Pessoa {

    @Override
    public TipoUsuario getTipo() {
        return TipoUsuario.CLIENTE;
    }

}
