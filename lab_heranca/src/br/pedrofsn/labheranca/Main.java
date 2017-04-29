package br.pedrofsn.labheranca;

public class Main {

    /*
    * instanciar 10 funcionários sendo 2 horistas, 4 administradores, 3 comissionados e 1 gerente;
    * Armazenar os funcionários em um vetor;
    * Percorrer o vetor mostrando os dados dos funcionários e quanto cada um ganha por mês.
    * */
    public static void main(String[] args) {

        Horista horista1 = new Horista();
        Horista horista2 = new Horista();

        Administrador administrador1 = new Administrador();
        Administrador administrador2 = new Administrador();
        Administrador administrador3 = new Administrador();
        Administrador administrador4 = new Administrador();

        Comissionado comissionado1 = new Comissionado();
        Comissionado comissionado2 = new Comissionado();
        Comissionado comissionado3 = new Comissionado();

        Gerente gerente1 = new Gerente();

        Funcionario[] funcionarios = new Funcionario[]{horista1, horista2, administrador1, administrador2, administrador3, administrador4, comissionado1, comissionado2, comissionado3, gerente1};

        double folhaPagamento = 0.0;

        for (int i = 0; i < funcionarios.length; i++) {
            Funcionario funcionario = funcionarios[i];

            if(funcionario != null) {
                double salario = funcionario.calcularSalario();
                Utils.print("O funcionário " + funcionario.getClass().getSimpleName() + " recebe " + Utils.getValorMonetario(salario));
                folhaPagamento += salario;
            }
        }

        Utils.print("O valor total da folha de pagamento é " + Utils.getValorMonetario(folhaPagamento));
    }
}
