package algorithms.tasks.yandex;

/*
 ЗАДАЧА С СОБЕСЕДОВАНИЙ В ЯНДЕКС:

 Написать структуру данных, хранящую целые числа и поддерживающую следующие операции:
 1) добавление значения в множество
 2) проверка есть ли значение в множестве
 3) удаление значения из множества
 4) получение случайного значения из множества.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class YandexRandomizer {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public YandexRandomizer() {
        map  = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean add(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    public boolean contains(int val) {
        return map.containsKey(val);
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        list.remove(index);

        int lastElement = list.get(list.size() - 1);

        list.set(index, lastElement);
        map.put(lastElement, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public static void main(String[] args) {

        YandexRandomizer randomizedSet = new YandexRandomizer();

        System.out.println(randomizedSet.add(1));       // true
        System.out.println(randomizedSet.add(2));       // true
        System.out.println(randomizedSet.contains(1));  // true
        System.out.println(randomizedSet.contains(3));  // false
        System.out.println(randomizedSet.getRandom());  // 1 or 2
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.contains(1));   // false
        System.out.println(randomizedSet.getRandom());   // 2

    }
}
