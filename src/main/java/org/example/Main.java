package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Predicate<String> isLong = s -> s.length() >10;
        String str1 = "short";
        String str2 = "This is a very long string";
        System.out.println("Is '" + str1 + "' long? " + isLong.test(str1));
        System.out.println("Is '" + str2 + "' long? " + isLong.test(str2));

        List<String> callSigns = new ArrayList<>();
        callSigns.add("Alpha");
        callSigns.add("Bravo");
        callSigns.add("Archangel");
        callSigns.add("Echo");
        callSigns.add("Avenger");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        filterAndPrint(callSigns, startsWithA, "Call signs starting with A");

        Predicate<String> hasLengthGreaterThan5 = s -> s.length()>5;
        Predicate<String> combined =startsWithA.and(hasLengthGreaterThan5);
        filterAndPrint(callSigns, combined, "Starts with 'A' AND length > 5");

        Predicate<String> doesNotStartWithA = startsWithA.negate();
        filterAndPrint(callSigns, doesNotStartWithA, "does NOT start with 'A'");

    }

    public static void filterAndPrint(List<String> list, Predicate<String> predicate, String description){
        System.out.println("--- " + description + " ---");
        for(String item : list){
            if(predicate.test(item)){
                System.out.println(item);
            }
        }
        System.out.println();
    }
}