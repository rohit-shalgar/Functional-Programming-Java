package com.rohit.learnings.Functional.programming.summaxmin;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
                .reduce(0, Integer::sum);// reduce- identity,accumulator,combiner, here it starts from 0 and keeps adding all the weights
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
}
