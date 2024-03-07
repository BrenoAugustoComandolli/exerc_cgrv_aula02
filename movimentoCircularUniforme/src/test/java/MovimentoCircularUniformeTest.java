import br.com.exercicio.MovimentoCircularUniforme;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovimentoCircularUniformeTest {

    private static final double DELTA = 0.01;

    @Test
    void testCalculaVelocidadeTangencial() {
        assertEquals(250.0, MovimentoCircularUniforme.calculaVelocidadeTangencial(5.0, 50), DELTA);
    }

    @Test
    void testCalculaAceleracaoCentripeta() {
        assertEquals(1250.0, MovimentoCircularUniforme.calculaAceleracaoCentripeta(5.0, 50), DELTA);
    }

    @Test
    void testGetVelocidadeAngularPeloPeriodo() {
        assertEquals(Math.PI, MovimentoCircularUniforme.getVelocidadeAngularPeloPeriodo(2), DELTA);
    }

    @Test
    void testGetVelocidadeAngularPelaFrequencia() {
        assertEquals(Math.PI, MovimentoCircularUniforme.getVelocidadeAngularPelaFrequencia(0.5), DELTA);
    }

}
