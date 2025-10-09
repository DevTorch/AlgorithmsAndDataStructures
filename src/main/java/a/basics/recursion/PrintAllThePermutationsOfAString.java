package a.basics.recursion;

/**
 * <p>Given a string s, the task is to return all permutations of a given string in lexicographically sorted order.
 *
 * <p>Note: A permutation is the rearrangement of all the elements of a string. Duplicate arrangement can exist.
 *
 * <p>Examples:
 *
 * <p>Input:  s = "ABC"
 * <p>Output: "ABC", "ACB", "BAC", "BCA", "CAB", "CBA"
 *
 * <p>Input: s = "XY"
 * <p>Output: "XY", "YX"
 *
 * <p>Input: s = "AAA"
 * <p>Output: "AAA", "AAA", "AAA", "AAA", "AAA", "AAA"
 */

public class PrintAllThePermutationsOfAString {
    public static void main(String[] args) {
        printAllThePermutationsOfAString(0, "ABCD");
    }

    public static void printAllThePermutationsOfAString(int index, String s) {
        if (index == s.length()) {
            System.out.println(s);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            s = swap(s, index, i);
            printAllThePermutationsOfAString(index + 1, s);
            s = swap(s, index, i);
        }
    }

    private static String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
