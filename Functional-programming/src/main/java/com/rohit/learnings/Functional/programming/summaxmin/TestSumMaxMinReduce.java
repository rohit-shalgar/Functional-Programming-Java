package com.rohit.learnings.Functional.programming.summaxmin;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TestSumMaxMinReduce {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));


        int totalWeightOfMelons = Functional.getTotalWeight(melons);
        int allMelonWeights = Functional.getTotalWeightOfMelonsByReduce(melons);
        System.out.println(totalWeightOfMelons);
        Assert.isTrue(totalWeightOfMelons == 10300);
        System.out.println(allMelonWeights);
        Assert.isTrue(allMelonWeights == 10300);

        Melon heaviestMelon = Functional.getHeaviestMelon(melons);
        System.out.println(heaviestMelon);
        Assert.isTrue(heaviestMelon.getWeight() == 3000);
        Assert.isTrue(heaviestMelon.getType().equals("Gac"));
        Assert.isTrue(heaviestMelon.getWeight() != -1);

        int heaviestMelonWeight = Functional.getHeaviestMelonWeight(melons);
        int heavyMelonWeight = Functional.getHeaviestMelonWeightByReduce(melons);
        System.out.println(heaviestMelonWeight);
        Assert.isTrue(heaviestMelonWeight == 3000);
        Assert.isTrue(heaviestMelonWeight != -1);

        System.out.println(heavyMelonWeight);
        Assert.isTrue(heavyMelonWeight == 3000);
        Assert.isTrue(heavyMelonWeight != -1);

        int lowestMelonWeight = Functional.getLowestMelonWeight(melons);
        System.out.println(lowestMelonWeight);
        Assert.isTrue(lowestMelonWeight == 1600);
        Assert.isTrue(lowestMelonWeight != -1);

        int lowMelonWeight = Functional.getLowestMelonWeightByReduce(melons);
        System.out.println(lowMelonWeight);
        Assert.isTrue(lowMelonWeight == 1600);
        Assert.isTrue(lowMelonWeight != -1);


    }


}
