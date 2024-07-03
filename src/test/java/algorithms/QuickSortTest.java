package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void testQuickSort() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };

        var sorted = QuickSort.quickSort(actual, 0, actual.length - 1);

        System.out.printf("Actual: %s%n", Arrays.toString(actual));
        System.out.printf("Expected: %s%n", Arrays.toString(expected));
        System.out.printf("Sorted: %s%n", Arrays.toString(sorted));
        assertArrayEquals(expected, sorted);
    }

}