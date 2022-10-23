package com.shan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        // Challenge 1
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };


        // Challenge 2
        Function<String, String> lambdaFunction = (String source) -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // Challenge 3
        System.out.println(lambdaFunction.apply("1234567890"));
        System.out.println("-----------------------------");
        // Challenge 5
        System.out.println(everySecondChar(lambdaFunction, "1234567890"));

        // Challenge 6
        Supplier<String> iLoveJava = () -> {
            return "I love Java";
        };
        // Challenge 7
        System.out.println(iLoveJava.get());

        // Challenge 8 questions

        // Challenge 9
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name -> {
            firstUpperCaseList.add(name.substring(0, 1).toUpperCase() + name.substring(1));
        });
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s -> System.out.println(s));

        System.out.println("--------------------");

        // Challenge 10
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

        System.out.println("--------------------");

        // Challenge 11
        topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);

        System.out.println("--------------------");
        // Challenge 12
        long namesBeginningWithA = topNames2015
                .stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);

        System.out.println("--------------------");
        // Challenge 13
        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo);
        // Nothing print: this chain doesn't contain a terminal operation.

        System.out.println("--------------------");
        // Challenge 14
        topNames2015
                .stream()
                .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .collect(Collectors.toList());


    }

    // Challenge 4
    public static String everySecondChar(Function<String, String> function, String source) {

        return function.apply(source);
    }
}