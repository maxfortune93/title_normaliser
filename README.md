# Normalize Job Titles

## Description

The goal is to create a class that takes an input job title and returns the best-matching normalized job title from a predefined list.

### Problem Description

Given a list of normalized job titles such as "Architect", "Software engineer", "Quantity surveyor", and "Accountant", the task is to match an input job title to the closest normalized title. For example:
- "Java engineer" should be normalized to "Software engineer"
- "C# engineer" should be normalized to "Software engineer"
- "Accountant" should remain "Accountant"
- "Chief Accountant" should be normalized to "Accountant"

The solution should utilize a quality score (0.0 <= q <= 1.0) to determine the closest match.

## Solution

This project implements a job title normalization process. Given a list of normalized job titles, the `Normaliser` class returns the best match for an input job title. The similarity between job titles is calculated using different algorithms, such as Levenshtein Distance and Jaccard Similarity.


## Requirements

- Java 17
- Maven

## Setup

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/normalize-job-titles.git
    ```

2. Import the project into your favorite IDE (such as IntelliJ IDEA or Eclipse).

3. Build the project using Maven:
    ```bash
    mvn clean install
    ```

## Execution

To run the main code, use the `Main` class.

1. Navigate to the `Main` class in the directory structure.
2. Run the class from your IDE.

### Example of `Main.java`

1. Levenshtein Distance

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        SimilarityAlgorithm levenshtein = new LevenshteinDistance();
        Normaliser levenshteinNormaliser = new Normaliser(levenshtein);

        System.out.println("Using Levenshtein Distance:");
        String jt = "Java engineer";
        System.out.println(levenshteinNormaliser.normalize(jt)); // Software engineer

        jt = "C# engineer";
        System.out.println(levenshteinNormaliser.normalize(jt)); // Software engineer

        jt = "Chief Accountant";
        System.out.println(levenshteinNormaliser.normalize(jt)); // Accountant
    }
}

````
2. Jaccard Similarity

```java
package org.example;

public class Main {
    public static void main(String[] args) {
        SimilarityAlgorithm jaccard = new JaccardSimilarity();
        Normaliser jaccardNormaliser  = new Normaliser(jaccard );

        System.out.println("Using Jaccard Similarity:");
        jt = "Java engineer";
        System.out.println(jaccardNormaliser.normalize(jt)); // Software engineer

        jt = "C# engineer";
        System.out.println(jaccardNormaliser.normalize(jt)); // Software engineer

        jt = "Chief Accountant";
        System.out.println(jaccardNormaliser.normalize(jt)); // Accountant
    }
}

````

### Testing

To run the unit tests, use the following Maven command:

```bash
    mvn test
```

The `NormaliserTest` class contains unit tests to verify the functionality of the `Normaliser` class with different similarity algorithms:

```java
package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NormaliserTest {

     @Test
    public void testNormaliseWithLevenshtein() {
        SimilarityAlgorithm algorithm = new LevenshteinDistance();
        Normaliser normaliser = new Normaliser(algorithm);

        assertEquals("Software engineer", normaliser.normalize("Java engineer"));
        assertEquals("Software engineer", normaliser.normalize("C# engineer"));
        assertEquals("Accountant", normaliser.normalize("Accountant"));
        assertEquals("Accountant", normaliser.normalize("Chief Accountant"));
    }

    @Test
    public void testNormaliseWithJaccard() {
        SimilarityAlgorithm algorithm = new JaccardSimilarity();
        Normaliser normaliser = new Normaliser(algorithm);

        assertEquals("Software engineer", normaliser.normalize("Java engineer"));
        assertEquals("Software engineer", normaliser.normalize("C# engineer"));
        assertEquals("Accountant", normaliser.normalize("Accountant"));
        assertEquals("Accountant", normaliser.normalize("Chief Accountant"));
    }
}


````