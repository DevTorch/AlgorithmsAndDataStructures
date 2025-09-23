package a.basics;

public class SwapAllEvenAndOddBits {

    public static void main(String[] args) {

        System.out.println(swapAllEvenAndOddBits(10));
        System.out.println(swapAllEvenAndOddBits(181));

        System.out.println(("0xAAAAAAAA: " + String.format("%32s", Integer.toBinaryString(0xAAAAAAAA)).replace(' ', '0')));
        System.out.println(("0x55555555: " + String.format("%32s", Integer.toBinaryString(0x55555555)).replace(' ', '0')));
    }
    // O(1)
    private static int swapAllEvenAndOddBits(int n) {

        int evenBits = (n & 0xAAAAAAAA) >>> 1;
        int oddBits = (n & 0x55555555) << 1;

        return evenBits | oddBits;
    }
}
