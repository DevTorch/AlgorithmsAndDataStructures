package a.basics;

/**
 * <p>Оператор <b>AND (&)</b> дает true, если <u>оба значения</u> <b>true</b></p>
 *
 * <p>Десятичное число: 10
 * <br>Двоичный формат: n = 0 0 0 0 1 0 1 0
 * <br>Строим маску от единицы: m = 0 0 0 0 0 0 0 1
 * <br>Сравниваем первый бит (n & m) и сдвигаем бит в маске влево <<
 *
 * <p>Таким образом, при сравнении битов ***находим первое число*** ≠0. Получается, что позиция – это (степень двойки + 1)
 * в числе маски, позицию бита считаем по количеству циклов в одном случае, и высчитываем степень двойки + 1 – во втором
 */

public class FindPositionOfRightMostSetBit {

    private static final String POSITION_OF_RIGHTMOST_SET_BIT = "Position of right most set bit: ";

    public static void main(String[] args) {

        int n = 10; // 0 0 0 0 1 0 1 0
        int f = 128; // 1 0 0 0 0 0 0 0
        int x = 40; // 0 0 1 0 1 0 0 0

        findPositionOfRightMostSetBit(n);
        findPositionOfRightMostSetBit(f);
        findPositionOfRightMostSetBit(0);
        findPositionOfRightMostSetBit(x);

        findPositionOfRightMostSetBitOptimized(x);
    }

    // O(log n)
    private static void findPositionOfRightMostSetBit(int n) {

        System.out.println("Binary: " + String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));

        int mask = 1;
        int position = 1;

        if (n == 0) {
            position = -1;
            System.out.println(POSITION_OF_RIGHTMOST_SET_BIT + position + "\n");
            return;
        }

        while ((n & mask) == 0) {
            mask = mask << 1;
            position++;
        }
        System.out.println(POSITION_OF_RIGHTMOST_SET_BIT + position + "\n");
    }

    /**
     * <p>Формула: log(n) = log10(n) / log10(2);
     * <p>O(1)
     */
    private static void findPositionOfRightMostSetBitOptimized(int n) {

        System.out.println("Binary N: " + String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));

        int position;

        if (n == 0) {
            position = -1;
            System.out.println(POSITION_OF_RIGHTMOST_SET_BIT + position + "\n");
            return;
        }

        int mask = n & (n - 1);
        System.out.println("Mask: " + String.format("%8s", Integer.toBinaryString(mask)).replace(' ', '0'));

        n = n ^ mask;
        System.out.println("Binary N new: " + String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        System.out.println("Decimal (pow of 2): " + n);

        position = (int)(Math.log10(n) / Math.log10(2) + 1);
        System.out.println(POSITION_OF_RIGHTMOST_SET_BIT + position + "\n");

    }
}