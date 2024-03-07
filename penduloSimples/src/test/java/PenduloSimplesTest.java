import br.com.exercicio.PenduloSimples;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PenduloSimplesTest {

    @Test
    void testCalculaFrequenciaAngularPendulo() {
        double comprimentoCorda = 7.0;
        double frequenciaEsperada = 5.31;
        assertEquals(frequenciaEsperada, PenduloSimples.calculaFrequenciaAngularPendulo(comprimentoCorda), 0.01,
                "A frequência angular calculada está incorreta");
    }

    @Test
    void testCalculaPosicaoAngularConformeTempo() {
        double anguloRadianos = 1.0;
        double comprimentoCorda = 5.0;
        double tempoDeslocamento = 1.0;
        double posicaoEsperada = 0.16;
        assertEquals(posicaoEsperada, PenduloSimples.calculaPosicaoAngularConformeTempo(anguloRadianos,
                comprimentoCorda, tempoDeslocamento), 0.01, "A posição angular calculada está incorreta");
    }
}