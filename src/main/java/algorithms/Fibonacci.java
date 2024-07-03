package algorithms;

import java.util.Arrays;

public class Fibonacci {

    /**
     * МЕМОИЗАЦИЯ: –
     * сохранение результатов выполнения функций для предотвращения повторных вычислений
     */

    public static void main(String[] args) {

        int x = 10; //Вычисление по наивному алгоритму с мемоизацией
        long[] memoize = new long[x + 1];
        Arrays.fill(memoize, -1); //заполняем массив отрицательными значениями

        long time = System.currentTimeMillis();
        System.out.println("Naive Fibonacci result: " + fibonacciNaive(10));
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - time));
        System.out.println("-----------------------");
        time = System.currentTimeMillis();
        System.out.println("Effective Fibonacci result: " + fibonacciEffective(10));
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - time));
        System.out.println("Memoized naive Fibonacci result: " + fibNaiveMemo(x, memoize));
    }
    /**
     * Метод подсчета основан на рекурсии. Разрастается по типу дерева, начиная с F(n).
     *  Подсчет одних и тех же элементов в разных ветка дерева дублируется много раз.
     **/
    private static long fibNaiveMemo (int x, long[] memoize){
        if (memoize[x] != -1) return memoize[x]; //Проверяем сохранность промежуточных вычислений
        if (x <= 1 ) return x;

        long result = fibNaiveMemo(x - 2, memoize) + fibNaiveMemo(x - 1, memoize);
        memoize[x] = result;
        return result;
    }

    /**
     * Calculates the nth Fibonacci number using a naive recursive approach.
     *
     * @param  n  the index of the Fibonacci number to calculate
     * @return    the nth Fibonacci number
     */
    private static long fibonacciNaive(int n){
        if (n <= 1)
            return n;
        return fibonacciNaive(n - 2) + fibonacciNaive(n - 1);
    }
    /**
     * Calculates the nth Fibonacci number using an effective algorithm that
     * utilizes a bottom-up approach with memoization. The algorithm initializes
     * an array of size n+1 with the first two Fibonacci numbers (0 and 1) and then
     * iteratively calculates the remaining Fibonacci numbers by summing the two
     * previous ones. The time complexity of this algorithm is O(n) and it avoids
     * redundant calculations by storing the intermediate results in the array.
     *
     * @param  n  the index of the Fibonacci number to calculate
     * @return    the nth Fibonacci number
     */
    private static long fibonacciEffective(int n){
        long[] array = new long[n + 1];
        array[0] = 0;
        array[1] = 1;

        for (int i = 2; i <= n; i++){
            array[i] = array[i-2] + array[i - 1];
        }
        return array[n];
    }
}
