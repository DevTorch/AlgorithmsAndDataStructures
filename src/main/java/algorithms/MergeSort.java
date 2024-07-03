package algorithms;

import algorithms.utils.IntArrays;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        var ints = IntArrays.getRandomArray(20, 0, 100);
        System.out.println("Original array: " + Arrays.toString(ints));

        var sorted = mergeSort(ints);
        System.out.println("Sorted array: " + Arrays.toString(sorted));

        System.out.printf("Size of original array: %d%n", ints.length);
        System.out.printf("Size of sorted array: %d%n", sorted.length);

    }

    /**
     * Sorts an array of integers using the merge sort algorithm.
     *
     * @param  array  the array to be sorted
     * @return        the sorted array
     * @link {@link MergeSortTest#positiveTest() Test for MergeSort}
     */
    public static int[] mergeSort(int[] array) {

        if (array.length < 2) {
            return array;
        }

        int middle = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, middle));
        int[] right = mergeSort(Arrays.copyOfRange(array, middle, array.length));

        return merge(array, left, right);
    }
    /**
     * Merges the left and right subarrays into a single sorted array.
     *
     * @param  array  the original array to merge
     * @param  left   the left subarray
     * @param  right  the right subarray
     * @return        the merged sorted array
     */
    private static int[] merge(int[] array, int[] left, int[] right) {

        int[] result = new int[array.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        return result;
    }
}