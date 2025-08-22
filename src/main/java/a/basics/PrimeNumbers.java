package a.basics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/** Простое число – делится только на себя и на единицу. **Единица** не является составным числом и, соответственно,
 * **не является простым*** */
public class PrimeNumbers {

    private static final String PRIME = " prime? ";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = sc.nextInt();

        System.out.println("Is " + a + PRIME + isPrime(a));
        System.out.println("Is " + a + PRIME + isPrimeOptimized(a));
        System.out.println("Is " + a + PRIME + isPrimeEratosthenes(a));
        isPrimeSieveOfEratosthenes(a);
    }

    // Brute force: Идем перебором от 2 до n/2. O(n)
    private static boolean isPrime(long n) {
        if (n <= 1) return false;
        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Оптимизированный алгоритм. O(√n)
    private static boolean isPrimeOptimized(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        // Вариант: i * i <= n; – можем оттолкнуться от i^2 <= n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Решето Эратосфена – O(n log(log n))
    private  static boolean isPrimeEratosthenes(long n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (long i = 5; i * i <= n; i += 6) { // 5 и 7, 11 и 13, 17 и 19, ...
            if (n % i == 0 || n % (i + 4) == 0) { // i + 2 (?)
                return false;
            }
        }
        return true;
    }

    // Решето Эратосфена для вывода простых чисел от 0 (2) до n. O(√n log(log n)
    private static void isPrimeSieveOfEratosthenes(int n) {

        boolean[] primes = new boolean[n + 1];
        Set<Integer> primesSet = new LinkedHashSet<>();

        // Проходим до √n, так как все числа > n^2 лежат за пределами массива. Например: при n = 100 нет смысла заходить дальше 10
        for (int i = 2; i * i <= n; i++) {
            if (!primes[i]) {
                /* Первое кратное неотмеченному числу – его квадрат, до этого числа могут быть отмечены предшествующими числами,
                 * например: 3 -> 9, 5 -> 25, 7 -> 49, до 49 все числа уже будут отмечены предыдущими проверками
                 */
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (!primes[i]) {
                primesSet.add(i);
                System.out.print(i + "; ");
            }
        }
        System.out.println("\n" + primesSet);
    }
}
