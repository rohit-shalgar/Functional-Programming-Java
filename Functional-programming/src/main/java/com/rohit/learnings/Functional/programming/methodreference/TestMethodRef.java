package com.rohit.learnings.Functional.programming.methodreference;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class TestMethodRef {

    public static void main(String[] args) {

        Melon melon1 = new Melon("Gac", 3000);
        Melon melon2 = new Melon("Hemi", 1600);
        Melon melon4 = new Melon("Apollo", 2000);
        Melon melon5 = new Melon("Horned", 1700);

        List<Melon> melons = Arrays.asList(melon1, melon2, melon4, melon5);

        Melon highestGrowingMelon = MethodRefFunctionalCode.getGrowingMelonByStaticMethodRef(melons);
        Assert.isTrue(highestGrowingMelon.getWeight() == 3300);
        Assert.isTrue(highestGrowingMelon.getType().equals("Gac"));

        List<Melon> descSortedMelons = MethodRefFunctionalCode.getGrowingMelonByInstanceMethodRef(melons);
        System.out.println(descSortedMelons);
        Assert.isTrue(descSortedMelons.get(0).getType().equals("Gac"));

        Melon newMelon = MethodRefFunctionalCode.melonFactory().apply("Hemi",1540);
        Assert.isTrue(newMelon.getWeight()==1540);

    }
}
