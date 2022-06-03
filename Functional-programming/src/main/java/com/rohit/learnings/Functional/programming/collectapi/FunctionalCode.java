package com.rohit.learnings.Functional.programming.collectapi;

import com.rohit.learnings.Functional.programming.summaxmin.Melon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionalCode {

    //Collect the word frequency count in an given string
    public static Map<String,Integer> getEachWordCount(){

        String str = "orem Ipsum is simply \n" +
                "    Ipsum Lorem not simply Ipsum";

        return Stream.of(str)
                .map(s -> s.split("\\s+"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(
                        String::toLowerCase, s -> 1,Integer::sum));

    }

    //Collectors.joining() will concatinate the results into a String
    // you can a delimiter,prefix and suffix as well.

    //Q- get all the MELON names in sorted order
    public static String getMelonsAvailable(List<Melon> melons){
        return melons.stream()
                .map(Melon::getType)
                .distinct()
                .sorted()
                .collect(Collectors.joining(",","Available Melons are -"," Thank you!"));
    }

}
