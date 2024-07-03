package algorithms;

import algorithms.utils.IntArrays;

import java.util.Arrays;

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

        int[] values = IntArrays.getRandomArray(5, 50);
        int[] weights = IntArrays.getRandomArray(5, 1, 15);
        int maxWeight = 50;

        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(weights));


        System.out.println(knapsack(values, weights, maxWeight));

    }

    private static boolean knapsack(int[] values, int[] weights, int maxWeight) {

        return false;
    }
}
