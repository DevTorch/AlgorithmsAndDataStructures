package a.basics.recursion;

public class SumArrayElements {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sumArrayElements(arr, 0));
    }

    private static long sumArrayElements(int[] arr, int i) {
        if (arr.length == i) {
            return 0;
        }
        return arr[i] + sumArrayElements(arr, i + 1);
    }
}
