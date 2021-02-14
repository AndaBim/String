package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{

    static void Assignment1()
    {
        String randomCompilationOfNames[] = {"Computer", "Plate", "Chair", "Girl", "Boy",
                "Cat", "Dog", "Shirt", "Determination"};
        int startsWithCCount = 0;
        int endsWithECount = 0;
        int valuesWithLengthOf5Count = 0;
        int valuesCountainingEcount = 0;
        boolean isThereSubStringTe = true;

        for (int i = 0; i < randomCompilationOfNames.length; i++) {
            //if (randomCompilationOfNames[i].startsWith("C")) //this is one way of getting the result
            if (randomCompilationOfNames[i].charAt(0) == 'C') //this is another way of getting the same result
            {
                // System.out.println(randomCompilationOfNames[i]);
                startsWithCCount++;
            }
            if (randomCompilationOfNames[i].charAt(randomCompilationOfNames[i].length() - 1) == 'e')
            {
                endsWithECount++;
            }
            if (randomCompilationOfNames[i].length() == 5)
            {
                valuesWithLengthOf5Count++;
            }
            if (randomCompilationOfNames[i].contains("e"))
            {
                valuesCountainingEcount++;
            }
            if (randomCompilationOfNames[i].contains("te"))
            {
                isThereSubStringTe = true;
            }
        }
        System.out.println("There are " + startsWithCCount + " value(-s) starting with a 'C'. ");
        System.out.println("There are " + endsWithECount + " value(-s) ending with an 'e'.");
        System.out.println("There are " + valuesWithLengthOf5Count + " value(-s) with the length of 5.");
        System.out.println("There are " + valuesCountainingEcount + " value(-s) containing letter 'e'");
        System.out.println("There are values containing subString 'te'.");
    }

    public static void main(String[] args) {
        Assignment1();
    }
}