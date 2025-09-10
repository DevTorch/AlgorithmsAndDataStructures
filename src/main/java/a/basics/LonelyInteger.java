package a.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>- дан массив из n целочисленных значений
 * <p>- все числа парные, кроме одного
 * <p>- 1 ≤ n < 100
 * <p>- гарантировано, что n – нечетное число
 * <p>- 0 ≤ a[i] ≤ 100, где 0 ≤ i < n
 *
 */

public class LonelyInteger {

    public static void main(String[] args) {
        System.out.println(lonelyInteger(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(lonelyIntegerEffective(new int[]{1, 2, 3, 4, 3, 2, 1}));
        System.out.println(lonelyIntegerEffectiveXor(new int[]{1, 2, 3, 4, 3, 2, 1}));
    }

    // O(n + n log n) = O(n log n)
    private static int lonelyInteger(int[] ints) {

        Arrays.sort(ints); // O(n log n)

        for (int i = 0; i < ints.length - 2; i = i + 2) {
            if (ints[i] != ints[i + 1]) {
                return ints[i];
            }
        }
        return ints[ints.length - 1]; // если обошли все значения и все они парные, непарный стоит последним в массиве
    }

    // O(n), ну увеличиваем сложность по памяти
    private static int lonelyIntegerEffective(int[] ints) {

        Set<Integer> integers = new HashSet<>();

        for (int i : ints) {
            if (integers.contains(i)) {
                integers.remove(i);
            } else {
                integers.add(i);
            }
        }
        for (int i : integers) {
            return i;
        }
        return -1; // Этот return никогда не будет вызван (при условии достоверности постановки задачи)
    }
    /**
     * <p>1. XOR двух одинаковых чисел дает 0
     * <p>2. XOR числа и нуля дает само число
     * <p>3. Операция XOR коммутативна, т.е. 5^5^4 = 5^4^5
     * */
    private static int lonelyIntegerEffectiveXor(int[] ints) {
        int result = 0;

        for (int i : ints) {
            result = result ^ i;
        }
        return result;
    }
}
