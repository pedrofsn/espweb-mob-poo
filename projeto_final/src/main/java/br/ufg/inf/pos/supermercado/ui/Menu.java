package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.controller.ControllerLogin;
import br.ufg.inf.pos.supermercado.domain.Sessao;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.Caixa;
import br.ufg.inf.pos.supermercado.model.Funcionario;
import br.ufg.inf.pos.supermercado.model.Produto;
import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public abstract class Menu extends MyUI {

    private static ControllerLogin controllerLogin = new ControllerLogin();

    protected static void inicializarUI() {
        iniciarLogin();
    }

    private static void iniciarLogin() {
        limparTela();
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
        int opcao = Constantes.VALOR_INVALIDO;

        while (opcao != 9) {
            print("\n\n");
            print("< Menu do Gerente " + Sessao.getInstance().getGerente().getNome() + ">");
            print("1 - Listar produtos em estoque");
            print("2 - Cadastrar Produtos");
            print("9 - Sair");
            print("\n\n");

            print("Opção:");
            opcao = getScanner().nextInt();
            tratarMenuGerente(opcao);
        }
    }

    private static void tratarMenuGerente(int opcao) {
        print("\n\n");
        switch (opcao) {
            case 1:
                print(Sessao.getInstance().getEstoque().getProdutosEmEstoque());
                break;
            case 2:
                iniciarCadastroProduto();
                break;
            case 9:
                print("Você saiu do sistema");
                inicializarUI();
                break;
        }
    }

    private static void iniciarCadastroProduto() {
        Produto produto = new Produto();

        print("Cadastrar produto:");
        print("[SEPARE AS CASAS DECIMAIS POR ',']");

        print("Código:");
        produto.setCodigo(getScanner().nextInt());

        print("Nome:");
        produto.setNome(getScanner().next());

        boolean isPorKg = getRespostaSimOuNao("Este produto é vendido por Kg?");

        if (isPorKg) {
            print("Insira o peso do produto:");
            produto.setPeso(getScanner().nextDouble());
        } else {
            print("Insira a quantidade do produto:");
            produto.setQuantidade(getScanner().nextInt());
        }

        print("Insira o preço do" + (isPorKg ? " Kg:" : " produto:"));
        produto.setPreco(getScanner().nextDouble());

        try {
            Sessao.getInstance().getEstoque().adicionarProdutoEmEstoque(produto);
            print("O produto abaixo foi cadastrado com sucesso!");
            print(produto.toString());
            print("\n");
            print("\n");
        } catch (ValidacaoException e) {
            print(e);
            iniciarCadastroProduto();
        } catch (Exception e) {
            print(e);
        }
        iniciarMenuGerente();
    }

    public static void iniciarMenuFuncionario() {
        try {
            List<Integer> codigosFuncionairosDisponiveis = Sessao.getInstance().getCodigosFuncionariosDisponiveis();
            List<Integer> codigosCaixasDisponiveis = Sessao.getInstance().getCodigosCaixasDisponiveis();

            if (Utils.isNullOrEmpty(codigosFuncionairosDisponiveis)) {
                print("Sem FUNCIONÁRIOS disponíveis no momento, tente mais tarde");

            } else if (Utils.isNullOrEmpty(codigosCaixasDisponiveis)) {
                print("Sem CAIXAS disponíveis no momento, tente mais tarde");

            } else {
                print("Selecione um código de FUNCIONÁRIO que esteja disponível para para trabalhar/assumir o papel de caixa [" + listToString(codigosFuncionairosDisponiveis) + "]:");
                int codigoFuncionarioSelecionado = getScanner().nextInt();
                Funcionario funcionarioSelecionado = Sessao.getInstance().getFuncionarioDisponivel(codigoFuncionarioSelecionado);
                print("\n");
                print("Você está usando o sistema como o funcionário " + funcionarioSelecionado.getNome());
                print("\n");

                print("Selecione um código de CAIXA que esteja disponível para ser assumido pelo funcionário " + funcionarioSelecionado.getNome() + " [" + listToString(codigosCaixasDisponiveis) + "]:");
                int codigoCaixaSelecionado = getScanner().nextInt();
                print("\n");
                print("Você está usando o CAIXA " + codigoCaixaSelecionado + " como o funcionário " + funcionarioSelecionado.getNome());
                Caixa caixaSelecionado = Sessao.getInstance().getCaixaDisponivel(codigoCaixaSelecionado);
                print("\n");

                Sessao.getInstance().getFuncionariosEmAtendimento().put(funcionarioSelecionado.getCodigo(), caixaSelecionado.getCodigo());

                boolean travarNoMenu = true;
                while (travarNoMenu) {
                    print("\n\n");
                    print("< Menu do Funcionário " + funcionarioSelecionado.getNome() + ">");
                    print("1 - Listar produtos em estoque");
                    print("2 - Efetuar venda de produtos");
                    print("9 - Sair");
                    print("\n\n");
                    print("Opção:");
                    int opcao = getScanner().nextInt();
                    tratarMenuFuncionario(codigoFuncionarioSelecionado, opcao);

                    if (opcao == 9) {
                        break;
                    }
                }
            }
        } catch (ValidacaoException e) {
            print(e);
            iniciarMenuFuncionario();
        }
    }

    private static void tratarMenuFuncionario(int codigoFuncionarioSelecionado, int opcao) {
        print("\n\n");
        switch (opcao) {
            case 1:
                print(Sessao.getInstance().getEstoque().getProdutosEmEstoque());
                break;
            case 2:
                efetuarVenda(codigoFuncionarioSelecionado);
                break;
            case 9:
                print("Você saiu do sistema");
                inicializarUI();
                break;
        }
    }

    private static void efetuarVenda(int codigoFuncionarioSelecionado) {

    }

    private static void iniciarMenuCliente() {

    }

}
