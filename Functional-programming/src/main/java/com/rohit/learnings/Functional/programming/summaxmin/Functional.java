package com.rohit.learnings.Functional.programming.summaxmin;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Functional {

    public static int getHeaviestMelonWeightByReduce(List<Melon> melons) {
        return melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::max)
                .orElse(-1);
    }

    public static int getTotalWeightOfMelonsByReduce(List<Melon> melons) {
        return melons.stream()
                .map(Melon::getWeight)
                .reduce(0, Integer::sum);
        // you can simply change the lambda in reduce to get the desired result.
    }


    public static int getLowestMelonWeight(List<Melon> melons) {
        return melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);
    }

    public static int getHeaviestMelonWeight(List<Melon> melons) {
        return melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);
    }

    //How can we calculate total weight of all the melons?
    public static int getTotalWeight(List<Melon> melons) {
        return melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();
    }

    //what is the heaviest melon?
    public static Melon getHeaviestMelon(List<Melon> melons) {
        Optional<Melon> heaviestOptionalMelon = Optional.of(melons.stream()
                .max(Comparator.comparing(Melon::getWeight)).
                orElse(new Melon("Not Found", -1)));
        return heaviestOptionalMelon.get();
    }

    public static int getLowestMelonWeightByReduce(List<Melon> melons) {
        return melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);
    }

    //Filter melons that are heavier than 1,000 grams,
    // collect the result without duplicates, and sort into ascending order
    public static TreeSet<Integer> getMelonsHeavierThanCertainWeight(List<Melon> melons) {
        return melons.stream()
                .map(Melon::getWeight)
                .filter(weight -> weight >= 1000)
                .collect(Collectors.toCollection(TreeSet::new));
    }

}
