package a.basics;

public class NumberIsPowOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowOfTwo(16));
    }

    // O(1)
    private static boolean isPowOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}
