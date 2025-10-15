package a.basics.recursion;

/**
 * Дан массив неотрицательных чисел и целое число S.
 * Нужно определить, можно ли из этих чисел составить сумму S.
 */
public class SolutionOfSubsetSumProblem {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int sum = 10;
        System.out.println(subsetSumProblem(arr, sum, 0));

        int[] arr2 = {10, 20, 15, 5};
        int sum2 = 25;
        System.out.println(subsetSumProblem(arr2, sum2, 0));

    }

    // Возвращаем КОЛИЧЕСТВО комбинаций
    private static int subsetSumProblem(int[] arr, int sum, int count) {
        if (sum == 0) {
            return 1;
        }
        if (count == arr.length || sum < 0) {
            return 0;
        }
        return subsetSumProblem(arr, sum - arr[count], count + 1) + subsetSumProblem(arr, sum, count + 1);
    }
}
