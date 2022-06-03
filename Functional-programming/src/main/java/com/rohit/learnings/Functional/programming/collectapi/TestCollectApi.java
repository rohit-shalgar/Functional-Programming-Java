package com.rohit.learnings.Functional.programming.collectapi;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestCollectApi {

    public static void main(String[] args) {

        Map<String,Integer> wordCount = FunctionalCode.getEachWordCount();
        for(Map.Entry<String,Integer> entry:wordCount.entrySet()){
            System.out.println("key= "+entry.getKey()+",value= "+entry.getValue());
        }

        List<Melon> melons = Arrays.asList(new Melon("Gac", 2000),
                new Melon("Hemi", 1600), new Melon("Gac", 3000),
                new Melon("Apollo", 2000), new Melon("Horned", 1700));

        String combinedMelons = FunctionalCode.getMelonsAvailable(melons);
        System.out.println("output String is ===" +combinedMelons);
        Assert.isTrue(combinedMelons.equals("Available Melons are -Apollo,Gac,Hemi,Horned Thank you!"));
    }
}
