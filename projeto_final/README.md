### Problema Final
## Configurações
Projeto no padrão maven, desenvolvido utilizando a IDE IntelliJ IDEA.

## Como rodar o projeto
Utilizar a IDE IntelliJ IDEA para abrir o projeto, Eclipse ou alguma IDE Java capaz de carregar um projeto via pom.xml.

### Não faz parte dos objetivos deste projeto
+ Pensar em um controle seguro para não conflitar os IDs;
+ Validar entrada de dados;
+ Interface Gráfica;
+ Segurança;

### Entregáveis:
+ Diagramas de Classe;
+ Códigos em Java;
+ Arquivo README.MD contendo os passos de configuração e instalação necessários para a execução do sistema e os nomes dos participantes.

### Escopo
O supermercado tem 1 gerente e 5 funcionários, que se revezam nos 3 caixas de pagamento. Cada caixa está equipada com uma balança, viabilizando a venda de produtos por quilo ou por unidade.

### Requisitos
+ Fazer o controle do estoque de produtos do supermercado;
+ Gerentes podem adicionar produtos ao estoque;
+ Funcionários podem efetuar vendas de produtos (dando baixa no estoque);
+ Ao efetuar uma venda, registrar: caixa, funcionário, venda realizada e o valor total da venda;
+ Permitir o pagamento das vendas em dinheiro ou cartão;
+ Se pagamento for com DINHEIRO, o sistema deve informar o valor do troco;
+ Clientes podem consultar o preço dos produtos em leitores espalhados pelo supermercado;
+ Gerente pode emitir relatórios de vendas e de estoque;
+ + O relatório de vendas deve informar, para cada caixa, os valores das vendas realizadas no dia, assim como o funcionário responsável pela venda;
+ + O relatório de estoque deve informar as quantidades disponíveis por produto no início do dia e no final do dia;