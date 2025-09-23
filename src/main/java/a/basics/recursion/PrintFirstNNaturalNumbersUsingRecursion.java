package a.basics.recursion;

public class PrintFirstNNaturalNumbersUsingRecursion {
    public static void main(String[] args) {
        printFirstNNaturalNumbersUsingRecursion(5);
    }
    private static void printFirstNNaturalNumbersUsingRecursion(int n) {
        if (n == 0) {
            return;
        }
        printFirstNNaturalNumbersUsingRecursion(n - 1);
        System.out.println(n);
    }
}
