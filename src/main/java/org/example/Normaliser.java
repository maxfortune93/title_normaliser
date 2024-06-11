package org.example;

import java.util.HashMap;
import java.util.Map;


public class Normaliser {

    private static final Map<String, String> normalisedTitles = new HashMap<>();
    private SimilarityAlgorithm similarityAlgorithm;
    static {
        normalisedTitles.put("Architect", "Architect");
        normalisedTitles.put("Software engineer", "Software engineer");
        normalisedTitles.put("Quantity surveyor", "Quantity surveyor");
        normalisedTitles.put("Accountant", "Accountant");
    }

    public Normaliser(SimilarityAlgorithm similarityAlgorithm) {
        this.similarityAlgorithm = similarityAlgorithm;
    }

    public String normalise(String jobTitle) {
        String bestMatch = null;
        double bestScore = similarityAlgorithm.isMaximizing() ? -1 : Double.MAX_VALUE;

        for (String normalizedTitle : normalisedTitles.keySet()) {
            double score = similarityAlgorithm.calculate(jobTitle, normalizedTitle);
            if ((similarityAlgorithm.isMaximizing() && score > bestScore) ||
                    (!similarityAlgorithm.isMaximizing() && score < bestScore)) {
                bestScore = score;
                bestMatch = normalizedTitle;
            }
        }

        return normalisedTitles.get(bestMatch);
    }

}
