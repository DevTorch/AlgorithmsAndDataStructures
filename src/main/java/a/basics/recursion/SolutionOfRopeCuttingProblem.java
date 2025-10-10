package a.basics.recursion;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Есть веревка длиной n, необходимо найти максимальной количество кусков, на которое можно разделить
 * веревку, получив массив заданных длин кусков на входе. То есть, разделить веревку n = 15 на максимальное
 * количество кусков длиной {5, 8, 7}.
 *
 */
public class SolutionOfRopeCuttingProblem {

    public static void main(String[] args) {
        int[] ar = new int[]{2, 5, 8, 7, 6, 10, 1};
        int n = 16;
        System.out.println(solutionOfRopeCuttingProblem(n, ar));
    }

    private static int solutionOfRopeCuttingProblem(int n, int[] ar) {
        if (n == 0) {
            return 0;
        } else if (n < 0) {
            return -1;
        }
        int[] temp = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            temp[i] = solutionOfRopeCuttingProblem(n - ar[i], ar);
        }

        OptionalInt max = Arrays.stream(temp).max();

        int pieces = max.isPresent() ? max.getAsInt() : 0;

        if (pieces == -1) {
            return 0;
        }
        return pieces + 1;
    }
}
