package org.example;

public class Main {
    public static void main(String[] args) {

        SimilarityAlgorithm levenshtein = new LevenshteinDistance();
        Normaliser levenshteinNormaliser = new Normaliser(levenshtein);


        System.out.println("Using Levenshtein Distance:");
        String jt = "Java engineer";
        System.out.println(levenshteinNormaliser.normalise(jt));

        jt = "C# engineer";
        System.out.println(levenshteinNormaliser.normalise(jt));

        jt = "Chief Accountant";
        System.out.println(levenshteinNormaliser.normalise(jt));

    }
}