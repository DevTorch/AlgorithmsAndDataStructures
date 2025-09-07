package a.basics;

import java.util.Scanner;

public class BitManipulationDecimalToBinary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();
        System.out.println("Decimal to binary: " + decimalToBinary(n));

        System.out.print("Enter a binary number: ");
        String b = sc.next();

        System.out.println("Binary to decimal: " + binaryToDecimal(b));

    }

    private static String decimalToBinary(int n) {
        StringBuilder b = new StringBuilder();
        while (n > 0) {
            int x = n % 2;
            n = n / 2;
            b.append(x); // Например, сбор строковой переменной был бы таким: b = x + b;
        }
        return b.reverse().toString();
    }

    private static int binaryToDecimal(String b) {
        int result = 0;
        int powOfTwo = 1;
        for (int i = b.length() - 1; i >= 0; i--) {
            result += powOfTwo * (b.charAt(i) - '0');
            powOfTwo *= 2;
        }
        return result;
    }
}
