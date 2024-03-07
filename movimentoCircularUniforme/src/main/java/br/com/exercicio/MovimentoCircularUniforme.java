package br.com.exercicio;

import java.util.Scanner;

public class MovimentoCircularUniforme {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("##O cálculo não precisará informar a velocidade angular, porém nesse caso será " +
                "necessário informar ou a frequência ou período para que o mesmo seja calculados##");

        double raio = getRaio(scanner);
        double velocidadeAngular = getVelocidadeAngular(scanner);

        double velocidadeTangencial = calculaVelocidadeTangencial(velocidadeAngular, raio);
        double aceleracaoCentripeta = calculaAceleracaoCentripeta(velocidadeAngular, raio);

        exibeResultados(velocidadeAngular, velocidadeTangencial, aceleracaoCentripeta);
    }

    /**
     * Calcula a velocidade tangencial usando a fórmula de velocidade angular multiplicado pelo raio
     */
    public static double calculaVelocidadeTangencial(double velocidadeAngular, double raio) {
        return velocidadeAngular * raio;
    }

    /**
     * Calcula a aceleração centrípeta usando a fórmula de velocidade angular ao quadrado multiplicado pelo raio
     */
    public static double calculaAceleracaoCentripeta(double velocidadeAngular, double raio) {
        return (velocidadeAngular * velocidadeAngular) * raio;
    }

    /**
     * Obtém a velocidade angular conforme o período
     */
    public static double getVelocidadeAngularPeloPeriodo(double periodo) {
        return 2 * Math.PI / periodo;
    }

    /**
     * Obtém a velocidade angular conforme a frequência
     */
    public static double getVelocidadeAngularPelaFrequencia(double frequencia) {
        return 2 * Math.PI * frequencia;
    }

    /**
     * Obtém a velocidade angular conforme o tipo de abordagem
     */
    private static double getVelocidadeAngular(Scanner scanner) {
        double velocidadeAngular = -1;

        while (velocidadeAngular < 0) {
            try {
                System.out.print("Você deseja inserir a velocidade angular diretamente? (s/n): ");
                String resposta = scanner.next();
                if (resposta.equalsIgnoreCase("s")) {
                    System.out.print("Digite a velocidade angular (em radianos por segundo): ");
                    velocidadeAngular = scanner.nextDouble();
                } else {
                    System.out.print("Você deseja inserir o período (T) ou a frequência (f)? (T/f): ");
                    resposta = scanner.next();
                    if (resposta.equalsIgnoreCase("T")) {
                        System.out.print("Digite o período (em segundos): ");
                        double periodo = scanner.nextDouble();
                        velocidadeAngular = getVelocidadeAngularPeloPeriodo(periodo);
                    } else {
                        System.out.print("Digite a frequência (em hertz): ");
                        double frequencia = scanner.nextDouble();
                        velocidadeAngular = getVelocidadeAngularPelaFrequencia(frequencia);
                    }
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return velocidadeAngular;
    }

    /**
     * Obtém o raio do circulo
     */
    private static double getRaio(Scanner scanner) {
        double raio = -1;

        while (raio < 0){
            try {
                System.out.print("Digite o raio da trajetória circular (em metros): ");
                raio = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return raio;
    }

    /**
     * Exibe os resultados obtidos pelos cálculos anteriores
     */
    private static void exibeResultados(double velocidadeAngular, double velocidadeTangencial, double aceleracaoCentripeta) {
        System.out.println("Velocidade angular: " + velocidadeAngular + " m/s");
        System.out.println("Velocidade tangencial: " + velocidadeTangencial + " m/s");
        System.out.println("Aceleração centrípeta: " + aceleracaoCentripeta + " m/s²");
    }

}