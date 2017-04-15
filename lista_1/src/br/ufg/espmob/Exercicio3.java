package br.ufg.espmob;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

/**
 * Created by pedrofsn on 14/04/2017.
 */
public class Exercicio3 {

    /*  Implemente um programa que realize uma das 4 operaçoes (+), (-), (/) e (*) entre duas variáveis, por meio da escolha do usuário*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insira o primeiro valor:");
        int valor1 = scanner.nextInt();

        System.out.println("Insira o segundo valor:");
        int valor2 = scanner.nextInt();

        System.out.println("Insira um dos operadores (+, -, / ou *): ");
        String operador = scanner.next();

        String equacao = valor1 + " " + operador + " " + valor2;

        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            Object resultado = engine.eval(equacao);
            System.out.println(equacao + " = " + resultado);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}
