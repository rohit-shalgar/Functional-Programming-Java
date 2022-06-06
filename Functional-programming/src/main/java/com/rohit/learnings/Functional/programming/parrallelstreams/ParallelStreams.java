package com.rohit.learnings.Functional.programming.parrallelstreams;

import java.util.*;

public class ParallelStreams {

    public static double getNineMillionNumbersSum() {
        List<Double> sampleNumberSet = getNineMillionNumbers();
        long startTime = System.currentTimeMillis();
        double output = sampleNumberSet.stream().reduce(Double::sum).orElse(-1D);
        long endTime = System.currentTimeMillis();
        System.out.println("That processing took -" + (endTime - startTime));
        return output;
    }

    /*
        task is broken down into small chunks using fork/join framework. and then joined using synchronizer's.
        By default - forkjoinpool is created with int noOfProcessors = Runtime.getRuntime().availableProcessors();
        But we can set property to change number of thread or create a commonpool and -submit() the task
        But ideal is no of threads = no of processors.
        Parallel streams is good for huge data sets and benchmark against normal thread should be calculated first.

     */
    public static double getNineMillionNumbersSumParrallel() {

        List<Double> sampleNumberSet = getNineMillionNumbers();
        long startTime = System.currentTimeMillis();
        double output = sampleNumberSet.parallelStream()
                .reduce(Double::sum)
                .orElse(-1D);
        long endTime = System.currentTimeMillis();
        System.out.println("That processing took -" + (endTime - startTime));
        return output;
    }

    private static List<Double> getNineMillionNumbers() {
        final Random random = new Random();
        final List<Double> randomDoubles = new ArrayList<>();
        for (int i = 0; i < 9_0000_000; i++) {
            randomDoubles.add(random.nextDouble());
        }

        return randomDoubles;
    }

    /*
        SplitIterator - splittable iterator is used to traverse elements in parrallel streams.
     */

    public static void splitIteratorBasics() {
        List<Double> sampleNumberSet = getNineMillionNumbers();
        sampleNumberSet.parallelStream().spliterator().tryAdvance(e-> System.out.println("First random double is -"+e)); // tryAdvance - first number
        Spliterator<Double> spliterator = sampleNumberSet.spliterator();
        Spliterator<Double> spliterator2 = spliterator.trySplit();

        System.out.println("SplitIterator1 has size - "+spliterator.estimateSize());// split further
        System.out.println("SplitIterator2 has size - "+spliterator2.estimateSize());

        //for each remaining element
        //spliterator.forEachRemaining(System.out::println);
        //spliterator2.forEachRemaining(System.out::println);

        // get characteristics such as ordered, distinct() etc..
        System.out.println(spliterator.characteristics());
        System.out.println(spliterator2.characteristics());




    }
}
