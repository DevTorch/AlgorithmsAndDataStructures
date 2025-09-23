package a.basics.recursion;

public class FibonacciSequence {
    public static void main(String[] args) {
        System.out.println(fibonacciSequence(10));
        System.out.println(fibonacciSequenceOptimized(1000));
    }
    private static long fibonacciSequence(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciSequence(n - 1) + fibonacciSequence(n - 2);
    }

    private static long fibonacciSequenceOptimized(int n) {
        var storage = new long[n + 1];
        storage[0] = 0;
        storage[1] = 1;
        for (int i = 2; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2];
        }
        return storage[n];
    }
}
