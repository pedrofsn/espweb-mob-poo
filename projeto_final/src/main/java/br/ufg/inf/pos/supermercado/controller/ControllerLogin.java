package br.ufg.inf.pos.supermercado.controller;

import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.TipoUsuario;
import br.ufg.inf.pos.supermercado.util.Utils;

import javax.security.auth.login.LoginException;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public class ControllerLogin {

    private final static String LOGIN_GERENTE = "gerente";
    private final static String LOGIN_FUNCIONARIO = "funcionario";
    private final static String LOGIN_CLIENTE = "cliente";

    public TipoUsuario login(String login, String senha) throws LoginException, ValidacaoException {
        if (Utils.isNullOrEmpty(login)) {
            throw new ValidacaoException("Usuário não preenchido");
        }

        if (Utils.isNullOrEmpty(senha)) {
            throw new ValidacaoException("Usuário não preenchido");
        }

        // CONTROLE FAKE
        if (!login.equalsIgnoreCase(senha)) {
            throw new ValidacaoException("Login ou senha inválidos");
        }

        switch (login) {
            case LOGIN_GERENTE:
                return TipoUsuario.GERENTE;

            case LOGIN_FUNCIONARIO:
                return TipoUsuario.FUNCIONARIO;

            case LOGIN_CLIENTE:
                return TipoUsuario.CLIENTE;
        }

        throw new LoginException("Login ou senha inválidos");
    }

}
