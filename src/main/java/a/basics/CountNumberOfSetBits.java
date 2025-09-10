package a.basics;

/** Вспоминаем, что при $(n-1)$ самый правый установленный бит становится нулем,
 * а все биты правее – единицами. Тогда при n AND (n-1) обнулятся различающиеся биты.
 * Соответственно, пока число не станет равным нулю, повторяем цикл, возвращая счетчик циклов.
 *  */
public class CountNumberOfSetBits {

    private static final String BINARY_N = "Binary N: ";
    private static final String COUNT = "Count: ";

    public static void main(String[] args) {

        System.out.println(BINARY_N + String.format("%8s", Integer.toBinaryString(42)).replace(' ', '0'));
        System.out.println(COUNT + setBitsCounter(42) + "\n");

        System.out.println(BINARY_N + String.format("%8s", Integer.toBinaryString(-42)).replace(' ', '0'));
        System.out.println(COUNT + setBitsCounter(-42) + "\n");

        System.out.println(BINARY_N + String.format("%8s", Integer.toBinaryString(255)).replace(' ', '0'));
        System.out.println(COUNT + setBitsCounter(255) + "\n");
    }

    // O(n)
    private static int setBitsCounter(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
