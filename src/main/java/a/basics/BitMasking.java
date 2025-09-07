package a.basics;

public class BitMasking {

    /** BIT MASKING
     * Когда необходимо включить или выключить определенный бит, создаем маску от единицы:
     * 0 0 0 0 0 0 0 1 и сдвигаем влево единицу на i позиций – (1 << i)
     * */

    public static void main(String[] args) {

        int n = 36; // 0 0 1 0 0 1 0 0
        int i = 3; // 0 0 0 0 1 0 0 0 – включаем 3-й бит
        int mask = 1 << i;

        // Включение бита
        System.out.println(n | mask);
        System.out.println(String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(String.format("%8s", Integer.toBinaryString(n | (1 << i))).replace(' ', '0'));

        System.out.println();

        // Выключение бита
        i = 5; // 0 0 1 0 0 0 0 0 – выключаем 5-й бит
        mask = ~(1 << i); // инвертируем 5-й бит
        System.out.println(n & mask);
        System.out.println(String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(String.format("%8s", Integer.toBinaryString(n & mask)).replace(' ', '0'));

        System.out.println();

        // Переключение бита
        i = 6; // 0 0 1 0 0 0 0 0 – переключаем 6-й бит
        mask = 1 << i;
        System.out.println(n ^ mask);
        System.out.println(String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(String.format("%8s", Integer.toBinaryString(n ^ mask)).replace(' ', '0'));

        System.out.println();

        // Проверка состояния бита
        i = 5; // 0 0 1 0 0 0 0 0 – проверяем 5-й бит
        mask = 1 << i;

        System.out.println(String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println(((n & mask) == 0) ? "OFF" : "ON");

    }
}
