package algorithms.tasks;

public class SlidingWindow {
    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 21, -1, 5, 5, 3, 6, 7};
        int k = 4;
        int subarraySum = maxSubarraySum(array, k);
        System.out.printf("Max Subarray Sum: %d\n", subarraySum);
    }

    /**
     * Максимальная сумма подмассива длиной k в массиве array
     */
    private static int maxSubarraySum(int[] array, int k) {

        if (k > array.length) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }
        int windowSum = maxSum;
        int index = 0;
        while (k < array.length) {
            windowSum = windowSum + array[k] - array[index];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
            index++;
            k++;
        }
        return maxSum;
    }
}
