package algorithms.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IsPalindromeClassicTest {

    @Test
    void isPalindromeShouldReturnTrue() {
        assertTrue(IsPalindromeClassic.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(IsPalindromeClassic.isPalindrome("A man, a plan, a canal -- Panama!"));
        assertTrue(IsPalindromeClassic.isPalindrome("Madam, I'm Adam"));
    }

    @Test
    void isPalindromeShouldReturnFalse() {

        assertFalse(IsPalindromeClassic.isPalindrome("A"));
        assertFalse(IsPalindromeClassic.isPalindrome("   "));
        assertFalse(IsPalindromeClassic.isPalindrome("!!!"));
        assertFalse(IsPalindromeClassic.isPalindrome("Это не палиндром"));
        assertFalse(IsPalindromeClassic.isPalindrome("a!!!!..."));


    }
}