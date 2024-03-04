import br.com.exercicio.ColisaoParticulas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ColisaoParticulasTest {

    @Test
    void testCalculaVelocidadeFinalPart1() {
        double msPart1 = 2.0;
        double msPart2 = 3.0;
        double velPart1 = 10.0;
        double velPart2 = 5.0;
        double velFinalEsperada = 4.0;

        double result = ColisaoParticulas.calculaVelocidadeFinalPart1(msPart1, msPart2, velPart1, velPart2);

        assertEquals(velFinalEsperada, result, 0.01, "A velocidade final final está errada");
    }

    @Test
    void testCalculaVelocidadeFinalPart2() {
        double msPart1 = 2.0;
        double msPart2 = 3.0;
        double velPart1 = 10.0;
        double velPart2 = 5.0;
        double velFinalEsperada = 9.0;

        double result = ColisaoParticulas.calculaVelocidadeFinalPart2(msPart1, msPart2, velPart1, velPart2);

        assertEquals(velFinalEsperada, result, 0.01, "A velocidade final final está errada");
    }

}