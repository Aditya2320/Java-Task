package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Suffle{

    public static void main(String[] args) {
        // Task 1: Create an array, shuffle it
        List<Integer> originalArray = new ArrayList<>();
        originalArray.add(1);
        originalArray.add(2);
        originalArray.add(3);
        originalArray.add(4);
        originalArray.add(5);
        originalArray.add(6);
        originalArray.add(7);

        Collections.shuffle(originalArray);
        System.out.println("Shuffled Array: " + originalArray);

        // Task 2: Convert a Roman numeral to an integer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Roman Numeral: ");
        String romanNumeral = scanner.nextLine();
        int integer = romanToInteger(romanNumeral);
        System.out.println("Equivalent Integer: " + integer);

        // Task 3: Check if a sentence is a pangram
        System.out.print("Enter a sentence: ");
        String inputSentence = scanner.nextLine();
        boolean isPangram = isPangram(inputSentence);
        if (isPangram) {
            System.out.println("The sentence is a pangram.");
        } else {
            System.out.println("The sentence is not a pangram.");
        }

        scanner.close();
    }

    public static int romanToInteger(String s) {
        int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] symbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        int result = 0;
        int i = symbols.length - 1;

        while (!s.isEmpty() && i >= 0) {
            if (s.startsWith(symbols[i])) {
                result += values[i];
                s = s.substring(symbols[i].length());
            } else {
                i--;
            }
        }

        return result;
    }

    public static boolean isPangram(String sentence) {
        sentence = sentence.toLowerCase();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            if (sentence.indexOf(letter) == -1) {
                return false;
            }
        }
        return true;
    }
}