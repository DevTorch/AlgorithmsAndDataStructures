package a.basics.recursion;

public class ReverseAStringUsingRecursion {
    public static void main(String[] args) {

        String s = "Hello World!";

        System.out.println(reverseString(s));
        System.out.println(reverseString("a b c d e f g h i j k l m n o p q r s t u v w x y z"));

        System.out.println(reverseString("Hello World!", "", (s.length()-1)));
    }

    private static String reverseString(String s) {
        if (s.isEmpty()) {
            return "";
        }
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    // Реверс через создание пустой строки и индекс
    private static String reverseString(String s, String r, int i) {
        if (i < 0) {
            return r;
        }
        return reverseString(s, r + s.charAt(i), i-1);
    }
}
