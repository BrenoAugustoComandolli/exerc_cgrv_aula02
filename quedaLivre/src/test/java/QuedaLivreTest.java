import br.com.exercicio.EstadoQueda;
import br.com.exercicio.QuedaLivre;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuedaLivreTest {

    @Test
    void testCalculaAlturaConformeTempo() {
        double tempo = 2;
        double alturaEsperada = 19.6;
        assertEquals(alturaEsperada, QuedaLivre.calculaAlturaConformeTempo(tempo), 0.01,
                "Teste fórmula: (g*t^2)/2");
    }

    @Test
    void testCalculaVelocidadeConformeTempo() {
        double tempo = 2;
        double velocidadeEsperada = 19.6;
        assertEquals(velocidadeEsperada, QuedaLivre.calculaVelocidadeConformeTempo(tempo), 0.01,
                "Teste fórmula: g*t.");
    }

    @Test
    void testCalculaTempoTotalQueda() {
        double alturaInicial = 100;
        double tempoEsperado = 4.51;
        assertEquals(tempoEsperado, QuedaLivre.calculaTempoTotalQueda(alturaInicial), 0.01,
                "Teste fórmula: sqrt((2*h)/g).");
    }

    @Test
    void testCalculaPosicaoVelocidadeQueda() {
        double alturaInicial = 100;
        double intervaloTempo = 1;
        List<EstadoQueda> estados = QuedaLivre.calculaPosicaoVelocidadeQueda(intervaloTempo, alturaInicial);

        double[][] dadosEstadoEsperados = {
            {0.0, 100.0, 0.0},
            {1.0, 95.1, 9.81},
            {2.0, 80.4, 19.6},
            {3.0, 55.9, 29.40},
            {4.0, 21.59, 39.2},
            {4.51, 0.0, 44.27}
        };

        assertEquals(dadosEstadoEsperados.length, estados.size(),
                "Quantidade de estados da lista deve ser igual a quantidade de dados esperados");

        for (int i = 0; i < dadosEstadoEsperados.length; i++) {
            assertEquals(dadosEstadoEsperados[i][0], estados.get(i).getTempo(), 0.01, "Tempo não esperado no estado " + i);
            assertEquals(dadosEstadoEsperados[i][1], estados.get(i).getAltura(), 0.01, "Altura não esperada no estado " + i);
            assertEquals(dadosEstadoEsperados[i][2], estados.get(i).getVelocidade(), 0.01, "Velocidade não esperada no estado " + i);
        }
    }

    @Test
    void testCalculaPosicaoVelocidadeQuedaQuandoAlturaInicialForZero() {
        double alturaInicial = 0;
        double intervaloTempo = 1;
        List<EstadoQueda> estados = QuedaLivre.calculaPosicaoVelocidadeQueda(intervaloTempo, alturaInicial);

        assertEquals(1, estados.size(),
                "Não pode ter estado além do inicial quando altura inicial for zero");
    }
}
