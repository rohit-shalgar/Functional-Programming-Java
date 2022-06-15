/*
    A high-order function is  a function that returns a function or
    takes a function as a parameter.
 */


package com.rohit.learnings.Functional.programming.highorderfunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HighOrderFunctions {

    public static List<String> replace(
            List<String> input, Replacer<String> r) {
        final List<String> output = new ArrayList<>();
        for (String string : input) {
            output.add(r.replace(string));
        }
        return output;
    }

    //reduce - identity,accumulator,combiner
    @SafeVarargs
    public static Function<String, String> reduceStrings(Function<String, String>... functions) {

        return Stream.of(functions).reduce(Function.identity(), Function::andThen);

    }


    //map generally provides a new Stream, this stream will be Stream<List<String>> or Stream<Stream<R>
    //Certain operations such as distinct() won't work as it will return distinct list<String>
    //Flatmap will flatten the whole structure for such use cases.
    public static List<String> randomStringsWithLambda(List<String> input) {
        return input.stream()
                .map(string -> {
                    Random random = new Random();
                    int randomNumber = random.nextInt(string.length());
                    return String.valueOf(string.charAt(randomNumber));
                }).collect(Collectors.toUnmodifiableList());
    }

    // advisable to write lambda's that are generally in a single line. Hence we will break down this lambda in multiple lambdas.

    //Step 1 - extract lambda to avoid using multiple lines.
    public static String extractCharacter(String string) {
        Random random = new Random();
        return String.valueOf(string.charAt(random.nextInt(string.length())));
    }

    public static List<String> randomStrings(List<String> strings) {
        return strings.stream()
                .map(HighOrderFunctions::extractCharacter)
                .collect(Collectors.toUnmodifiableList());
    }

    public static void debuggingLambdaWithPeek(List<String> strings) {
        strings.stream()
                .peek(p -> System.out.println("\tstream():" + p))
                .filter(s -> s.startsWith("R"))
                .peek(p -> System.out.println("\tfilter():" + p))// data should not be mutated inside peek, its a bad practise.
                .map(String::toUpperCase)
                .peek(p -> System.out.println("\tmap():" + p))
                .collect(Collectors.toList());
    }

    /*
    Some stream methods
    List<Integer> result = ints.stream()
            .filter(i -> i != 0) // filters based on condition , avoid using long conditions, better use method reference
            .distinct() //only selects distinct elements
            .skip(1)  //skips first element from the stream result
            .limit(2) //limit to only 2 results
            .sorted() // natural sorting, we can pass comparator also
            .collect(Collectors.toList());


    */
}
