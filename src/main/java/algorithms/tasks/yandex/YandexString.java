package algorithms.tasks.yandex;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
ЗАДАЧА С СОБЕСЕДОВАНИЙ В ЯНДЕКС:
Вывести A4B3... Если символ в строке встречается один раз, он остается без изменений и дополнений.
 */

public class YandexString {
    public static void main(String[] args) {
        String s = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";

        StringBuilder builder = new StringBuilder();
        s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .forEach((key, value) -> {
                    if (value == 1){
                        builder.append(key);
                    } else {
                        builder.append(key).append(value);
                    }
                });
        System.out.printf("String: %s\n", builder);
    }
}
