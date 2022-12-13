package miscellaneous;

import java.util.Map;
import java.util.Scanner;

/*
 * Problem Statement <a href="https://leetcode.com/problems/roman-to-integer/">here</href>
 * Time Complexity - O(n) , n being number of roman characters
 * Space Complexity - O(1)
 * */
public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roman;
        do {
            System.out.println("Enter any roman roman OR to press 0 to exit");
            roman = sc.nextLine();
            System.out.println("Converted integer: " + romanToInt(roman));
        }
        while (!roman.equals("0"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanToIntMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000
        );
        char[] romanArray = s.toCharArray();
        int integer = 0;
        int prevInt = Integer.MAX_VALUE;
        int currentInt;
        for (char c : romanArray) {
            currentInt = romanToIntMap.get(c);
            if (prevInt < currentInt) integer += (currentInt - 2 * prevInt);
            else integer += currentInt;
            prevInt = currentInt;
        }

        return integer;
    }
}
