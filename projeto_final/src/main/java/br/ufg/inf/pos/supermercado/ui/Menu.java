package br.ufg.inf.pos.supermercado.ui;

import br.ufg.inf.pos.supermercado.controller.ControllerLogin;
import br.ufg.inf.pos.supermercado.exceptions.QuantidadeException;
import br.ufg.inf.pos.supermercado.exceptions.ValidacaoException;
import br.ufg.inf.pos.supermercado.model.*;
import br.ufg.inf.pos.supermercado.util.Constantes;
import br.ufg.inf.pos.supermercado.util.Utils;

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
            print("3 - Emitir relatório de venda");
            print("4 - Emitir relatório de estoque");
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
            case 3:
                List<String> relatoriosVenda = Sessao.getInstance().getRelatorioVenda();
                if (Utils.isNullOrEmpty(relatoriosVenda)) {
                    print("Não apurado");
                } else {
                    print(relatoriosVenda);
                }
                break;
            case 4:
                List<String> relatoriosEstoque = Sessao.getInstance().getRelatorioEstoque();
                if (Utils.isNullOrEmpty(relatoriosEstoque)) {
                    print("Não apurado");
                } else {
                    print(relatoriosEstoque);
                }
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
        double quantidade;

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

    private static void iniciarMenuFuncionario() {
        iniciarMenuFuncionario(Constantes.VALOR_INVALIDO);
    }

    private static void iniciarMenuFuncionario(Integer funcionario) {

        if (Utils.isNullOrEmpty(funcionario) || funcionario == Constantes.VALOR_INVALIDO) {
            print("\n");
            print(Sessao.getInstance().getFuncionariosEmString());

            print("\n");
            print("Escolha a visão de um funcionário:");
            print("\n");

            funcionario = getScanner().nextInt();
        }

        Funcionario funcionarioSelecionado = Sessao.getInstance().getFuncionarioPeloCodigo(funcionario);

        if (Utils.isNullOrEmpty(funcionarioSelecionado)) {
            print("[FUNCIONÁRIO INVÁLIDO]");
            iniciarMenuFuncionario(null);
        }

        while (true) {
            print("\n");
            print("\n");
            print("<Menu do Funcionário " + funcionarioSelecionado.getNome() + ">");
            print("\n");
            print("0 - Alterar visão de funcionário <" + funcionarioSelecionado.getCodigo() + ">");
            print("1 - Listar produtos em estoque");
            print("2 - Alterar o caixa atual <" + (Utils.isNullOrEmpty(funcionarioSelecionado.getCodigoCaixa()) ? "?" : funcionarioSelecionado.getCodigoCaixa()) + ">");
            print("9 - Sair");
            print("\n");
            print("Opção:");
            int opcao = getScanner().nextInt();
            tratarMenuFuncionario(funcionarioSelecionado, opcao);

            if (opcao == 9) {
                break;
            }
        }
    }

    private static void tratarMenuFuncionario(Funcionario f, int opcao) {
        int funcionario = f.getCodigo();
        print("\n\n");
        switch (opcao) {
            case 0:
                iniciarMenuFuncionario();
                break;
            case 1:
                print(Sessao.getInstance().getEstoque().getProdutosEmEstoque());
                break;
            case 2:
                List<Integer> lista = Sessao.getInstance().getCodigosCaixasSemFuncionario();
                if (Utils.isNullOrEmpty(lista)) {
                    print("[Sem caixas disponíveis]");

                } else {
                    print("\n");
                    print("Selecione um caixa pelo código [" + listToString(lista) + "]");
                    print("Opção:");
                    int codigoCaixaSelecionado = getScanner().nextInt();

                    try {
                        Sessao.getInstance().posicionarFuncionarioEmAtendimento(funcionario, codigoCaixaSelecionado);
                    } catch (ValidacaoException e) {
                        print(e);
                    }

                    iniciarMenuFuncionario(funcionario);
                }
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

        boolean emCompra = true;
        while (emCompra) {
            print("\n\n");
            print(produtosEmEstoque);
            print("\n\n");

            print("<Opções>");
            print("111 - Alterar método de pagamento atual <" + (compra.isCartao() ? "Cartão" : "Dinheiro") + ">");
            print("222 - Selecionar caixa <" + (Utils.isNullOrEmpty(compra.getCodigoCaixa()) ? "?" : compra.getCodigoCaixa()) + ">");
            print("333 - Finalizar compra <" + compra.getValor() + ">");
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
                    Double valorPagoEmDinheiro = 0.0;
                    if (!compra.isCartao()) {
                        print("Total da compra: " + getValorMonetario(compra.getValor()));
                        print("Insira o valor a ser pago: ");
                        valorPagoEmDinheiro = getScanner().nextDouble();
                    }

                    try {
                        print("\n");
                        print(compra.finalizar(valorPagoEmDinheiro));
                        print("\n");
                        iniciarMenuCliente();
                        emCompra = false;
                    } catch (ValidacaoException e) {
                        print(e);
                    }
                    break;
                case 999:
                    iniciarMenuCliente();
                    emCompra = false;
                    break;
                default:
                    print("Digite o peso/quantidade desejada: ");
                    double quantidade = getScanner().nextDouble();

                    try {
                        compra.adicionarProdutoNaCompra(Sessao.getInstance().getEstoque().getProduto(codigo), quantidade);
                    } catch (QuantidadeException | ValidacaoException e) {
                        print(e);
                    }
                    break;
            }
        }
    }

    private static Integer getCaixaLivreParaPassarCompra() {
        List<Integer> caixasComFuncionario = Sessao.getInstance().getCodigosCaixasComFuncionario();
        print("\n");
        print("\n");
        print("Caixa(s) livre(s):");
        print(listToString(caixasComFuncionario));
        print("\n");
        print("\n");
        print("Digite o código do caixa desejado:");
        int codigoCaixa = getScanner().nextInt();
        for (Integer disponivel : caixasComFuncionario) {
            if (disponivel == codigoCaixa) {
                return codigoCaixa;
            }
        }

        return null;
    }
}
