package a.basics;

public class NthPalindromicBinaryRepresentation {

    public static void main(String[] args) {

        System.out.printf("N-я палиндромная строка: %s%n", Integer.toBinaryString(nthPalindromicBinaryRepresentation(21)));
        System.out.printf("N-я палиндромная строка: %s%n", Integer.toBinaryString(nthPalindromicBinaryRepresentation(20)));
        System.out.printf("N-я палиндромная строка: %s%n", Integer.toBinaryString(nthPalindromicBinaryRepresentation(12)));
    }

    private static int nthPalindromicBinaryRepresentation(int n) {

        if (n == 0) {
            return -1;
        }

        int length = 0;
        int counter = 0;

        // 1. подсчет длины
        while (counter < n) {
            length++;
            counter += (int) Math.pow(2, (length - 1) / 2);
        }
        counter -= (int) Math.pow(2, (length - 1) / 2); // отменяем последнюю итерацию

        // 2. подсчет реверсивного элемента
        int element = n - counter - 1;

        // 3. Результирующая строка
        int res = (1 << (length - 1)) | (element << (length / 2));
        int reverse = reversingBitsOfAnInteger(res, length);
        res = res | reverse;

        return res;
    }

    private static int reversingBitsOfAnInteger(int n, int length) {

        int left = length - 1;
        int right = 0;
        int reversed = 0;

        while (left > right) {

            if ((n & (1 << left)) != 0) {
                reversed = reversed | (1 << right);
            }

            if ((n & (1 << right)) != 0) {
                reversed = reversed | (1 << left);
            }
            left--;
            right++;
        }
        return reversed;
    }
}
