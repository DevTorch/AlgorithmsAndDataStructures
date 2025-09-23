package a.basics;

/**
 * <p>Проверка состояния бита:
 * <p>int i = 5; // 0 0 1 0 0 0 0 0 – проверяем 5-й бит
 * <p>int mask = 1 << i;
 * <p>((n & mask) == 0) ? "OFF" : "ON");
 */
public class ReversingBitsOfAnInteger {

    public static void main(String[] args) {

        System.out.println("Result: " + reversingBitsOfAnInteger(125));
    }

    //O(log n)
    private static int reversingBitsOfAnInteger(int n) {

        // Int 32 bit. Принимаем, что старший бит (слева) имеет индекс 31, а младший бит (справа) имеет индекс 0.

        int left = 31;
        int right = 0;
        int reversed = 0;

        int count = 1;

        System.out.println("1. Исходное число: " + String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));

        while (left > right) {

            if ((n & (1 << left)) != 0) {
                reversed = reversed | (1 << right);
            }

            if ((n & (1 << right)) != 0) {
                reversed = reversed | (1 << left);
            }
            count++;
            System.out.println(count + ". Rversed: " + String.format("%32s", Integer.toBinaryString(reversed)).replace(' ', '0'));
            left--;
            right++;
        }

        return reversed;
    }
}
