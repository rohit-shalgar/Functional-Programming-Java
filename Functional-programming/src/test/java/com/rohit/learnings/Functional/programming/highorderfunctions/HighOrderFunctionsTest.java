package com.rohit.learnings.Functional.programming.highorderfunctions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class HighOrderFunctionsTest {

    @Test
    public void testcase1_replace() {
        List<String> names = new ArrayList<>(Arrays.asList("Roh i t  29", "Silvann a 28"));
        List<String> replaceSpaces = HighOrderFunctions.replace(
                names, (String s) -> s.replaceAll("\\s", "")
        );
        Assertions.assertEquals(Arrays.asList("Rohit29", "Silvanna28"), replaceSpaces);
        List<String> replaceNumbers = HighOrderFunctions.replace(
                names, (String s) -> s.replaceAll("\\d", "")
        );
        Assertions.assertEquals(Arrays.asList("Roh i t  ", "Silvann a "), replaceNumbers);

    }

    @Test
    public void testcase2_reduceStrings() {
        Function<String,String> function1 = String::toLowerCase;
        Function<String,String> function2 = (String s) -> s.concat("done");
        Function<String,String> functionResult = HighOrderFunctions.reduceStrings(function1,function2);

        String finalResult = functionResult.apply("TEST");
        Assertions.assertEquals("testdone",finalResult);

    }

    @Test
    public void testcase3_randomStrings() {
        final List<String> strings = new ArrayList<>(Arrays.asList("Rohit","Silavanna","Lambda"));
        List<String> output = HighOrderFunctions.randomStringsWithLambda(strings);
        for(String s:output){
            Assertions.assertEquals(1, s.length());
        }

    }

    @Test
    public void testcase4_randomStringsUpdated() {
        String sample1 = "ROhit";
        String sample2 = "Silvanna";
        String sample3 = "Devyani";

        String randomCharacter1 = HighOrderFunctions.extractCharacter(sample1);
        String randomCharacter2 = HighOrderFunctions.extractCharacter(sample2);
        String randomCharacter3 = HighOrderFunctions.extractCharacter(sample3);

        Assertions.assertEquals(1,randomCharacter1.length());
        Assertions.assertEquals(1,randomCharacter2.length());
        Assertions.assertEquals(1,randomCharacter3.length());
        Assertions.assertTrue(sample1.contains(randomCharacter1));
        Assertions.assertTrue(sample2.contains(randomCharacter2));
        Assertions.assertTrue(sample3.contains(randomCharacter3));

        List<String> strings = new ArrayList<>();
        strings.add(sample1);
        strings.add(sample2);
        strings.add(sample3);

        List<String> randomCharStrings = HighOrderFunctions.randomStrings(strings);
        Assertions.assertEquals(3,randomCharStrings.size());
        for(String randomString: randomCharStrings){
            Assertions.assertEquals(1,randomString.length());
        }

    }

    @Test()
    public void testcase5_debuggingWithLambdaTest(){
        Assertions.assertThrows(NullPointerException.class,() ->{
            HighOrderFunctions.debuggingLambdaWithPeek(new ArrayList<>(Arrays.asList("Rohit",null)));
        });

    }
}
