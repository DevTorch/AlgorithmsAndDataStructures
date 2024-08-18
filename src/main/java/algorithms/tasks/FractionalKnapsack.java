package algorithms.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String[] args) {
        final Item itemOne = new Item(4, 20);
        final Item itemTwo = new Item(3, 18);
        final Item itemThree = new Item(2, 14);

        final Item[] items = {itemOne, itemTwo, itemThree};
        int maxWeight = 7;

        final double v = fractionalKnapsack(items, maxWeight);
        System.out.printf("Better values pack %s\n", v);

        System.out.printf("Sorted items: %s\n", Arrays.toString(items));
    }

    private static double fractionalKnapsack(Item[] items, int maxWeight) {
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerUnitOfWeight).reversed());
        int currentWeight = 0;
        double currentValue = 0;
        int currentItem = 0;

        while (currentItem < items.length && currentWeight != maxWeight) {
            if (currentWeight + items[currentItem].getWeight() < maxWeight) {
                currentValue += items[currentItem].getValue();
                currentWeight += items[currentItem].getWeight();
            } else {
                currentValue +=
                        ((maxWeight - currentWeight) / (double) items[currentItem].getWeight())
                        * items[currentItem].getValue();

                currentWeight = maxWeight;
            }
            currentItem++;
        }
        return currentValue;
    }
}

@Getter
@Setter
@AllArgsConstructor
class Item {
    private int weight;
    private int value;

    public double valuePerUnitOfWeight() {
        return  value / (double) weight;
    }

    @Override
    public String toString() {
        return "{weight: " + weight +
               ", value: " + value +
               '}';
    }
}
