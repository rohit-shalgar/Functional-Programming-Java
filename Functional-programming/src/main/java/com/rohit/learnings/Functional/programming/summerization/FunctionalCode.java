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

    public static int getMelonsWeightSumResuce(List<Melon> melons) {
        return melons.stream()
                .collect(Collectors.reducing(0, m -> m.getWeight(),(m1,m2) -> m1+m2));
    }

    public static double getMelonsWeightSumKgReduce(List<Melon> melons) {
        return melons.stream()
                .collect(Collectors.reducing(0,m -> m.getWeight(), (m1,m2) -> m1+m2)) /1000.0d;
    }
}
