package a.basics;

import java.util.Scanner;

/**
 * Наименьшее общее кратное (HOK) двух целых чисел m и n есть наименьшее натуральное число которое делится на m и n
 * без остатка, то есть кратно им обоим
 * */
public class LeastCommonMultiple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Bruteforce LCM of " + a + " and " + b + " is: " + findLcm(a, b));
        System.out.println("Euclidean LCM of " + a + " and " + b + " is: " + getEuclideanGcdAndLcm(a, b));
        System.out.println("Lame LCM of " + a + " and " + b + " is: " + getLameGcdAndLcm(a, b));
    }

    /** Начиная от максимального из двух заданных чисел перебором в *бесконечном* цикле находим НОК O(n) */
    private static int findLcm(int a, int b) {
        int res = Math.max(a, b);
        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }

    /** Euclidean: LCM(a, b) * GCD(a, b) = a * b; => LCM(a, b) = (a * b) / GCD(a, b); */
    private static int getEuclideanGcdAndLcm(int a, int b) {
        int res = a * b;
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return res / a;
    }

    /** Euclidean + Lame: LCM(a, b) * GCD(a, b) = a * b; => LCM(a, b) = (a * b) / GCD(a, b); */
    private static int getLameGcdAndLcm(int a, int b) {
        int res = a * b;
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return res / Math.max(a, b);
    }
}
