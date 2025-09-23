package a.basics;

public class CountNumberOfTrailingZeros {
    public static void main(String[] args) {

        System.out.println("Trailing Zeros: " + countNumberOfTrailingZeros(8));
        System.out.println("Trailing Zeros: " + countNumberOfTrailingZeros(255));
    }

    private static int countNumberOfTrailingZeros(int n) {

        int zeroCounter;

        if (n == 0) {
            return -1;
        }

        System.out.println("Binary N: " + String.format("%8s", Integer.toBinaryString(n)).replace(' ', '0'));

        int mask = n & (n - 1);
        n = n ^ mask;
        zeroCounter = (int)(Math.log10(n) / Math.log10(2));

        return zeroCounter;
    }
}
