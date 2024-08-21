package algorithms.tasks.yandex;

import java.util.HashMap;

/*
 ЗАДАЧА С СОБЕСЕДОВАНИЙ В ЯНДЕКС:
 Даны две строки. Проверить, изоморфны ли они.
 */

public class YandexIsomorphicStrings {

    public static void main(String[] args) {

        YandexIsomorphicStrings solution = new YandexIsomorphicStrings();

        System.out.println(solution.isIsomorphic("egg", "add")); // True
        System.out.println(solution.isIsomorphic("foo", "bar")); // False
        System.out.println(solution.isIsomorphic("paper", "title")); // True
        System.out.println(solution.isIsomorphic("ab", "ee")); // False
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if (mapS.containsKey(charS)) {
                if (mapS.get(charS) != charT) {
                    return false;
                }
            } else {
                mapS.put(charS, charT);
            }

            if (mapT.containsKey(charT)) {
                if (mapT.get(charT) != charS) {
                    return false;
                }
            } else {
                mapT.put(charT, charS);
            }
        }

        return true;
    }

}
