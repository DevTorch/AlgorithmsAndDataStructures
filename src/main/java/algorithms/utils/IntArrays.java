package algorithms.utils;

public class IntArrays {
    public static int[] getRandomArray(int size, int max) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * max);
        }

        return array;

    }

    public static int[] getRandomArray(int size, int min, int max) {

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * (max - min) + min);
        }

        return array;
    }
}
