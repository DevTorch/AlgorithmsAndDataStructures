package a.basics.recursion;

/**
 * Счастливые числа (lucky numbers) — решето Эратосфена
 * Это числа, которые остаются после процесса вычеркивания элементов из списка натуральных чисел:
 * Начинаем с натуральных чисел: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, ....
 * Вычеркиваем каждое второе число: 1, 3, 5, 7, 9, 11, 13, 15, ....
 * Следующее число в списке — 3. Вычеркиваем каждое третье число: 1, 3, 7, 9, 13, 15, 21, 25, ....
 * Процедура постоянно повторяется; Любое число, которое не удаляется в результате описанного выше процесса, называется "счастливым".
 * Таким образом, набор счастливых чисел равен: 1, 3, 7, 13 ....
 * Examples:
 * Input: n = 7
 * Output: 7 is a lucky number
 * Input: n = 9
 * Output: 9 is not a lucky number
 */

public class LuckyNumber {

    private static int counter = 2;

    public static void main(String[] args) {

        System.out.println(isLuckyNumber(13));
    }
    // Число счастливое, если его позиция меньше счетчика, pos < i – lucky, pos % i == 0 – not lucky
    // Позицию рассчитываем, начиная с i == 2: n - (n / i), потом i == 3, i == 4 и далее, до базовых условий
    private static boolean isLuckyNumber(int n) {

        if (counter > n) {
            return true;
        }

        if (n % counter == 0) {
            return  false;
        }

        int nextPosition = n - (n / counter);
        counter++;

        return isLuckyNumber(nextPosition);
    }
}
