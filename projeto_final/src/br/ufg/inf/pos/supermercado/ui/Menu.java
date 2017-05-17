package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.controller.ControllerLogin;
import br.ufg.inf.pos.supermercado.domain.Sessao;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;
import br.ufg.inf.pos.supermercado.utils.Utils;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public abstract class Menu extends MyUI {

    private static ControllerLogin controllerLogin = new ControllerLogin();

    protected static void inicializarUI() {
        iniciarLogin();
    }

    private static void iniciarLogin() {
        print("Seja bem-vindo ao sistema de vendas Compre+");
        print("\n");
        print("\tRealize o login para entrar no sistema");
        print("\n");
        print("Login: ");
        String login = getScanner().next();
        print("Senha: ");
        String senha = getScanner().next();

        try {
            TipoUsuario tipoUsuario = controllerLogin.login(login, senha);
            if (!Utils.isNullOrEmpty(tipoUsuario)) {
                iniciarMenuUsuario(tipoUsuario);
            }
        } catch (Exception e) {
            print(e);
            iniciarLogin();
        }
    }

    private static void iniciarMenuUsuario(TipoUsuario tipoUsuario) {
        limparTela();

        if (TipoUsuario.CLIENTE == tipoUsuario) {
            iniciarMenuCliente();

        } else if (TipoUsuario.FUNCIONARIO == tipoUsuario) {
            iniciarMenuFuncionario();

        } else if (TipoUsuario.GERENTE == tipoUsuario) {
            iniciarMenuGerente();

        } else {
            print(new RuntimeException("Usuário não autorizado"));
        }
    }

    private static void iniciarMenuGerente() {
        print("\n\n");
        print("< Menu do Gerente >");
        print("1 - Listar produtos em estoque");
        print("2 - Cadastrar Produtos");
        print("3 - ListaProduti");
        print("\n\n");

        int opcao = getScanner().nextInt();
        tratarMenuGerente(opcao);
    }

    private static void tratarMenuGerente(int opcao) {
        switch (opcao) {
            case 1:
                Sessao.getInstance().getEstoque().getProdutosEmEstoque();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private static void iniciarMenuFuncionario() {

    }

    private static void iniciarMenuCliente() {

    }

}
