package Aula_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExerciciosAulaInicial {
    private static Double jurosCompostosPorAno(double capital, double taxa, double anos) {
        return capital * Math.pow((1 + taxa), anos);
    }

    private static Double calculaIMC(double quilos, double altura) {
        return quilos/(altura*altura);
    }

    private static String triangulamento(int lado1, int lado2, int lado3) {
        if (!isTriangle(lado1, lado2, lado3)) {
            return "Não é um Triângulo!";
        }

        if ((lado1 == lado2) && (lado1 == lado3)) {
            return "Equilátero!";
        }

        if ((lado1 != lado2)
            && (lado1 != lado3)
            && (lado2 != lado3)) {
            return "Escaleno!";
        }

        return "Isósceles!";
    }

    private static boolean isTriangle(int a, int b, int c) {
        return a + b > c
                && a + c > b
                && b + c > a;
    }

    private static void exibeNotasAcimaDaMedia(List<Double> lsNotas, Double media) {
        if (lsNotas == null || media == null) {
            return;
        }
        System.out.println("Acima da média:");
        for (Double n : lsNotas) {
            if (n > media) {
                System.out.println(n);
            }
        }
    }

    private static List<Integer> capturaIdades() {
        List<Integer> ls = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int idade;

        System.out.println("Informe idades");
        do { // hast
            System.out.print(">> ");
            idade = sc.nextInt();
            if (idade >= 0) {
                ls.add(idade);
            }
        } while (idade >= 0);

        sc.close();
        return ls;
    }

    private static Double averageOf(List<? extends Number> array) {
        if (array == null || array.isEmpty()) {
            return null;
        }

        double sum = 0.0;
        for (Number n : array) {
            sum += n.doubleValue();
        }
        return sum/array.size();
    }

    public static void AulaInicial() {
        // Exercício 01
        System.out.println(jurosCompostosPorAno(10000.0, 0.15, 10.0));
        System.out.println(jurosCompostosPorAno(2356.47, 0.13, 12.0));

        // Exercício 02
        System.out.println(calculaIMC(130.0, 1.9));
        System.out.println(calculaIMC(73.0, 1.8));

        // Exercício 03

        // Exercício 04
        System.out.println(triangulamento(3, 4, 5));
        System.out.println(triangulamento(6, 6, 6));
        System.out.println(triangulamento(6, 6, 4));
        System.out.println(triangulamento(2, 6, 3));

        // Exercício 05 -ish
        ArrayList<Double> notas = new ArrayList<>();
        notas.add(9.6);
        notas.add(3.8);
        notas.add(7.2);
        notas.add(8.1);
        notas.add(5.4);

        Double media = averageOf(notas);
        System.out.println("Média: " + media);
        exibeNotasAcimaDaMedia(notas, media);

        // Exercício 06
        List<Integer> idades = capturaIdades();
        System.out.println("Média das idades: " + averageOf(idades));

        int n;

        n = 0; for (Integer i : idades) if (i > 20) n++;
        System.out.println(n + " pessoas na lista são maiores de idade");

        n = 0; for (Integer i : idades) if (i > 65) n++;
        System.out.println(n + " pessoas na lista estão acima dos 65 anos");

        // Exercício 07
    }
}
