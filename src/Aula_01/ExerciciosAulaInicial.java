package Aula_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import tools.utils;

public class ExerciciosAulaInicial {
    private static Double jurosCompostosPorAno(double capital, double taxa, double anos) {
        return capital * Math.pow((1 + taxa), anos);
    }

    private static Double calculaIMC(double quilos, double altura) {
        return quilos / (altura * altura);
    }

    private static double viagens(int kmLimite, double valor1, double valor2, int kmPercorridos) {
        if (kmPercorridos < kmLimite) {
            return kmPercorridos * valor1;
        }
        return kmPercorridos * valor2;
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

        return ls;
    }

    private static List<List<Integer>> mockIntegerMatrixFourByFour() {
        final int FOUR = 4;
        Random rand = new Random();
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < FOUR; i++) {
            List<Integer> lsInt = new ArrayList<>();
            for (int j = 0; j < FOUR; j++) {
                lsInt.add(rand.nextInt(10, 100));
            }
            matrix.add(lsInt);
        }

        return matrix;
    }

    private static void printIntegerMatrix(List<List<Integer>> matrix) {
        for (List<Integer> ls : matrix) {
            for (Integer n : ls) {
                System.out.print(" " + n);
            }
            System.out.println();
        }
    }

    private static void integerMatrixOperations(List<List<Integer>> matrix) {
        int diagonalSum = 0;
        for (int i = 0; i < matrix.size(); i++) {
            int evenIntsPerRow = 0;

            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (matrix.get(i).get(j) % 2 == 0) {
                    evenIntsPerRow++;
                }
                if (i == j) {
                    diagonalSum += matrix.get(i).get(j);
                }
            }
            System.out.println("Na linha " + (i + 1) + " há " + evenIntsPerRow + " números pares");
        }
        System.out.println("Soma da diagonal principal: " + diagonalSum);

        for (int i = 0; i < matrix.getFirst().size(); i++) {        // variable i stores the current column
            List<Integer> lsColumn = new ArrayList<>();
            for (List<Integer> lsInts : matrix) {                   // iterates through the rows of the matrix
                lsColumn.add(lsInts.get(i));                        // gets the element of the column i from the specified row
            }
            System.out.println("Média da coluna " + (i + 1) + ": " + utils.averageOf(lsColumn));
        }
    }

    public static void AulaInicial() {
        Scanner sc = new Scanner(System.in);

        String opc;
        do { // hast
            System.out.println("Aula Inicial\n");
            System.out.println(" 1 - Exercício 01 -> Juros");
            System.out.println(" 2 - Exercício 02 -> IMC");
            System.out.println(" 3 - Exercício 03 -> Viagens");
            System.out.println(" 4 - Exercício 04 -> Triângulos");
            System.out.println(" 5 - Exercício 05 -> Médias");
            System.out.println(" 6 - Exercício 06 -> Idades");
            System.out.println(" 7 - Exercício 07 -> Matriz");
            System.out.println(" 0 - Sair");
            System.out.print("Escolha: ");
            opc = sc.next();

            switch (opc) {
                case "1":
                    System.out.println(jurosCompostosPorAno(10000.0, 0.15, 10.0));
                    System.out.println(jurosCompostosPorAno(2356.47, 0.13, 12.0));
                    break;

                case "2":
                    System.out.println(calculaIMC(130.0, 1.9));
                    System.out.println(calculaIMC(73.0, 1.8));
                    break;

                case "3":
                    System.out.println(viagens(100, 1.5, 1.25, 50));
                    System.out.println(viagens(150, 1.4, 1.15, 250));
                    break;

                case "4":
                    System.out.println(triangulamento(3, 4, 5));
                    System.out.println(triangulamento(6, 6, 6));
                    System.out.println(triangulamento(6, 6, 4));
                    System.out.println(triangulamento(2, 6, 3));
                    break;

                case "5":
                    List<Double> notas = new ArrayList<>();
                    notas.add(9.6);
                    notas.add(3.8);
                    notas.add(7.2);
                    notas.add(8.1);
                    notas.add(5.4);

                    Double media = utils.averageOf(notas);
                    System.out.println("Média: " + media);
                    exibeNotasAcimaDaMedia(notas, media);
                    break;

                case "6":
                    List<Integer> idades = capturaIdades();
                    System.out.println("Média das idades: " + utils.averageOf(idades));

                    int n;

                    n = 0;
                    for (Integer i : idades) if (i > 20) n++;
                    System.out.println(n + " pessoas na lista são maiores de idade");

                    n = 0;
                    for (Integer i : idades) if (i > 65) n++;
                    System.out.println(n + " pessoas na lista estão acima dos 65 anos");

                    break;

                case "7":
                    List<List<Integer>> matrix = mockIntegerMatrixFourByFour();
                    printIntegerMatrix(matrix);
                    integerMatrixOperations(matrix);
                    break;

                case "0": break;

                default:
                    System.out.println("INVÁLIDO!!!");
                    break;
            }
            utils.pause();

        } while (!opc.equals("0"));

        sc.close();
    }
}
