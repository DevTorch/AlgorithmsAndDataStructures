package a.basics.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Input : ab
 * <p>Output : "", "a", "b", "ab"
 *
 * <p>Input : abc
 * <p>Output : "", "a", "b", "c", "ab", "ac", "bc", "abc"
 * */
public class SubsequenceOfAGivenString {

    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        subsequenceOfAGivenString("abc", "");
        System.out.println(result);
    }

    // O(2^n)
    private static void subsequenceOfAGivenString(String s, String answer) {
        if (s.isEmpty()) {
//            System.out.println(answer);
            result.add(answer);
            return;
        }
        // Укорачиваем строку на первый символ (abc -> bc), первый символ передаем в answer (a)
        subsequenceOfAGivenString(s.substring(1), answer + s.charAt(0));

        // Укорачиваем строку на первый символ (abc -> bc), answer оставляем без изменений
        subsequenceOfAGivenString(s.substring(1), answer);
    }
}
