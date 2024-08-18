package algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class DiscreteKnapsackProblem {

    /**
     * <p>Задача о рюкзаке (также задача о ранце) — NP-полная задача комбинаторной оптимизации.
     * Своё название получила от конечной цели: уложить как можно большее число ценных вещей в рюкзак при условии,
     * что вместимость рюкзака ограничена.
     * <p>В общем виде задачу можно сформулировать так:
     * из заданного множества предметов со свойствами «стоимость» и «вес» требуется отобрать
     * подмножество с максимальной полной стоимостью, соблюдая при этом ограничение на суммарный вес.</p>
     */

    public static void main(String[] args) {

        int[] values = {20, 10, 6, 14, 8};
        int[] weights = {2, 3, 5, 7, 4};

        int maxWeight = 50;

        Item[] discreteItems = new Item[values.length];
        for (int i = 0; i < values.length; i++) {
            discreteItems[i] = new Item(weights[i], values[i]);
        }

        System.out.println(discreteKnapsack(discreteItems, maxWeight));

    }

    private static boolean discreteKnapsack(Item[] discreteItems,  int maxWeight) {

        Arrays.sort(discreteItems, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());
        System.out.printf("Sorted items: %s\n", Arrays.toString(discreteItems));
        return false;
    }
}
