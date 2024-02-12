import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    @ParameterizedTest
    @CsvSource({"1, -3, 2, 2.0, 1.0", "1, -2, 1, 1.0, 1.0"})
    void testGetAnswerForRealRoots(int a, int b, int c, double expectedRoot1, double expectedRoot2) throws NotFoundAnswerException {
        MathService mathService = new MathService();
        Pair result = mathService.getAnswer(a, b, c);
        assertNotNull(result);
        assertEquals(expectedRoot1, result.first);
        assertEquals(expectedRoot2, result.second);
    }

    @Test
    void testGetAnswerForComplexRoots() {
        MathService mathService = new MathService();
        assertThrows(NotFoundAnswerException.class,
                ()-> mathService.getAnswer(1, 1, 1));
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1", "2, 1, 2"})
    void testGetAnswerForNoRealRoots(int a, int b, int c) {
        MathService mathService = new MathService();
        assertThrows(NotFoundAnswerException.class,
                () -> mathService.getAnswer(a, b, c));
    }
}