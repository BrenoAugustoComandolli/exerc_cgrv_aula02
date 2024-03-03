package br.com.exercicio;

public class EstadoProjetil {
    double tempo;
    double x;
    double y;

    public EstadoProjetil(double tempo, double x, double y) {
        this.tempo = tempo;
        this.x = x;
        this.y = y;
    }

    public double getTempo() {
        return tempo;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("Tempo: %.2f s - Posição: (x: %.2f m, y: %.2f m)", tempo, x, y);
    }

}
