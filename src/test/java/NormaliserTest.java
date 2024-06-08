import org.example.Normaliser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormaliserTest {

    @Test
    public void testNormalise() {
        Normaliser n = new Normaliser();

        assertEquals("Software engineer", n.normalise("Java engineer"));
        assertEquals("Software engineer", n.normalise("C# engineer"));
        assertEquals("Accountant", n.normalise("Accountant"));
        assertEquals("Accountant", n.normalise("Chief Accountant"));
    }
}
