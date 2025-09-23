package a.basics.recursion;

public class FactorialOfANumberUsingRecursion {
    public static void main(String[] args) {

        System.out.println(factorialOfANumberUsingRecursion(5));
    }

    private static int factorialOfANumberUsingRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialOfANumberUsingRecursion(n - 1);
    }
}
