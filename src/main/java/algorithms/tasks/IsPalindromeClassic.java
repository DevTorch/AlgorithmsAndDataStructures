package algorithms.tasks;

public class IsPalindromeClassic {
    /**
     *  Реализация без использования регулярных выражений, пересоздания строк и StringBuilder с инверсией строки.
     * @link {@link IsPalindromeClassicTest#isPalindromeShouldReturnTrue() Test for IsPalindromeClassic}
     *  */
    public static boolean isPalindrome(String inputString) {

        int charChecker = 0;
        for (int i = 0; i < inputString.length(); i++){
            if (Character.isLetter(inputString.charAt(i))){
                charChecker++;
            }
        }

        if (inputString.length() < 2 || charChecker <= 1){
            return false;
        }

        int start = 0;
        int end = inputString.length() - 1;

        while (start < end) {

            while (!Character.isLetterOrDigit(inputString.charAt(start))) {
                start++;
            }

            while (!Character.isLetterOrDigit(inputString.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(inputString.charAt(start)) != Character.toLowerCase(inputString.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
