package org.example;

public interface SimilarityAlgorithm {
    double calculate(String s1, String s2);
    boolean isMaximizing();
}