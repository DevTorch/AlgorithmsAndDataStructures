package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BinarySearch {

    /**
     * АЛГОРИТМ БИНАРНОГО ПОИСКА:
     *
     * @implNote Реализация одного из базовых и самых простых алгоритмов поиска, основанного на делении массива
     * на две части. Сравниваем центральный элемент с искомым. Если центральный элемент меньше искомого,
     * уходим влево, если больше, то вправо. Повторяем до тех пор, пока не найдем искомый элемент.
     * Немного усложнил задачу, добавив перегруженный метод с поиском по списку строк, который создается из файла,
     * содержащего фрагмент одной из глав «Войны и мира». Ключевое слово выбирается случайным образом из этого же списка.
     *
     * */

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};
        int target = 50;
        int answer = binarySearch(arr, target);

        System.out.printf("Integer Binary Search Answer:  элемент %d найден на позиции %d%n", target,answer);

         /*
          СБОР ДАННЫХ ДЛЯ ПОИСКА ПО СЛОВАМ:
          Собираем слова из файла, сортируем, избавляемся от дубликатов,
          переводим в единый регистр, убирая все лишнее, и формируем коллекцию мз String
         */

        File file = new File("src/main/resources/BinarySearchText.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            String[] words = null;
            while ((line = reader.readLine()) != null) {
                words = line.split(" ");
            }
            final List<String> stringList = Arrays.stream(Objects.requireNonNull(words))
                    .distinct()
                    .sorted()
                    .filter(s -> s.length() > 2)
                    .map(s -> s.toLowerCase().replaceAll("(?U)[\\d\\pP\\s]", ""))
                    .toList();

            String targetWord = stringList.get(new Random().nextInt(stringList.size()));
            System.out.printf("String Binary Search для слова «%s» : %s%n",
                    targetWord,
                    binarySearch(stringList, targetWord));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Performs a binary search on a sorted list of strings to find the index of the target string.
     *
     * @param  list   the sorted list of strings to search in
     * @param  target the string to search for
     * @return        the index of the target string in the list, or -1 if not found
     */
    private static int binarySearch(List<String> list, String target) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
          int mid = start + (end - start) / 2;
            int comparison = target.compareTo(list.get(mid));

            if (comparison == 0) {
                return mid;
            }
            if (comparison > 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Performs a binary search on a sorted array to find the index of a target value.
     *
     * @param  arr    the sorted array to search in
     * @param  target the value to search for
     * @return        the index of the target value in the array, or -1 if not found
     */
    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
