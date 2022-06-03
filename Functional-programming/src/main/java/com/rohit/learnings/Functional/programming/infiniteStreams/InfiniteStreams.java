package com.rohit.learnings.Functional.programming.infiniteStreams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InfiniteStreams {

    public static void main(String[] args) {
        System.out.println(firstTenEvenNumbers());
        System.out.println(randomTwentyFiveNumbersGenerator());

    }

    //Stream.iterate will create an infinite stream and it is an lazy operation.
    // Without the limit() this will run forever due to the terminating operation - collect(Collectors.toList())
    public static List<Integer> firstTenEvenNumbers(){
        Stream<Integer> infiniteStream = Stream.iterate(1, i-> i+1);
        return infiniteStream.filter(i -> i %2 == 0)
                .limit(10)
                .collect(Collectors.toList());
    }

    public static List<Integer> randomTwentyFiveNumbersGenerator(){
        Stream<Integer> infiniteStream = Stream.iterate(1,
                i-> i <= 10,
                i -> i+i%2 == 0 ? new Random().nextInt(20):-1* new Random().nextInt(10));
        return infiniteStream
                .limit(25)
                .distinct()
                .collect(Collectors.toList());
    }

    /*
     takeWhile(predicate) and dropWhile(predicate) - new additions from Java 9.
        they are expensive, avoid using them in parallel streams.
        they might produce unexpected result as once the predicate condition breaks, the takewhile/dropwhile condition drops.
        avoid using with ordered data, BaseStream.unordered() might help in this case.
    */
}
