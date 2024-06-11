package org.example;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class JaccardDistance implements SimilarityAlgorithm {
    @Override
    public double calculate(String s1, String s2) {
        return calculateJaccardSimilarity(s1, s2);
    }

    @Override
    public boolean isMaximizing() {
        return true;
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
