package com.rohit.learnings.Functional.programming.summerization;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class TestSummerization {

    public static void main(String[] args) {

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        int melonWeightsInGrams = FunctionalCode.getMelonsWeightSum(melons);

        System.out.println("Sum of all the melon weights is ->"+melonWeightsInGrams);
        Assert.isTrue(melonWeightsInGrams == 10300);

        double melonWeightsInKg = FunctionalCode.getMelonsWeightSumKg(melons);

        System.out.println("Sum of all the melon weights in KG is ->"+melonWeightsInKg);
        Assert.isTrue(melonWeightsInKg == 10.3d);


        int melonWeightsInGms = FunctionalCode.getMelonsWeightSumResuce(melons);

        System.out.println("Sum of all the melon weights is ->"+melonWeightsInGms);
        Assert.isTrue(melonWeightsInGms == 10300);

        double melonWeightsInKgs = FunctionalCode.getMelonsWeightSumKgReduce(melons);

        System.out.println("Sum of all the melon weights KG is ->"+melonWeightsInKgs);
        Assert.isTrue(melonWeightsInKgs == 10.3d);

    }
}
