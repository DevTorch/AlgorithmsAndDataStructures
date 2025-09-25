package a.basics.recursion;

public class CheckIfStringIsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hello"));
        System.out.println(isPalindrome("fhjpfegfkfyfkfgefpjhf"));
    }

    private static boolean isPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        // начальный индекс beginIndex включается в подстроку, конечный endIndex – НЕ включается
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}
