package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.controller.ControllerLogin;
import br.ufg.inf.pos.supermercado.domain.Sessao;
import br.ufg.inf.pos.supermercado.domain.TipoUsuario;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.Compra;
import br.ufg.inf.pos.supermercado.model.Produto;
import br.ufg.inf.pos.supermercado.utils.Constantes;
import br.ufg.inf.pos.supermercado.utils.Utils;

import java.util.List;

/**
 * Created by pedrofsn on 16/05/2017.
 */
public abstract class Menu extends Ui {

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
            limparTela();
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
        double quantidade = 0.0;

        if (isPorKg) {
            print("Insira o peso do produto:");
            quantidade = getScanner().nextDouble();
        } else {
            print("Insira a quantidade do produto:");
            quantidade = getScanner().nextDouble();
            quantidade = (int) quantidade;
        }

        produto.setQuantidade(quantidade);

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
//        try {
//            List<Integer> funcionariosSemAlocacao = Sessao.getInstance().getCodigosFuncionariosSemAlocacao();
        List<Integer> caixasSemAlocacao = Sessao.getInstance().getCodigosCaixasSemAlocacao();

//            if (Utils.isNullOrEmpty(funcionariosSemAlocacao)) {
//                print("Sem FUNCIONÁRIOS disponíveis no momento, tente mais tarde");
//
//            } else

        if (Utils.isNullOrEmpty(caixasSemAlocacao)) {
            print("Sem CAIXAS disponíveis no momento, tente mais tarde");

        } else {

            print("\n");
            print("\n");
            print("Escolha a visão de um funcionário:");
            print("\n");
            List<String> funcionarios = Sessao.getInstance().getFuncionarios();
            for (int i = 0; i < funcionarios.size(); i++) {
                String funcionario = funcionarios.get(i);
                Integer codigoCaixa = Sessao.getInstance().getCodigoCaixaDoFuncionarioEmAtendimento(i);
                print(funcionario + " | Caixa: " + (Utils.isNullOrEmpty(codigoCaixa) ? "-" : codigoCaixa));
            }

            int codigoFuncionarioSelecionado = getScanner().nextInt();
//            Funcionario funcionarioSelecionado = Sessao.getInstance().getFuncionarioDisponivel(codigoFuncionarioSelecionado);

            print("\n");
            print("\n");
//            print("<Menu do Funcionário " + Sessao);

//                print("\n");
//                print("Você está usando o sistema como o funcionário " + funcionarioSelecionado.getNome());
//                print("\n");
//
//                if (funcionarioSelecionado.)
//                    print("Selecione um código de CAIXA que esteja disponível para ser assumido pelo funcionário " + funcionarioSelecionado.getNome() + " [" + listToString(caixasSemAlocacao) + "]:");
//                int codigoCaixaSelecionado = getScanner().nextInt();
//                print("\n");
//
//                print("Você está usando o CAIXA " + codigoCaixaSelecionado + " como o funcionário " + funcionarioSelecionado.getNome());
//                Caixa caixaSelecionado = Sessao.getInstance().getCaixaDisponivel(codigoCaixaSelecionado);
//                print("\n");
//
//                Sessao.getInstance().posicionarFuncionarioEmAtendimento(funcionarioSelecionado.getCodigo(), caixaSelecionado.getCodigo());
//
//                while (true) {
//                    print("\n\n");
//                    print("< Menu do Funcionário " + funcionarioSelecionado.getNome() + ">");
//                    print("1 - Listar produtos em estoque");
//                    print("2 - Efetuar venda de produtos");
//                    print("9 - Sair");
//                    print("\n\n");
//                    print("Opção:");
//                    int opcao = getScanner().nextInt();
//                    tratarMenuFuncionario(codigoFuncionarioSelecionado, opcao);
//
//                    if (opcao == 9) {
//                        break;
//                    }
//                }
        }
//        } catch (ValidacaoException e) {
//            print(e);
//            iniciarMenuFuncionario();
//        }
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
        if (Sessao.getInstance().hasFuncionarioEmAtendendimento()) {
            boolean travarNoMenu = true;
            while (travarNoMenu) {
                print("\n\n");
                print("< Menu do Cliente >");
                print("1 - Listar produtos em estoque");
                print("2 - Efetuar compra de produtos");
                print("9 - Sair");
                print("\n\n");
                print("Opção:");
                int opcao = getScanner().nextInt();
                tratarMenuCliente(opcao);

                if (opcao == 9) {
                    break;
                }
            }
        } else {
            print("[SEM FUNCIONÁRIOS PARA ATENDIMENTO]");
            iniciarLogin();
        }
    }

    private static void tratarMenuCliente(int opcao) {
        print("\n\n");
        switch (opcao) {
            case 1:
                print(Sessao.getInstance().getEstoque().getProdutosEmEstoque());
                break;
            case 2:
                iniciarCompra();
                break;
            case 9:
                print("Você saiu do sistema");
                inicializarUI();
                break;
        }

    }

    private static void iniciarCompra() {
        List<Produto> produtosEmEstoque = Sessao.getInstance().getEstoque().getProdutosEmEstoque();
        Compra compra = new Compra();

        laco:
        while (true) {
            print("\n\n");
            print(produtosEmEstoque);
            print("\n\n");

            print("<Opções>");
            print("111 - Alterar método de pagamento atual <" + (compra.isCartao() ? "Cartão" : "Dinheiro") + ">");
            print("222 - Selecionar caixa <" + (Utils.isNullOrEmpty(compra.getCodigoCaixa()) ? "?" : compra.getCodigoCaixa()) + ">");
            print("333 - Finalizar compra");
            print("999 - Desistir da compra");
            print(compra.getCarrinho());
            print("\n\n");
            print("Digite o código do produto desejado ou uma das opções acima: ");
            print("\n\n");
            int codigo = getScanner().nextInt();

            switch (codigo) {
                case 111:
                    compra.alterarTipoPagamento();
                    break;
                case 222:
                    Integer codigoCaixa;
                    do {
                        codigoCaixa = getCaixaLivreParaPassarCompra();
                        compra.setCodigoCaixa(codigoCaixa);
                    } while (Utils.isNullOrEmpty(codigoCaixa));
                    break;
                case 333:

                    break;
                case 999:
                    compra = null;
                    iniciarMenuCliente();
                    break laco;
                default:
                    print("Digite o peso/quantidade desejada: ");
                    double quantidade = getScanner().nextDouble();

                    Produto produto = null;
                    if (codigo <= produtosEmEstoque.size() - 1) {
                        produto = produtosEmEstoque.get(codigo);
                    }
                    try {
                        compra.adicionarProdutoNaCompra(produto, quantidade);
                    } catch (ValidacaoException e) {
                        print(e);
                    }
                    break;
            }
        }
    }

    private static Integer getCaixaLivreParaPassarCompra() {
        List<Integer> codigosCaixasDisponiveis = Sessao.getInstance().getCodigosCaixasAbertosParaAtendimento();
        print("\n");
        print("\n");
        print("Caixa(s) livre(s):");
        print(listToString(codigosCaixasDisponiveis));
        print("\n");
        print("\n");
        print("Digite o código do caixa desejado:");
        int codigoCaixa = getScanner().nextInt();
        for (Integer disponivel : codigosCaixasDisponiveis) {
            if (disponivel == codigoCaixa) {
                return codigoCaixa;
            }
        }

        return null;
    }
}
