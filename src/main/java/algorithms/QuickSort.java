package algorithms;

import algorithms.utils.IntArrays;

import java.util.Arrays;

public class QuickSort {
    /**
     * Алгоритм быстрой сортировки включает следующие шаги:</p>
     *
     * <p> 1. Выбор значения из основного списка, которое называется опорным значением.</p>
     *
     * <p> 2. Разделение остальных значений на два списка: первый содержит значения, которые меньше либо равны опорному
     * значению, и располагается слева от опорного значения, второй содержит значения, которые больше опорного значения, и располагается справа от опорного значения.</p>
     *
     * <p> 3. Повторение метода для всех результирующих списков, пока не останется только одно значение или пустой список значений.</p>
     *
     * <p> 4. Выбор последнего одиночного значения. Если значение располагается слева от опорного значения, оно остаётся таким, пока не будет доведено до первого опорного значения вверху.</p>
     *
     * Метод быстрой сортировки обеспечивает <b>O(n log(n))</b> производительность в среднем.
     *
     */

    public static void main(String[] args) {

        int[] array = IntArrays.getRandomArray(20, 0, 100);

        System.out.printf("Original array: %s%n", Arrays.toString(array));

        var sorted = quickSort(array, 0, array.length - 1);

        System.out.printf("Sorted array: %s%n", Arrays.toString(sorted));
    }

    /**
     * Метод, сортирующий массив по алгоритму Быстрой Сортировки.
     *
     * @param  array    исходный массив
     * @param  start    начальный индекс элемента подмассива
     * @param  end      конечный индекс элемента подмассива
     * @link {@link QuickSortTest#testQuickSort()} QuickSort Test Class
     */

    public static int[] quickSort(int[] array, int start, int end) {

        if (start < end) {

            int p = partition(array, start, end);

            quickSort(array, start, p - 1);
            quickSort(array, p + 1, end);
        }

        return array;
    }

    /**
     * Partitions the given array around a pivot element and returns the index of the pivot element in its final position.
     *
     * @param  array    the array to be partitioned
     * @param  start    the starting index of the partition
     * @param  end      the ending index of the partition
     * @return          the index of the pivot element in its final position
     */
    private static int partition(int[] array, int start, int end) {

        int pivot = array[end];

        int j = start;

        for (int k = start; k < end; k++) {

            if (array[k] <= pivot) {
                swap(array, j, k);
                j++;
            }
        }

        swap(array, j, end);
        return j;
    }

    private static void swap(int[] array, int j, int i1) {

        int temp = array[j];
        array[j] = array[i1];
        array[i1] = temp;
    }
}
