package com.rohit.learnings.Functional.programming.parrallelstreams;

public class ParallelStreamsTest {

    public static void main(String[] args) {

        System.out.println("Total sum is ->"+ParallelStreams.getNineMillionNumbersSum());
        System.out.println("Total sum in parallel is ->"+ParallelStreams.getNineMillionNumbersSumParrallel());
        ParallelStreams.splitIteratorBasics();
    }
}
