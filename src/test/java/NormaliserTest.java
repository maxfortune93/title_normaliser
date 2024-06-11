import org.example.JaccardDistance;
import org.example.LevenshteinDistance;
import org.example.Normaliser;
import org.example.SimilarityAlgorithm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NormaliserTest {

    @Test
    public void testNormaliseWithLevenshtein() {
        SimilarityAlgorithm algorithm = new LevenshteinDistance();
        Normaliser normaliser = new Normaliser(algorithm);

        assertEquals("Software engineer", normaliser.normalise("Java engineer"));
        assertEquals("Software engineer", normaliser.normalise("C# engineer"));
        assertEquals("Accountant", normaliser.normalise("Accountant"));
        assertEquals("Accountant", normaliser.normalise("Chief Accountant"));
    }

    @Test
    public void testNormaliseWithJaccard() {
        SimilarityAlgorithm algorithm = new JaccardDistance();
        Normaliser normaliser = new Normaliser(algorithm);

        assertEquals("Software engineer", normaliser.normalise("Java engineer"));
        assertEquals("Software engineer", normaliser.normalise("C# engineer"));
        assertEquals("Accountant", normaliser.normalise("Accountant"));
        assertEquals("Accountant", normaliser.normalise("Chief Accountant"));
    }
}
