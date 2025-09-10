package a.basics;

/**
 * <p>1. При использовании сдвига влево (или вправо), если в двоичном представлении числе есть последовательные единицы,
 * возникает ситуация, когда под единицей остается единица, пришедшая из сдвига
 * <p>2. Применяя AND мы получаем результат ≠0, если в двоичном представлении была последовательно хотя бы из двух единиц
 * и = 0 в противном случае (n & (n<<1))
 * <p>3. Для подсчета длины последовательности продолжаем сдвигать и подсчитываем циклы
 */

public class LengthOfConsecutiveOnesInBinaryRepresentation {

    public static void main(String[] args) {

        System.out.println(isConsecutive(101));
        System.out.println("Длина последовательности: " + lengthOfConsecutiveOnes(73));
    }

    private static boolean isConsecutive(int n) {
        return (n & (n << 1)) != 0;
    }

    // O(n)
    private static int lengthOfConsecutiveOnes(int n) {
        int count = 0;
        System.out.println("Binary n: " + String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));
        while (n > 0) {
            n = n & (n << 1);
            count++;
        }
        return  count;
    }
}
