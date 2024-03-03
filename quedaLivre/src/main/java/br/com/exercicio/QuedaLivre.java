package br.com.exercicio;

import java.util.Scanner;

public class QuedaLivre {

    private static final double AC_GRAVIDADE = 9.81;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double alturaInicial = getAlturaInicial(scanner);
        double intervaloTempo = getIntervaloTempo(scanner);

        calculaPosicaoVelocidadeQueda(intervaloTempo, alturaInicial);
        scanner.close();
    }

    private static void calculaPosicaoVelocidadeQueda(double intervaloTempo, double alturaInicial) {
        double alturaAtual = alturaInicial;
        double tempo = 0;
        double velocidade = 0;

        System.out.println("Tempo (segundos) | Altura (metros) | Velocidade (metros/segundos)");
        System.out.printf("%.2f | %.2f | %.2f\n", tempo, alturaAtual, velocidade);

        while (alturaAtual > 0) {
            tempo += intervaloTempo;
            double proximaAltura = alturaInicial - calculaAlturaConformeTempo(tempo);
            velocidade = calculaVelocidadeConformeTempo(tempo);

            if (proximaAltura <= 0) {
                tempo = calculaTempoTotalQueda(alturaInicial);
                alturaAtual = 0;
                velocidade = calculaVelocidadeConformeTempo(tempo);
                System.out.printf("%.2f | %.2f | %.2f\n", tempo, alturaAtual, velocidade);
            } else {
                System.out.printf("%.2f | %.2f | %.2f\n", tempo, proximaAltura, velocidade);
                alturaAtual = proximaAltura;
            }
        }
    }

    private static double calculaAlturaConformeTempo(double tempo) {
        return (AC_GRAVIDADE * Math.pow(tempo, 2)) / 2;
    }

    private static double calculaVelocidadeConformeTempo(double tempo) {
        return AC_GRAVIDADE * tempo;
    }

    private static double calculaTempoTotalQueda(double alturaInicial) {
        return Math.sqrt((2 * alturaInicial) / AC_GRAVIDADE);
    }

    private static double getIntervaloTempo(Scanner scanner) {
        double intervaloTempo = -1;

        while (intervaloTempo < 0){
            try {
                System.out.print("Digite o intervalo de tempo para as atualizações da queda (em segundos): ");
                intervaloTempo = scanner.nextDouble();
            }catch (Exception e) {
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return intervaloTempo;
    }

    private static double getAlturaInicial(Scanner scanner) {
        double alturaInicial = -1;

        while (alturaInicial < 0){
            try {
                System.out.print("Digite a altura inicial (este valor é em metros): ");
                alturaInicial = scanner.nextDouble();
            }catch (Exception e) {
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return alturaInicial;
    }

}