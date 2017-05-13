package br.ufg.lab.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by aluno on 13/05/17.
 */
public abstract class Multimidia {

    private String titulo;
    private int ano;
    private int duracaoEmMinutos;
    private List<String> comentarios;

    private Random random = new Random();

    public Multimidia() {
        this.titulo = "Era uma vez " + getRandom().nextInt(15);
        this.ano = 1992 + getRandom().nextInt(15);
        this.duracaoEmMinutos = getRandom().nextInt(120);
        this.comentarios = new ArrayList<>();

        comentarios.add("Muito legal");
        comentarios.add("Ótimo");
        comentarios.add("Perfeito");
        comentarios.add("Incrível");
        comentarios.add("Perfeito");
    }

    @Override
    public String toString() {
        return titulo + " | " + ano + " | " + duracaoEmMinutos + " minutos | Comentários: " + getComentariosEmString();
    }

    private String getComentariosEmString() {
        if (comentarios != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int tamanhoLista = comentarios.size();

            for (int i = 0; i < tamanhoLista; i++) {
                String comentario = comentarios.get(i);

                stringBuffer.append(comentario);

                if (i != tamanhoLista - 1) {
                    stringBuffer.append(", ");
                }
            }

            return stringBuffer.toString();
        }

        return "Sem comentários.";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    public Random getRandom() {
        return random;
    }
}

