package a.basics;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AllDivisorsOfAGivenNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        int a = sc.nextInt();

        System.out.print("Brute force: " + bruteForce(a));
    }

    // O(n)
    private static List<Integer> bruteForce(int a) {
        List<Integer> divisors = new LinkedList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                divisors.add(i);
            }
        }
        return  divisors;
    }
}
