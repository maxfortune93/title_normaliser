package org.example;

public class Main {
    public static void main(String[] args) {
        Normaliser n = new Normaliser();

        String jt = "Java engineer";
        System.out.println(n.normalise(jt));

        jt = "C# engineer";
        System.out.println(n.normalise(jt));

        jt = "Chief Accountant";
        System.out.println(n.normalise(jt));
    }
}