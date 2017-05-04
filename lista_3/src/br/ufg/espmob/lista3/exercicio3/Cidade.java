package br.ufg.espmob.lista3.exercicio3;

import br.ufg.espmob.Utils;

import java.util.List;
import java.util.Random;

/**
 * Created by pedrofsn on 03/05/2017.
 */
public class Cidade {

    private int codigo;
    private String nome;
    private String estado;
    private int veiculosPasseio;
    private int acidentesTransito;

    public Cidade() {
        this.codigo = new Random().nextInt(25);
        this.nome = new Random().nextInt() + "_cidade";
        this.estado = "X" + new Random().nextInt(10);
        this.veiculosPasseio = new Random().nextInt(50);
        this.acidentesTransito = new Random().nextInt(100);
    }

    public void printCidadeComMaisAcidentesDeTransito(List<Cidade> cidades) {
        Cidade cidadeEscolhida = null;
        int acidentesRegistrados = 0;

        if (!Utils.isNullOrEmpty(cidades)) {
            for (int i = 0; i < cidades.size(); i++) {
                Cidade cidade = cidades.get(i);

                if (acidentesRegistrados == 0 | cidade.getAcidentesTransito() >= acidentesRegistrados) {
                    acidentesRegistrados = cidade.getAcidentesTransito();
                    cidadeEscolhida = cidade;
                }
            }

            Utils.print(cidadeEscolhida.getCodigo() + " " + cidadeEscolhida.getNome() + " é a cidade com o maior número de acidentes registrados (" + cidadeEscolhida.getAcidentesTransito() + ").");
        }
    }

    public void printCidadeComMenosAcidentesDeTransito(List<Cidade> cidades) {
        Cidade cidadeEscolhida = null;
        int acidentesRegistrados = 0;

        if (!Utils.isNullOrEmpty(cidades)) {
            for (int i = 0; i < cidades.size(); i++) {
                Cidade cidade = cidades.get(i);

                if (acidentesRegistrados == 0 || cidade.getAcidentesTransito() <= acidentesRegistrados) {
                    acidentesRegistrados = cidade.getAcidentesTransito();
                    cidadeEscolhida = cidade;
                }
            }

            Utils.print(cidadeEscolhida.getCodigo() + " " + cidadeEscolhida.getNome() + " é a cidade com o menor número de acidentes registrados (" + cidadeEscolhida.getAcidentesTransito() + ").");
        }
    }

    public void printMediaVeiculosPasseio(List<Cidade> cidades) {
        float media = 0;

        if (!Utils.isNullOrEmpty(cidades)) {
            for (int i = 0; i < cidades.size(); i++) {
                Cidade cidade = cidades.get(i);
                media += cidade.getVeiculosPasseio();
            }

            media = media / cidades.size();

            Utils.print("Média de veículos de passeio nas cidades brasileiras: " + media);
        }
    }

    public void printMediaAcidentes(List<Cidade> cidades, String estado) {
        float media = 0;
        int contador = 0;

        if (!Utils.isNullOrEmpty(cidades) && !Utils.isNullOrEmpty(estado)) {
            for (int i = 0; i < cidades.size(); i++) {
                Cidade cidade = cidades.get(i);

                if (estado.equalsIgnoreCase(cidade.getEstado())) {
                    contador++;
                    media += cidade.getAcidentesTransito();
                }
            }

            media = media / contador;

            Utils.print("Média de acidentes entre as cidades do estado de " + estado.toUpperCase() + ": " + media);
        }
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVeiculosPasseio() {
        return veiculosPasseio;
    }

    public void setVeiculosPasseio(int veiculosPasseio) {
        this.veiculosPasseio = veiculosPasseio;
    }

    public int getAcidentesTransito() {
        return acidentesTransito;
    }

    public void setAcidentesTransito(int acidentesTransito) {
        this.acidentesTransito = acidentesTransito;
    }
}
