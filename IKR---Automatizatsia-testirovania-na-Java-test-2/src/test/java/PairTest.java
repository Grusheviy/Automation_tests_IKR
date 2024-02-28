import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PairTest {

    @Test
    void testToString() {
        Pair pair = new Pair(1.0, 2.0);

        String expectedString = "Answer{first=1.0, second=2.0}";
        String actualString = pair.toString();

        assertEquals(expectedString, actualString);
    }
}