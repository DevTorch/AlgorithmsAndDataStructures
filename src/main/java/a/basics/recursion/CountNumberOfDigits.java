package a.basics.recursion;

public class CountNumberOfDigits {
    public static void main(String[] args) {

        System.out.println(countNumberOfDigits(123045));
    }

    private static int countNumberOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return 1 + countNumberOfDigits(n / 10);
    }
}
