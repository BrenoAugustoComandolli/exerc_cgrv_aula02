package br.com.exercicio;

import java.util.Scanner;

public class PenduloSimples {

    public static final double AC_GRAVIDADE = 9.8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("##Equação ordinária: Para este calculo será feito a verificação do tempo para completar uma ida e uma volta" +
                "no pendulo, ou seja, o tempo total para chegar uma extremidade e se balançar até próximo a origem ##");

        double angulo = getAngulo(scanner);
        double anguloRadianos = Math.toRadians(angulo);

        double intervaloTempo = getIntervaloTempo(scanner);
        double comprimentoCorda = getComprimentoCorda(scanner);

        double tempoFinal = calculaFrequenciaAngularPendulo(comprimentoCorda);

        realizaCalculoPosicaoAngularIntervaloTempo(tempoFinal, intervaloTempo, anguloRadianos, comprimentoCorda);
    }

    /**
     * Calcula a frequência angular do pêndulo
     */
    public static double calculaFrequenciaAngularPendulo(double comprimentoCorda) {
        return 2 * Math.PI * Math.sqrt(comprimentoCorda / AC_GRAVIDADE);
    }

    /**
     * Calcula a posição angular do pêndulo em graus, conforme tempo e o tamanho da corda
     */
    public static double calculaPosicaoAngularConformeTempo(double anguloRadianos, double comprimentoCorda, double tempoDeslocamento) {
        return anguloRadianos * Math.cos(Math.sqrt(AC_GRAVIDADE / comprimentoCorda) * tempoDeslocamento);
    }

    /**
     * Realiza o cálculo do tempo para completar uma ida e uma volta no pendulo, ou seja, o tempo total para
     * chegar uma extremidade e se balançar até próximo a origem
     */
    private static void realizaCalculoPosicaoAngularIntervaloTempo(double tempoFinal, double intervaloTempo, double anguloRadianos, double comprimentoCorda) {
        double tempoDeslocamento;
        for(tempoDeslocamento = 0; tempoDeslocamento <= tempoFinal; tempoDeslocamento += intervaloTempo) {
            double posicaoAngular = calculaPosicaoAngularConformeTempo(anguloRadianos, comprimentoCorda, tempoDeslocamento);
            System.out.printf("Tempo: %.1f s, Ângulo: %.2f graus%n", tempoDeslocamento, Math.toDegrees(posicaoAngular));
        }
    }

    /**
     * Recupera o ângulo do pêndulo em graus
     */
    private static double getAngulo(Scanner scanner) {
        double angulo = -1;

        while (angulo < 0){
            try {
                System.out.print("Insira o ângulo (graus):");
                angulo = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Angulo inválido, digite um valor válido.");
            }
        }
        return angulo;
    }

    /**
     * Recupera o intervalo de tempo para as atualizações do deslocamento do pêndulo
     */
    private static double getIntervaloTempo(Scanner scanner) {
        double intervaloTempo = -1;

        while (intervaloTempo < 0){
            try {
                System.out.print("Digite o intervalo de tempo para as atualizações do deslocamento o pendulo (em segundos): ");
                intervaloTempo = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return intervaloTempo;
    }

    /**
     * Recupera o comprimento da corda do pendulo
     */
    private static double getComprimentoCorda(Scanner scanner) {
        double comprimentoCorda = -1;

        while (comprimentoCorda < 0){
            try {
                System.out.print("Digite o comprimento a corda (em metros): ");
                comprimentoCorda = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return comprimentoCorda;
    }
}