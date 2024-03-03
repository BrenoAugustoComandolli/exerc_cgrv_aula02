package br.com.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuedaLivre {

    public static final double AC_GRAVIDADE = 9.81;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double alturaInicial = getAlturaInicial(scanner);
        double intervaloTempo = getIntervaloTempo(scanner);

        List<EstadoQueda> lEstado = calculaPosicaoVelocidadeQueda(intervaloTempo, alturaInicial);
        exibeResultadosQuedaLivre(lEstado);
        scanner.close();
    }

    public static List<EstadoQueda> calculaPosicaoVelocidadeQueda(double intervaloTempo, double alturaInicial) {
        List<EstadoQueda> estados = new ArrayList<>();

        double alturaAtual = alturaInicial;
        double tempo = 0;
        double velocidade = 0;

        estados.add(new EstadoQueda(tempo, alturaAtual, velocidade));

        while (alturaAtual > 0) {
            tempo += intervaloTempo;
            double proximaAltura = alturaInicial - calculaAlturaConformeTempo(tempo);
            velocidade = calculaVelocidadeConformeTempo(tempo);

            if (proximaAltura <= 0) {
                tempo = calculaTempoTotalQueda(alturaInicial);
                alturaAtual = 0;
                velocidade = calculaVelocidadeConformeTempo(tempo);
                estados.add(new EstadoQueda(tempo, alturaAtual, velocidade));
            } else {
                estados.add(new EstadoQueda(tempo, proximaAltura, velocidade));
                alturaAtual = proximaAltura;
            }
        }
        return estados;
    }

    public static double calculaAlturaConformeTempo(double tempo) {
        return (AC_GRAVIDADE * Math.pow(tempo, 2)) / 2;
    }

    public static double calculaVelocidadeConformeTempo(double tempo) {
        return AC_GRAVIDADE * tempo;
    }

    public static double calculaTempoTotalQueda(double alturaInicial) {
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

    private static void exibeResultadosQuedaLivre(List<EstadoQueda> estados) {
        System.out.println("Tempo (segundos) | Altura (metros) | Velocidade (metros/segundos)");
        for (EstadoQueda estado : estados) {
            System.out.printf("%.2f | %.2f | %.2f\n", estado.getTempo(), estado.getAltura(), estado.getVelocidade());
        }
    }

}