package br.com.exercicio;

import java.util.Scanner;

public class PenduloSimples {

    public static final double AC_GRAVIDADE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("##Equação ordinária: Para este calculo será feito a verificação do tempo para completar uma ida e uma volta" +
                "no pendulo, ou seja, o tempo total para chegar uma extremidade e se balançar até próximo a origem ##");

        double angulo = getAngulo(scanner);
        double anguloRadianos = Math.toRadians(angulo);

        double intervaloTempo = getIntervaloTempo(scanner);
        double comprimentoCorda = getComprimentoCorda(scanner);

        double tempoInicial = 0;
        double tempoFinal = 2 * Math.PI * Math.sqrt(comprimentoCorda / AC_GRAVIDADE);

        for(tempoInicial = 0; tempoInicial <= tempoFinal; tempoInicial += intervaloTempo) {
            double posiçaoAngular = anguloRadianos * Math.cos(Math.sqrt(AC_GRAVIDADE / comprimentoCorda) * tempoInicial);
            System.out.printf("Tempo: %.2f s, Posição Angular: %.4f radianos\n", tempoInicial, posiçaoAngular);
        }
    }

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