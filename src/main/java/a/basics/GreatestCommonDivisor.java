package a.basics;

import java.util.Scanner;

/**
 * Greatest Common Divisor (GCD) and Highest Common Factor (HCF) – это одно и то же: наибольший общий делитель (GCD)
 * и наибольший общий множитель (HCF) относятся к одному и тому же математическому понятию, которое представляет собой
 * наибольшее число, делящее два или более чисел без остатка. Это взаимозаменяемые термины.
 *
 **/

public class GreatestCommonDivisor {

    private static final String TIME = "; Time: ";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Input a: ");
        int a = input.nextInt();

        System.out.print("Input b: ");
        int b = input.nextInt();

        var startOne = System.nanoTime();
        System.out.println("Result bruteforce: " + getGcd(a, b) + TIME + (System.nanoTime() - startOne));

        var startTwo = System.nanoTime();
        System.out.println("Result Euclidean: " + getEuclideanGcd(a, b) + TIME + (System.nanoTime() - startTwo));

        var startThree = System.nanoTime();
        System.out.println("Result Lame: " + getLameGcd(a, b) + TIME + (System.nanoTime() - startThree));
    }

    // BRUTEFORCE O(min(a, b))
    private static int getGcd(int a, int b) {
        int min = Math.min(a, b);
        for (int i = min; i > 0; i--) {
            // Проверяем, делятся ли a и b на i без остатка
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }

    // Euclidean O((max(a, b)))
    private static int getEuclideanGcd(int a, int b) {

        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    // Gabriele Lame O(log(min(a, b)))
    private static int getLameGcd(int a, int b) {

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return Math.max(a, b);
    }
}
