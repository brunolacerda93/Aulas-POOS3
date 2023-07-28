package Aula_01;

import java.util.ArrayList;

public class ExerciciosAulaInicial {
    private static double CalculaJurosCompostos(double capital, double taxa, double tempo) {
        return capital * Math.pow((1 + taxa), tempo);
    }

    private static String Triangulamento(int lado1, int lado2, int lado3) {
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

    private static void CalculaMedia(ArrayList<Double> notas) {
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

    private static int[] ArranjoDuplo(int[] vec1, int[] vec2) {
        int[] vec = new int[5];

        for (int i = 0; i < 5; i++) {
            vec[i] = vec1[i] + vec2[i];
        }

        return vec;
    }

    public static void AulaInicial() {
        // Exercício 01
        System.out.println(ExerciciosAulaInicial.CalculaJurosCompostos(10000.0, 0.15, 10.0));
        System.out.println(ExerciciosAulaInicial.CalculaJurosCompostos(2356.47, 0.13, 12.0));

        // Exercício 02
        System.out.println(ExerciciosAulaInicial.Triangulamento(3, 4, 5));
        System.out.println(ExerciciosAulaInicial.Triangulamento(6, 6, 6));
        System.out.println(ExerciciosAulaInicial.Triangulamento(6, 6, 4));
        System.out.println(ExerciciosAulaInicial.Triangulamento(2, 6, 3));

        // Exercício 03
        ArrayList<Double> Notas = new ArrayList<>();

        Notas.add(9.6);
        Notas.add(3.8);
        Notas.add(7.2);
        Notas.add(8.1);
        Notas.add(5.4);

        ExerciciosAulaInicial.CalculaMedia(Notas);

        // Exercício 04
        int[] vec1 = {1, 2, 3, 4, 5};
        int[] vec2 = {10, 20, 30, 40, 50};

        System.out.println("Novo Array:");
        for (int i : ExerciciosAulaInicial.ArranjoDuplo(vec1, vec2)) {
            System.out.print(" " + i);
        }
    }
}
