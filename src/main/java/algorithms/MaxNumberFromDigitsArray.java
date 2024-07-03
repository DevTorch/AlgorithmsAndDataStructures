package algorithms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

    /**
     * ЗАДАЧА: Из цифр в заданном массиве собрать максимальное число, то есть отсортировать
     * в обратном порядке от большего к меньшему
     */

public class MaxNumberFromDigitsArray {

    static StringBuilder string = new StringBuilder("");

    public static void main(String[] args) {

        int[] digits = {3, 1, 7, 9, 9, 5};
        System.out.printf("Сортировка массива средствами JAVA | O(n): %s%n", getSort(digits));
        System.out.printf("Сортировка WHILE | O(n^2): %s%n", getMax(digits));
        System.out.printf("Сортировка STREAM: %s%n", getStream(digits));
    }

    public static String getSort(int[] digits) {
        Arrays.sort(digits);
        return getReverse(digits);
    }

    private static String getReverse(int[] digits) {
        StringBuilder sb = new StringBuilder(digits.length);
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.reverse().toString();
    }

    public static String getMax(int[] digits) {

        boolean repeat = true;
        while (repeat) {
            repeat = false;
            for (int i = 1; i < digits.length; i++) {
                if (digits[i] < digits[i - 1]) {
                    int swap = digits[i];
                    digits[i] = digits[i - 1];
                    digits[i - 1] = swap;
                    repeat = true;
                }
            }
        }
        return getReverse(digits);
    }

    public static String getStream(int[] digits) {
        return Arrays.stream(digits)
                .mapToObj(String::valueOf)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
    }

}
