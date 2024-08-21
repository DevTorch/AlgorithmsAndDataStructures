package algorithms.tasks.yandex;

/**
 * <p>ЗАДАЧА С СОБЕСЕДОВАНИЙ В ЯНДЕКС:</p>
 * Нулями обозначены пустые места. Выбрать место, максимально удаленное от соседей. Гарантируется,
 * что в ряду есть хотя бы одно свободное место и сидит хотя бы один зритель.
 *
 * В решении пока не учтено крайнее свободное место.
 */

public class YandexCinemaHall {

    public static void main(String[] args) {
        int[] arrayOne = new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};
        int[] arrayTwo = new int[]{0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0};
        int[] arrayThree = {0, 1, 0, 1};
        int[] arrayFour = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] arrayFive = new int[]{1, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        int[] arraySix = new int[]{1, 0, 0, 0, 0, 0, 0, 0};

        System.out.printf("Seat Distance One: %d\n", findBestSeatDist(arrayOne)); // По условию должно возвращать 1;
        System.out.printf("Seat Distance Two: %d\n", findBestSeatDist(arrayTwo)); // По условию должно возвращать 2;
        System.out.printf("Seat Distance Three: %d\n", findBestSeatDist(arrayThree)); // По условию должно возвращать 1;
        System.out.printf("Seat Distance Four: %d\n", findBestSeatDist(arrayFour));
        System.out.printf("Seat Distance Five: %d\n", findBestSeatDist(arrayFive));
        System.out.printf("Seat Distance Six: %d\n", findBestSeatDist(arraySix));
    }

    public static int findBestSeatDist(int[] inputArray) {

        int maxZeroRow = 0;
        int zeroCounter = 0;
        int n = inputArray.length;

        // Переменные учета начальных и конечных нулей
        int leadingZeros = 0;
        int trailingZeros = 0;
        boolean isLeadingZero = true;

        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == 0) {
                zeroCounter++;
                if (isLeadingZero) {
                    leadingZeros++;
                }
            } else {
                if (isLeadingZero) {
                    isLeadingZero = false;
                }
                maxZeroRow = Math.max(zeroCounter, maxZeroRow);
                zeroCounter = 0;
            }
        }

        // Учитываем конечные нули. Если последний элемент != 0 сюда прилетает zeroCounter = 0;
        trailingZeros = zeroCounter;

        return Math.max((int) Math.round(maxZeroRow / 2.0), Math.max(leadingZeros, trailingZeros));
    }
}
