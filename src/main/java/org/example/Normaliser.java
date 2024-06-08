package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Normaliser {

    private static final Map<String, String> normalisedTitles = new HashMap<>();

    static {
        normalisedTitles.put("Architect", "Architect");
        normalisedTitles.put("Software engineer", "Software engineer");
        normalisedTitles.put("Quantity surveyor", "Quantity surveyor");
        normalisedTitles.put("Accountant", "Accountant");
    }

    public String normalise(String jobTitle) {
        String bestMatch = null;
        double highestScore = 0.0;

        for (String normalisedTitle : normalisedTitles.keySet()) {
            double score = similarity(jobTitle, normalisedTitle);
            if (score > highestScore) {
                highestScore = score;
                bestMatch = normalisedTitle;
            }
        }

        return normalisedTitles.get(bestMatch);
    }

    private double similarity(String s1, String s2) {
        return calculateJaccardSimilarity(s1, s2);
    }

    private double calculateJaccardSimilarity(String s1, String s2) {
        Set<Character> set1 = s1.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
        Set<Character> set2 = s2.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());

        Set<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<Character> union = new HashSet<>(set1);
        union.addAll(set2);

        return (double) intersection.size() / union.size();
    }

}
