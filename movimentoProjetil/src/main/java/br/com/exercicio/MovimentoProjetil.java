package br.com.exercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovimentoProjetil {

    public static final double AC_GRAVIDADE = 9.81;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("## Para este calculo não será considerado a resistência do ar, nem a massa do objeto, " +
                "apenas a movimentação do projétil, seguindo o princípio da equivalência ##");

        double velocidadeInicial = getVelocidadeInicial(scanner);
        double angulo = getAngulo(scanner);
        double intervaloTempo = getIntervaloTempo(scanner);

        double anguloRadianos = Math.toRadians(angulo);
        double velocidadeInicialX = calculaComponenteHorizontalVelocidade(velocidadeInicial, anguloRadianos);
        double velocidadeInicialY = calculaComponenteVerticalVelocidade(velocidadeInicial, anguloRadianos);

        double tempoTotal = calcularTempoDeVooAteChegarSolo(velocidadeInicialY);

        List<EstadoProjetil> lEstados = calculaTrajetoriaProjetil(tempoTotal, intervaloTempo,
                velocidadeInicialX, velocidadeInicialY);

        exibeTrajetoria(lEstados);
    }

    public static double calcularTempoDeVooAteChegarSolo(double velocidadeInicialY) {
        return (2 * velocidadeInicialY) / AC_GRAVIDADE;
    }

    public static List<EstadoProjetil> calculaTrajetoriaProjetil(double tempoTotal, double intervaloTempo,
                                                                 double velocidadeInicialX, double velocidadeInicialY) {
        List<EstadoProjetil> lEstados = new ArrayList<>();

        for (double i = 0; i <= tempoTotal; i += intervaloTempo) {
            double x = calcularPosicaoHorizontal(velocidadeInicialX, i);
            double y = calcularPosicaoVertical(velocidadeInicialY, i);

            if (i + intervaloTempo > tempoTotal) {
                lEstados.add(new EstadoProjetil(i, x, y));
                lEstados.add(new EstadoProjetil(tempoTotal, velocidadeInicialX * tempoTotal, 0));
                break;
            }
            lEstados.add(new EstadoProjetil(i, x, y));
        }

        return lEstados;
    }

    public static double calcularPosicaoVertical(double velocidadeInicialY, double i) {
        return (velocidadeInicialY * i) - (AC_GRAVIDADE / 2) * Math.pow(i, 2);
    }

    public static double calcularPosicaoHorizontal(double velocidadeInicialX, double i) {
        return velocidadeInicialX * i;
    }

    public static double calculaComponenteVerticalVelocidade(double velocidadeInicial, double anguloRadianos) {
        return velocidadeInicial * Math.sin(anguloRadianos);
    }

    public static double calculaComponenteHorizontalVelocidade(double velocidadeInicial, double anguloRadianos) {
        return velocidadeInicial * Math.cos(anguloRadianos);
    }

    private static void exibeTrajetoria(List<EstadoProjetil> lEstados) {
        for (EstadoProjetil posicao : lEstados) {
            System.out.println(posicao);
        }
    }

    private static double getVelocidadeInicial(Scanner scanner) {
        double velocidadeInicial = -1;

        while (velocidadeInicial < 0){
            try {
                System.out.print("Digite a velocidade inicial do projétil (metros/segundo):");
                velocidadeInicial = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Velocidade inválida, digite um valor válido.");
            }
        }
        return velocidadeInicial;
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
                System.out.print("Digite o intervalo de tempo para as atualizações da queda (em segundos): ");
                intervaloTempo = scanner.nextDouble();
            }catch (Exception e) {
                scanner.next();
                System.out.println("Valor inválido, digite um valor válido.");
            }
        }
        return intervaloTempo;
    }
}