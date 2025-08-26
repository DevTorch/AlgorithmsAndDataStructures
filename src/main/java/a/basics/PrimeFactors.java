package a.basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int n = sc.nextInt();

        System.out.println("Prime factors: " + primeFactors(n));
    }

    // O(log n)
    private static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        int i = 2;
        while (i <= Math.sqrt(n)) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
            i++;
        }
        // Если вводимое число является простым, то оно не попадет в выборку выше
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }
}
