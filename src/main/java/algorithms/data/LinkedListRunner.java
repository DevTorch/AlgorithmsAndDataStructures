package algorithms.data;

import java.util.LinkedList;

public class LinkedListRunner {

    public static void main(String[] args) {

        LinkedListExample<Integer> list = new LinkedListExample<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }
        System.out.println(list);

        LinkedListExample<String> listStrings = new LinkedListExample<>();

        listStrings.addLast("second");
        listStrings.addLast("third");
        listStrings.addLast("fourth");
        listStrings.addLast("fifth");
        System.out.printf("List: %s%n", listStrings);
        listStrings.addFirst("first");
        System.out.printf("List: %s%n", listStrings);
        System.out.printf("Index of 'fourth': %s%n", listStrings.get("fourth"));
        System.out.printf("Index of 'third': %s%n", listStrings.get("third"));
        System.out.printf("Index of 'unknown': %s%n", listStrings.get("unknown"));
        listStrings.remove("fourth");
        System.out.printf("List: %s%n", listStrings);
        listStrings.remove("unknown");
        System.out.printf("List: %s%n", listStrings);

    }
}
