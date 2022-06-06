package com.rohit.learnings.Functional.programming.summerization;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalCode {
    public static int getMelonsWeightSum(List<Melon> melons) {

        return melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight));
    }

    public static double getMelonsWeightSumKg(List<Melon> melons) {

        return melons.stream()
                .collect(Collectors.summingInt(Melon::getWeight)) / 1000.0d;
    }

    //// reduce- identity,accumulator,combiner, here it starts from 0 and keeps adding all the weights
    public static int getMelonsWeightSumReduce(List<Melon> melons) {
        return melons.stream()
                .collect(Collectors.reducing(0, Melon::getWeight, Integer::sum));
    }

    public static double getMelonsWeightSumKgReduce(List<Melon> melons) {
        return melons.stream()
                .collect(Collectors.reducing(0,Melon::getWeight, (m1,m2) -> m1+m2)) /1000.0d;
    }
}
