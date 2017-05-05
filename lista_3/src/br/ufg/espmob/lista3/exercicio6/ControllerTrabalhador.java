package br.ufg.espmob.lista3.exercicio6;

import br.ufg.espmob.Utils;

import java.util.List;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class ControllerTrabalhador {

    public void fazTudo(List<Trabalhador> trabalhadores) {
        printFolhaPagamento(trabalhadores);
        printPecasFabricadas(trabalhadores);
        printMediaPecasPorHomensCategoriaA(trabalhadores);
        printMediaPecasPorMulheresCategoriaC(trabalhadores);
        printMaiorSalario(trabalhadores);
    }

    private void printFolhaPagamento(List<Trabalhador> trabalhadores) {
        double folha = 0.0;

        if (!Utils.isNullOrEmpty(trabalhadores)) {
            for (int i = 0; i < trabalhadores.size(); i++) {
                Trabalhador trabalhador = trabalhadores.get(i);

                folha += trabalhador.getSalario();
            }
        }

        Utils.print("Folha de pagamento: " + Utils.getValorMonetario(folha));
    }

    private void printPecasFabricadas(List<Trabalhador> trabalhadores) {
        int pecas = 0;

        if (!Utils.isNullOrEmpty(trabalhadores)) {
            for (int i = 0; i < trabalhadores.size(); i++) {
                Trabalhador trabalhador = trabalhadores.get(i);

                pecas += trabalhador.getPecasPorMes();
            }
        }

        Utils.print("Peças fabricadas: " + pecas);
    }

    private void printMediaPecasPorHomensCategoriaA(List<Trabalhador> trabalhadores) {
        int pecas = 0;
        int contador = 0;

        if (!Utils.isNullOrEmpty(trabalhadores)) {
            for (int i = 0; i < trabalhadores.size(); i++) {
                Trabalhador trabalhador = trabalhadores.get(i);

                if (trabalhador.isMasculino() && trabalhador.isA()) {
                    pecas += trabalhador.getPecasPorMes();
                    ++contador;
                }
            }
        }

        float media = pecas / contador;

        Utils.print("Peças fabricadas por homens da categoria A: " + media);
    }

    private void printMediaPecasPorMulheresCategoriaC(List<Trabalhador> trabalhadores) {
        int pecas = 0;
        int contador = 0;

        if (!Utils.isNullOrEmpty(trabalhadores)) {
            for (int i = 0; i < trabalhadores.size(); i++) {
                Trabalhador trabalhador = trabalhadores.get(i);

                if (!trabalhador.isMasculino() && trabalhador.isC()) {
                    pecas += trabalhador.getPecasPorMes();
                    ++contador;
                }
            }
        }

        float media = pecas / contador;

        Utils.print("Peças fabricadas por mulheres da categoria C: " + media);
    }

    private void printMaiorSalario(List<Trabalhador> trabalhadores) {
        Trabalhador trabalhadorEscolhido = null;
        double maiorSalario = 0;

        if (!Utils.isNullOrEmpty(trabalhadores)) {
            for (int i = 0; i < trabalhadores.size(); i++) {
                Trabalhador trabalhador = trabalhadores.get(i);

                if (maiorSalario == 0.0 || trabalhador.getSalario() > maiorSalario) {
                    trabalhadorEscolhido = trabalhador;
                    maiorSalario = trabalhador.getSalario();
                }
            }
        }

        if (!Utils.isNullOrEmpty(trabalhadorEscolhido)) {
            Utils.print("O operador " + trabalhadorEscolhido.getMatricula() + " recebe o maior salário, que é de: " + Utils.getValorMonetario(trabalhadorEscolhido.getSalario()));
        }
    }

}
