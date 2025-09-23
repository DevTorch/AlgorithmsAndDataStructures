package a.basics;

import java.util.HashSet;
import java.util.Set;

public class MaximumAndValueOfArrayElements {
    public static void main(String[] args) {
        int[] arr = {16, 9, 6, 13};
        System.out.println(maximumAndValueOfArrayElements(arr));
    }

    private static int checkBits(int[] arr, int mask) {
        int count = 0;
        for (int j : arr) {
            if ((j & mask) == mask) {
                count++;
            }
        }
        return count;
    }

    private static int maximumAndValueOfArrayElements(int[] arr) {
        int mask;
        int result = 0;
        Set<Integer> array = new HashSet<>();

        for (int i = 31; i >= 0; i--) {
            mask = (1 << i) | result;
            int count = checkBits(arr, mask);
//            if (count > 0) {
//                array.add(arr[i]);
//            }
            if (count >= 2) {
                result = result | mask;
            }
        }
        System.out.println(array);
        return result;
    }
}
