package a.basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllDivisorsOfAGivenNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int a = sc.nextInt();

        System.out.println("Brute force: " + bruteForce(a));
        System.out.println("Optimized: " + optimized(a));
        System.out.println("Optimized and sorted: " + optimizedAndSorted(a));
    }

    // O(n)
    private static List<Integer> bruteForce(int a) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
            }
        }
        return  divisors;
    }

    // O(√n)
    private static List<Integer> optimized(int a) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                divisors.add(i);
                if (i != a / i) {
                    divisors.add(a / i);
                }
            }
        }
        return divisors.stream().sorted().toList();
    }


    // O(2√n) = O(√n)
    private static List<Integer> optimizedAndSorted(int a) {
        List<Integer> divisors = new LinkedList<>();
        int i;
        for (i = 1; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                divisors.add(i);
            }
        }

        // Перебираем первые делители числа «a» в обратном порядке и добавляем n / a в список
        for ( ; i >= 1; i--) {
            if (a % i == 0 && i != a / i) {
                divisors.add(a / i);
            }
        }
        return divisors;
    }
}
