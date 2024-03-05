package br.com.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuedaLivre {

    public static final double AC_GRAVIDADE = 9.80;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double alturaInicial = getAlturaInicial(scanner);
        double intervaloTempo = getIntervaloTempo(scanner);

        List<EstadoQueda> lEstado = calculaPosicaoVelocidadeQueda(intervaloTempo, alturaInicial);
        exibeResultadosQuedaLivre(lEstado);
        scanner.close();
    }

    /**
     * Calcula a posição e a velocidade do objeto em uma queda livre, ou seja, quando o objeto
     * começa a se deslocar até chegar no chão, adicionando os estados a cada intervalo de tempo
     */
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

    /**
     * Equação da altura na queda livre, ou seja, quando foi a altura de deslocamento do objeto
     */
    public static double calculaAlturaConformeTempo(double tempo) {
        return (AC_GRAVIDADE * Math.pow(tempo, 2)) / 2;
    }

    /*
     * Equação da velocidade na queda livre, ou seja, quando foi a velocidade de deslocamento do objeto
     */
    public static double calculaVelocidadeConformeTempo(double tempo) {
        return AC_GRAVIDADE * tempo;
    }

    /**
     * Calcula o tempo total de queda livre, ou seja, o tempo que o objeto que tava em repouso caiu no chão
     */
    public static double calculaTempoTotalQueda(double alturaInicial) {
        return Math.sqrt((2 * alturaInicial) / AC_GRAVIDADE);
    }

    /**
     * Recupera o intervalo de tempo que se quer ver os estados de queda do objeto
     */
    private static double getIntervaloTempo(Scanner scanner) {
        double intervaloTempo = -1;

        while (intervaloTempo < 0){
            try {
                System.out.print("Digite o intervalo de tempo para as atualizações da queda (em segundos): ");
                intervaloTempo = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return intervaloTempo;
    }

    /**
     * Recupera altura inicial do objeto, ou seja, onde o objeto stá em repouso e começa a s deslocar
     */
    private static double getAlturaInicial(Scanner scanner) {
        double alturaInicial = -1;

        while (alturaInicial < 0){
            try {
                System.out.print("Digite a altura inicial (este valor é em metros): ");
                alturaInicial = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return alturaInicial;
    }

    /**
     * Exibe os estados da queda conforme o intervalo de tempo informado.
     */
    private static void exibeResultadosQuedaLivre(List<EstadoQueda> estados) {
        System.out.println("Tempo (segundos) | Altura (metros) | Velocidade (metros/segundos)");
        for (EstadoQueda estado : estados) {
            System.out.printf("%.2f | %.2f | %.2f\n", estado.getTempo(), estado.getAltura(), estado.getVelocidade());
        }
    }

}