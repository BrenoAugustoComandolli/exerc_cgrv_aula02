package br.com.exercicio;

public class EstadoQueda {
    private final double tempo;
    private final double altura;
    private final double velocidade;

    public EstadoQueda(double tempo, double altura, double velocidade) {
        this.tempo = tempo;
        this.altura = altura;
        this.velocidade = velocidade;
    }

    public double getTempo() {
        return tempo;
    }

    public double getAltura() {
        return altura;
    }

    public double getVelocidade() {
        return velocidade;
    }
}