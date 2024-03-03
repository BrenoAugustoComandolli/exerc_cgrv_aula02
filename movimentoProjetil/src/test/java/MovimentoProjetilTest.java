import br.com.exercicio.EstadoProjetil;
import br.com.exercicio.MovimentoProjetil;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovimentoProjetilTest {

    @Test
    void testCalcularTempoDeVooAteChegarSolo() {
        double velocidadeInicialY = 10;
        double tempoEsperado = 2.03;
        double tempoCalculado = MovimentoProjetil.calcularTempoDeVooAteChegarSolo(velocidadeInicialY);
        assertEquals(tempoEsperado, tempoCalculado, 0.01, "O tempo de voo calculado está errado");
    }


    @Test
    void testCalculaTrajetoriaProjetil() {
        double angulo = 45;
        double intervaloTempo = 1;

        double anguloRadianos = Math.toRadians(angulo);
        double velocidadeInicialX = 20 * Math.cos(anguloRadianos);
        double velocidadeInicialY = 20 * Math.sin(anguloRadianos);
        double tempoTotal = MovimentoProjetil.calcularTempoDeVooAteChegarSolo(velocidadeInicialY);

        List<EstadoProjetil> estados = MovimentoProjetil.calculaTrajetoriaProjetil(tempoTotal, intervaloTempo,
                velocidadeInicialX, velocidadeInicialY);

        double[][] dadosEstadoEsperados = {
            {0.0, 0.0, 0.0},
            {1.0, 14.14, 9.24},
            {2.0, 28.28, 8.66},
            {2.88, 40.77, 0.0},
        };

        assertEquals(dadosEstadoEsperados.length, estados.size(),
                "Lista de estados deve ser igual ao número esperado");

        for (int i = 0; i < dadosEstadoEsperados.length; i++) {
            assertEquals(dadosEstadoEsperados[i][0], estados.get(i).getTempo(), 0.1,
                    "Tempo errado no estado " + i);
            assertEquals(dadosEstadoEsperados[i][1], estados.get(i).getX(), 0.1,
                    "Posição X errada no estado " + i);
            assertEquals(dadosEstadoEsperados[i][2], estados.get(i).getY(), 0.1,
                    "Posição Y errada no estado " + i);
        }
    }


    @Test
    void testCalcularPosicaoVertical() {
        double velocidadeInicialY = 10;
        double tempo = 2;
        double posicaoEsperada = 0.37;
        double posicaoCalculada = MovimentoProjetil.calcularPosicaoVertical(velocidadeInicialY, tempo);
        assertEquals(posicaoEsperada, posicaoCalculada, 0.01, "A posição vertical calculada está errada");
    }

    @Test
    void testCalcularPosicaoHorizontal() {
        double velocidadeInicialX = 5;
        double tempo = 2;
        double posicaoEsperada = 10.0;
        double posicaoCalculada = MovimentoProjetil.calcularPosicaoHorizontal(velocidadeInicialX, tempo);
        assertEquals(posicaoEsperada, posicaoCalculada, 0.001, "A posição horizontal calculada está errada");
    }

    @Test
    void testCalculaComponenteVerticalVelocidade() {
        double velocidadeInicial = 10;
        double anguloGraus = 45;
        double anguloRadianos = Math.toRadians(anguloGraus);
        double componenteVerticalEsperada = 7.07;
        double componenteVerticalCalculada = MovimentoProjetil.calculaComponenteVerticalVelocidade(velocidadeInicial, anguloRadianos);
        assertEquals(componenteVerticalEsperada, componenteVerticalCalculada, 0.01,
                "O valor do componente vertical está errado");
    }

    @Test
    void testCalculaComponenteHorizontalVelocidade() {
        double velocidadeInicial = 10;
        double anguloGraus = 45;
        double anguloRadianos = Math.toRadians(anguloGraus);
        double componenteHorizontalEsperada = 7.07;
        double componenteHorizontalCalculada = MovimentoProjetil.calculaComponenteHorizontalVelocidade(velocidadeInicial, anguloRadianos);
        assertEquals(componenteHorizontalEsperada, componenteHorizontalCalculada, 0.01,
                "O valor do componente horizontal está errado");
    }
}