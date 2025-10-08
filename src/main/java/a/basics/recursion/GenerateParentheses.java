package a.basics.recursion;

import java.util.ArrayList;
import java.util.List;

/** Generate Parentheses
 *
 * <p>Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * <p>Example 1:
 * <p>Input: n = 3
 * <p>Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * <p>Example 2:
 * <p>Input: n = 1
 * <p>Output: ["()"]
 * <p>Constraints:
 * <p>1 <= n <= 8
 * */
public class GenerateParentheses {
    public static void main(String[] args) {

        int n = 2;
        char[] chars = new char[n * 2];

        generateParenthesisArray(chars, n, 0, 0, 0);
    }

    private static void generateParenthesisArray(char[] chars, int n, int i, int open, int close) {
        if (i == chars.length) {
            System.out.println(chars);
        }

        if (open < n) {
            chars[i] = '(';
            generateParenthesisArray(chars, n, i + 1, open + 1, close);
        }

        if (close < open) {
            chars[i] = ')';
            generateParenthesisArray(chars, n, i + 1, open, close + 1);
        }
    }
}