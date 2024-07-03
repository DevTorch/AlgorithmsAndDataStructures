package algorithms.data;

import java.util.Iterator;

import static algorithms.data.DynamicArray.printDynamicArray;

public class DynamicArrayRunner {
    public static void main(String[] args) {

        DynamicArray<String> strings = new DynamicArray<>();
        strings.add("Первый");
        strings.add("Второй");
        strings.add("Третий");

        strings.remove(0);

        DynamicArray<Integer> integers = new DynamicArray<>();
        integers.add(100);
        integers.add(200);
        integers.add(300);
        integers.add(1,300);
        printDynamicArray(integers);

        integers.remove(1);

        DynamicArray<Boolean> booleans = new DynamicArray<>();
        booleans.add(true);
        booleans.add(false);
        booleans.add(true);

        booleans.remove(2);

        printDynamicArray(strings);
        printDynamicArray(integers);
        printDynamicArray(booleans);

        Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            System.out.printf("Test: %s%n", stringIterator.next());
        }

        strings.iterator().forEachRemaining(System.out::println);
    }
}
