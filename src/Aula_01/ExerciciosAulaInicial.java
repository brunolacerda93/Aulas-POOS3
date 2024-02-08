package Aula_01;

import java.util.ArrayList;

public class ExerciciosAulaInicial {
    private static Double calculaJurosCompostosPorAno(double capital, double taxa, double anos) {
        return capital * Math.pow((1 + taxa), anos);
    }

    private static Double calculaIMC(Double quilos, Double altura) {
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

    private static void calculaMediaNotas(ArrayList<Double> notas) {
        Double soma = 0.0;

        for (Double n : notas) {
            soma += n;
        }

        double media = soma/(notas.size());
        System.out.println("Média: " + media);

        System.out.println("Acima da média:");
        for (Double n : notas) {
            if (n > media) {
                System.out.println(n);
            }
        }
    }

    public static void AulaInicial() {
        // Exercício 01
        System.out.println(calculaJurosCompostosPorAno(10000.0, 0.15, 10.0));
        System.out.println(calculaJurosCompostosPorAno(2356.47, 0.13, 12.0));

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
        ArrayList<Double> Notas = new ArrayList<>();
        Notas.add(9.6);
        Notas.add(3.8);
        Notas.add(7.2);
        Notas.add(8.1);
        Notas.add(5.4);
        calculaMediaNotas(Notas);

        // Exercício 06

        // Exercício 07
    }
}
