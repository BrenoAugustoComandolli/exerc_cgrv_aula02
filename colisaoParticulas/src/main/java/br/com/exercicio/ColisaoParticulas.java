package br.com.exercicio;

import java.util.Scanner;

public class ColisaoParticulas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double msPart1 = getMsPart1(scanner);
        double velPart1 = getVelocidadeInicialPart1(scanner);

        double msPart2 = getMsPart2(scanner);
        double velPart2 = getVelocidadeInicialPart2(scanner);

        double velocidadeFinalPart1 = calculaVelocidadeFinalPart1(msPart1, msPart2, velPart1, velPart2);
        double velocidadeFinalPart2 = calculaVelocidadeFinalPart2(msPart1, msPart2, velPart1, velPart2);

        exibirVelocidadesFinais(velocidadeFinalPart1, velocidadeFinalPart2);
    }

    /**
     * Calcula a velocidade final da partícula 1 após a colisão, utilizando a fórmula baseando se no coeficiente de restituição
     */
    public static double calculaVelocidadeFinalPart1(double msPart1, double msPart2, double velPart1, double velPart2) {
        return ((msPart1 - msPart2) / (msPart1 + msPart2)) * velPart1
                + ((2 * msPart2) / (msPart1 + msPart2)) * velPart2;
    }

    /**
     * Calcula a velocidade final da partícula 1 após a colisão, utilizando a fórmula baseando se no coeficiente de restituição
     */
    public static double calculaVelocidadeFinalPart2(double msPart1, double msPart2, double velPart1, double velPart2) {
        return ((2 * msPart1) / (msPart1 + msPart2)) * velPart1 +
                ((msPart2 - msPart1) / (msPart1 + msPart2)) * velPart2;
    }

    /**
     * Obtém a velocidade inicial da partícula 1
     */
    private static double getVelocidadeInicialPart1(Scanner scanner) {
        double velInicialPart1 = -1;

        while (velInicialPart1 < 0){
            try {
                System.out.println("Informe a velocidade inicial da partícula 1 (metros/segundo): ");
                velInicialPart1 = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return velInicialPart1;
    }

    /**
     * Obtém a velocidade inicial da partícula 2
     */
    private static double getVelocidadeInicialPart2(Scanner scanner) {
        double velInicialPart2 = -1;

        while (velInicialPart2 < 0){
            try {
                System.out.println("Informe a velocidade inicial da partícula 2 (metros/segundo): ");
                velInicialPart2 = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return velInicialPart2;
    }

    /**
     * Obtém a massa da partícula 1
     */
    private static double getMsPart1(Scanner scanner) {
        double msPart1 = -1;

        while (msPart1 < 0){
            try {
                System.out.println("Informe a massa da partícula 1 (kg): ");
                msPart1 = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return msPart1;
    }

    /*
     * Obtém a massa da partícula 2
     */
    private static double getMsPart2(Scanner scanner) {
        double msPart2 = -1;

        while (msPart2 < 0){
            try {
                System.out.println("Informe a massa da partícula 2 (kg): ");
                msPart2 = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return msPart2;
    }

    /**
     * Exibe as velocidades finais das partículas após a colisão
     */
    private static void exibirVelocidadesFinais(double velocidadeFinalPart1, double velocidadeFinalPart2) {
        System.out.println("Após a colisão: ");
        System.out.println("Velocidade final da partícula 1: " + velocidadeFinalPart1 + " m/s");
        System.out.println("Velocidade final da partícula 2: " + velocidadeFinalPart2 + " m/s");
    }
}