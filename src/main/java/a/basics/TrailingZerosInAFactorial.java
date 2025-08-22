package a.basics;

import java.util.Scanner;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

/**
 * Фишка: подсчет пятерок в факториале
 * 5! = 1 * 2 * 3 * 4 * 5 = 120 (одна пятерка – один ноль в конце)
 * 10! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 = 3628800 (10 = 5 * 2, две пятерки – два нуля в конце)
 * 15! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 = 1307674368000 (15 = 5 * 3, три пятерки – три нуля в конце)
 * 20! = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19 * 20 = 2432902008176640000 (20 = 5 * 4, четыре пятерки – четыре нуля в конце)
 * ...
 * 25! = 15511210043330985984000000 (25 = 5 * 5, пять пятерок – пять нулей в конце + 1)
 * ...
 * n! -> n/5 + n/25 + n/125 + n/625 + ...
 * n! -> n/pow(5, k), k = 1, 2, 3, 4, 5, ...
 * */

public class TrailingZerosInAFactorial {

    public static void main(String[] args) {

        Logger logger = Logger.getLogger(TrailingZerosInAFactorial.class.getName());

        logger.log(INFO, () -> "Input: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        logger.log(INFO, () -> n + "! -> " + getTrailingZerosCount(n) + " zeros");
    }

    static int getTrailingZerosCount(int n) {
        int res = 0;
        int powOfFive = 5;
        while (n >= powOfFive) {
            res = res + (n / powOfFive);
            powOfFive = powOfFive * 5;
        }
        return res;
    }
}
