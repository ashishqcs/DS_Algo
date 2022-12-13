package miscellaneous;

import java.util.*;

public class NumberToWords {
    static Map<Long, String> onesMap = Map.of(
            0L, "",
            1L, "one",
            2L, "two",
            3L, "three",
            4L, "four",
            5L, "five",
            6L, "six",
            7L, "seven",
            8L, "eight",
            9L, "nine"
    );
    static Map<Long, String> tensMap = Map.of(
            0L, "",
            1L, "ten",
            2L, "twenty",
            3L, "thirty",
            4L, "forty",
            5L, "fifty",
            6L, "sixty",
            7L, "seventy",
            8L, "eighty",
            9L, "ninety"
    );
    static Map<Long, String> oneTensMap = Map.of(
            11L, "eleven",
            12L, "twelve",
            13L, "thirteen",
            14L, "fourteen",
            15L, "fifteen",
            16L, "sixteen",
            17L, "seventeen",
            18L, "eighteen",
            19L, "nineteen"
    );
    static Map<Long, String> valueMap = Map.of(
            1L, "thousand",
            2L, "million",
            3L, "billion",
            4L, "trillion"
    );

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number;
        do {
            System.out.println("Enter any number OR to press 0 to exit");
            number = sc.nextLong();

            List<String> textList = convertToWord(number);

            Collections.reverse(textList);
            String numberText = String.join(" ", textList);
            System.out.println(numberText);
        }
        while (number != 0);
    }

    private static List<String> convertToWord(long number) {
        List<String> textList = new ArrayList<>();
        if (number == 0) {
            System.out.println("zero");
            return textList;
        }
        long value = 0;
        while (number > 0) {
            long hundredsNumber = number % 1000;
            number = number / 1000;
            if (value > 0 && hundredsNumber > 0) textList.add(valueMap.get(value));
            convertToText(hundredsNumber, textList);
            value++;
        }
        return textList;
    }

    private static void convertToText(long number, List<String> textList) {
        long tens = number % 100;
        long hundreds = number / 100;
        extractTens(tens, textList);
        extractHundreds(textList, hundreds);
    }

    private static void extractHundreds(List<String> textList, long hundreds) {
        if (hundreds > 0) {
            textList.add("hundred");
            textList.add(onesMap.get(hundreds).trim());
        }
    }

    private static void extractTens(long number, List<String> textList) {
        String str = oneTensMap.get(number);
        if (str == null) {
            long ones = number % 10;
            long tens = number / 10;
            if (ones > 0) textList.add(onesMap.get(ones));
            if (tens > 0) textList.add(tensMap.get(tens));
        } else {
            textList.add(str);
        }

    }
}
