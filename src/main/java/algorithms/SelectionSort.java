package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(getRandomArray(80));
        System.out.printf("Original List: %s%n", list);
        System.out.printf("Classic Selection Sort: %s%n", classicSelectionSort(list));
        System.out.printf("Bonus: Get Smallest: %s%n", getSmallest(list));

    }

    /**
     * A function that performs classic Selection Sort on a list of integers.
     *
     * @param  list     the list of integers to be sorted
     * @return          the sorted list of integers
     * @link {@link SelectionSortTest#selectionSortTest()} Test Class
     */
    public static List<Integer> classicSelectionSort(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < list.get(i)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    public static int getSmallest(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < min) {
                min = list.get(i);
                minIndex = i;
            }
        }
        return minIndex != -1 ? list.get(minIndex) : -1; // Return -1 if no minimum found
    }

    public static List<Integer> getRandomArray(int size) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }
}
