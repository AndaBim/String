package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PAString {

    static void Assignment1() {
        String randomCompilationOfNames[] = {"Computer", "Plate", "Chair", "Girl", "Boy",
                "Cat", "Dog", "Shirt", "Determination"};
        int startsWithCCount = 0;
        int endsWithECount = 0;
        int valuesWithLengthOf5Count = 0;
        int valuesCountainingEcount = 0;
        boolean isThereSubStringTe = false;

        for (int i = 0; i < randomCompilationOfNames.length; i++) {
            //if (randomCompilationOfNames[i].startsWith("C")) //this is one way of getting the result
            if (randomCompilationOfNames[i].charAt(0) == 'C') //this is another way of getting the same result
            {
                startsWithCCount++;
            }
            if (randomCompilationOfNames[i].charAt(randomCompilationOfNames[i].length() - 1) == 'e') {
                endsWithECount++;
            }
            if (randomCompilationOfNames[i].length() == 5) {
                valuesWithLengthOf5Count++;
            }
            if (randomCompilationOfNames[i].contains("e")) {
                valuesCountainingEcount++;
            }
            if (randomCompilationOfNames[i].contains("te")) {
                isThereSubStringTe = true;
            }
        }
        //histogram
        int[] emptyArrForCharacterCount = new int[12];

        for (int j = 0; j < emptyArrForCharacterCount.length; j++) {
            int charCounter2 = 0;
            for (String word : randomCompilationOfNames) {
                if (j == word.length()) {
                    charCounter2++;
                }
            }
            emptyArrForCharacterCount[j] = charCounter2;
            if (charCounter2 != 0) {
                System.out.println("There are " + emptyArrForCharacterCount[j] + " words with " + j + " characters.");
            }
        }


        System.out.println("There are " + startsWithCCount + " value(-s) starting with a 'C'. ");
        System.out.println("There are " + endsWithECount + " value(-s) ending with an 'e'.");
        System.out.println("There are " + valuesWithLengthOf5Count + " value(-s) with the length of 5.");
        System.out.println("There are " + valuesCountainingEcount + " value(-s) containing letter 'e'");
        if(isThereSubStringTe)
        {
        System.out.println("There are values containing subString 'te'.");
    } else
        {
            System.out.println("Very sad news, no substring 'te' found");
        }
    }

    static void Assignment2() {
        String theMountainThing = "Climb mountains not so the world can see you, but so you can see the world";

        //how many words in the sentence
        //String[] wordsArr = theMountainThing.split("\\s+");
        String[] wordsArr = theMountainThing.replaceAll("[^a-z A-Z]", "").toLowerCase().split("\\s+");//https://stackoverflow.com/questions/18830813/how-can-i-remove-punctuation-from-input-text-in-java
        System.out.println("There are " + wordsArr.length + " words in the sentence.");

        //how many "the" in the sentence
        int count = 0;
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i].equalsIgnoreCase("the")) {
                count++;
            }
        }
        System.out.println("There are " + count + " 'the' in the sentence.");

        //how many words contain letter "C"
        int count1 = 0;
        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i].contains("s")) {
                count1++;
            }
        }
        System.out.println("There are " + count1 + " words containing letter 's'.");

        //words that are repeated
        System.out.print("These words are repeated in the sentence: ");
        int count2 = 0;
        for (int i = 0; i < wordsArr.length; i++) {
            count2 = 1;
            for (int j = i + 1; j < wordsArr.length; j++) {
                if (wordsArr[i].equalsIgnoreCase(wordsArr[j])) {
                    count2++;
                    wordsArr[j] = "0";
                }
            }
            if (count2 > 1 && wordsArr[i] != "0") {
                System.out.print(wordsArr[i] + "; ");

            }
        }
        System.out.println("");

        //changing you to You
        String youToUpperCase = theMountainThing.replaceAll("you", "You");
        System.out.println(youToUpperCase);

    }

    static void Assignment3() {

        String name = "John";
        String namePattern = "[a-zA-Z]+";

        if (name.matches(namePattern)) {
            System.out.println("All correct");
        } else {
            System.out.println("Something is not working");
        }

        String username = "s20surname";
        String usernamePatter = "[a-z]{1}[0-9]{2}[a-z]+";

        if (username.matches(usernamePatter)) {
            System.out.println("you are programming God");
        } else {
            System.out.println("read the manual!");
        }

        String personCodeOfLatvia = "121200-11311";
        String personCodeofLatviaPattern = "[0-9]{6}-[0-9]{5}";

        if (personCodeOfLatvia.matches(personCodeofLatviaPattern)) {
            System.out.println("All is good");
        } else {
            System.out.println("Need to read more on regex");
        }
    }

    enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    }

    enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    static void Assignment4() {
        String cardPack[] = new String[52];
        int i = 0;

        //creating a pack of cards
        for (Suit iSuit : Suit.values()) {
            for (Value iValue : Value.values()) {
                cardPack[i] = iValue + " of " + iSuit;
                i++;
            }
        }
        // shuffle cards (using https://www.journaldev.com/32661/shuffle-array-java)
        Random cardOrder = new Random();

        String[] array = new String[0];
        for (int k = 0; k < cardPack.length; k++) {
            int randomCardToSwap = cardOrder.nextInt(cardPack.length);
            String temp = cardPack[randomCardToSwap];
            cardPack[randomCardToSwap] = cardPack[k];
            cardPack[k] = temp;
        }
        for (String iCard : cardPack) {
            System.out.println(iCard);
        }
        System.out.println("The first card is " + cardPack[0]);


    }

    static void Assignment5v1() {
        String sent = "Madam, in Eden, I’m Adam.";
        sent = sent.replaceAll("[^a-zA-Z]", "").toLowerCase();

        System.out.println(sent);

        boolean isPalindrome = true;
        int i = 0;
        int k = sent.length() - 1;

        while (i < k) {
            if (sent.charAt(i) != sent.charAt(k)) {
                isPalindrome = false;

                System.out.println("the sentence is not a palindrome");
                break;
            } else {
                i++;
                k--;
            }

        }
        if (isPalindrome) {
            System.out.println("The sentence is a palindrome");
        }
    }

    static boolean checkPalindrome(String sent)
    {
        sent = sent.replaceAll("[^a-zA-Z]", "").toLowerCase();

        boolean isPalindrome = true;
        int i = 0;
        int k = sent.length() - 1;

        while (i < k) {
            if (sent.charAt(i) != sent.charAt(k)) {
                isPalindrome = false;

                break;
            } else {
                i++;
                k--;
            }

        }
        return isPalindrome;
    }

    static void Assignment5v2() {
        String sentencesToCheck[] = {"Mom", "Was it a car or a cat I saw?", "Java is great!", "Madam, in Eden, I’m Adam.", "Yo, banana boy!"};
        for (String sent : sentencesToCheck) {
            System.out.println(sent);
            if (checkPalindrome(sent)) {
                System.out.println("This sentence is a palindrome");
            } else {
                System.out.println("This sentence is not a palindrome");
            }
        }
    }
    public static void main(String[] args) {
        Assignment1();
        //Assignment2();
        //Assignment3();
        //Assignment4();
        //Assignment5v1();
        //Assignment5v2();

    }
}








