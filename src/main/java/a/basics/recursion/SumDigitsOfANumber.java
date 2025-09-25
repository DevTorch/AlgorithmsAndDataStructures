package a.basics.recursion;

public class SumDigitsOfANumber {
    public static void main(String[] args) {

        System.out.println(sumDigitsOfANumber(12345));
    }

    private static int sumDigitsOfANumber(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumDigitsOfANumber(n / 10);
    }
}
