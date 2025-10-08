package a.basics.recursion;

import java.util.HashMap;
import java.util.Map;

public class LetterCombinationOfAPhoneNumber {
    private static Map<Integer, String> map = new HashMap<>() {
        {
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
            put(0, "");
        }
    };

    public static void main(String[] args) {
        letterCombinationOfAPhoneNumber("4422", "");
    }

    private static void letterCombinationOfAPhoneNumber(String number, String answer) {
        if (number.isEmpty()) {
            System.out.println(answer);
            return;
        }

        // Ноль char в десятичной системе равно 48, 1 = 48, 2 = 50 ... =>
        // 48 - 48 = 0,
        // 49 - 48 = 1,
        // 50 - 48 = 2 ...
        int digit = number.charAt(0) - '0';
        String letters = getLetters(digit);

        for (int i = 0; i < letters.length(); i++) {
            letterCombinationOfAPhoneNumber(number.substring(1), answer + letters.charAt(i));
        }
    }

    private static String getLetters(int digit) {
        return map.get(digit);
    }
}
