package algorithms.tasks.bellintegrator;

/*
ЗАДАЧА С СОБЕСЕДОВАНИЯ BELL INTEGRATOR:
Даны две строки, состоящие из строчных латинских букв и символов удаления '#' (backspace).
Проверить равны ли эти строки с примененными backspace.

Примеры:
backspaceCompare("ab#c", "ad#c") → true (обе строки превращаются в "ac")
backspaceCompare("ab##", "c#d#") → true (обе строки превращаются в пустую строку)
backspaceCompare("a#c", "b") → false ("c" ≠ "b")
backspaceCompare("#######abc", "#abc") → true (обе строки становятся "abc")
backspaceCompare("abbb##cc###", "addd##ee###") → true (обе строки превращаются в "a")
*/

import java.util.Stack;

public class BellIntegratorBackspaces {

    public static void main(String[] args) {

        System.out.printf("Result Stack is %b\n", backspaceCompareStack("ab#c", "ad#c")); //true
        System.out.printf("Result Stack is %b\n", backspaceCompareStack("a#c", "b")); //false
        System.out.printf("Result Stack is %b\n", backspaceCompareStack("#######abc", "#abc")); //true

        System.out.printf("Result Classic is %b\n", backspaceCompare("ab#c", "ad#c")); //true
        System.out.printf("Result Classic is %b\n", backspaceCompare("ab##", "c#d#")); //true
        System.out.printf("Result Classic is %b\n", backspaceCompare("a#c", "b")); //false
        System.out.printf("Result Classic is %b\n", backspaceCompare("#######abc", "#abc")); //true
        System.out.printf("Result Classic is %b\n", backspaceCompare("abbb##cc###", "addd##ee###")); //true

        System.out.printf("Result StringBuilder is %b\n", backspaceCompareSb("ab#c", "ad#c")); //true
        System.out.printf("Result StringBuilder is %b\n", backspaceCompareSb("ab##", "c#d#")); //true
        System.out.printf("Result StringBuilder is %b\n", backspaceCompareSb("a#c", "b")); //false
        System.out.printf("Result StringBuilder is %b\n", backspaceCompareSb("#######abc", "#abc")); //true
        System.out.printf("Result StringBuilder is %b\n", backspaceCompareSb("abbb##cc###", "addd##ee###")); //true
    }

    // Stack
    private static boolean backspaceCompareStack(String s, String t) {
        Stack<Character> stackOne = new Stack<>();
        Stack<Character> stackTwo = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a != '#') {
                stackOne.push(a);
            } else {
                if (!stackOne.isEmpty()) {
                    stackOne.pop();
                }
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char b = t.charAt(j);
            if (b != '#') {
                stackTwo.push(b);
            } else {
                if (!stackTwo.isEmpty()) {
                    stackTwo.pop();
                }
            }
        }

        if (stackOne.size() != stackTwo.size()) {
            return false;
        } else {
            for (int i = 0; i < stackOne.size(); i++) {
                if (stackOne.pop() != stackTwo.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

    // StringBuilder
    private static boolean backspaceCompareSb(String s, String t) {
        StringBuilder sbA = new StringBuilder();
        StringBuilder sbB = new StringBuilder();

        for (Character a : s.toCharArray()) {
            if (a != '#') {
                sbA.append(a);
            } else {
                if (!sbA.isEmpty()) {
                    sbA.deleteCharAt(sbA.length() - 1);
                }
            }
        }

        for (Character b : t.toCharArray()) {
            if (b != '#') {
                sbB.append(b);
            } else {
                if (!sbB.isEmpty()) {
                    sbB.deleteCharAt(sbB.length() - 1);
                }
            }
        }
        return sbA.compareTo(sbB) == 0;
    }

    // Classic
    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;

        while (i >= 0 || j >= 0) {
            int skipS = 0;
            int skipT = 0;

            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
            i--;
            j--;
        }
        return true;
    }

}
