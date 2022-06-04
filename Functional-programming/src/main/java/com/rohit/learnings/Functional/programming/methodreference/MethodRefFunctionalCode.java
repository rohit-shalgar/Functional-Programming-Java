package com.rohit.learnings.Functional.programming.methodreference;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class MethodRefFunctionalCode {

    private final static MelonComparator comparator = new MelonComparator();

    public static Melon getGrowingMelonByStaticMethodRef(List<Melon> melons) {
        return melons.stream()
                .max(Comparator.comparing(Melon::growing100g))
                .orElse(null);
    }

    public static List<Melon> getGrowingMelonByInstanceMethodRef(List<Melon> melons) {
        return melons.stream()
                .sorted(comparator::compare)
                .collect(Collectors.toList());
    }
    public static BiFunction<String,Integer,Melon> melonFactory(){
        return Melon::new;
    }
}
