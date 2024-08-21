package algorithms.tasks;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

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
