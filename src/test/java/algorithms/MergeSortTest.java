package algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    public void positiveTest() {
        int[] actual = { 5, 1, 6, 2, 3, 4 };
        int[] expected = { 1, 2, 3, 4, 5, 6 };

        int[] sorted = MergeSort.mergeSort(actual);

        System.out.printf("Actual: %s%n", Arrays.toString(actual));
        System.out.printf("Expected: %s%n", Arrays.toString(expected));
        System.out.printf("Sorted: %s%n", Arrays.toString(sorted));
        assertArrayEquals(expected, sorted);
    }
}