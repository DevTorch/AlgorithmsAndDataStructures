package algorithms.tasks;

public class SlidingWindow {
    public static void main(String[] args) {

        int[] array = new int[]{1, 3, 21, -1, 5, 5, 3, 6, 7};
        int k = 4;
        int subarraySum = maxSubarraySum(array, k);
        System.out.printf("Max Subarray Sum: %d\n", subarraySum);

        int s = 26;
        int length = minSubArraySum(array, s);
        System.out.printf("Min Subarray Length: %d\n", length);
    }

    /**
     * <b>Задача:</b> Найти наименьшую длину подмассива, сумма которого не меньше S</br>
     * <p><b>n:</b> длина массива nums.</p>
     * <p><b>minLength:</b> минимальная длина подмассива, инициализируется как <i>Integer.MAX_VALUE</i>.</p>
     * <p><b>left:</b> указатель на левую границу окна.</p>
     * <p><b>sum:</b> текущая сумма элементов в окне.</p>
     * <p><b>Основной цикл:</b></p>
     * <p>Переменная right перемещается от начала до конца массива.</p>
     * <p>В каждой итерации добавляем элемент <i>nums[right]</i> к sum.</p>
     * <p><b>Внутренний цикл while:</b></p>
     * <p>Проверяем <i>sum >= S</i>.</p>
     * <p>Обновляем <i>minLength</i> с помощью <i>Math.min(minLength, right - left + 1)</i>.</p>
     * <p>Уменьшаем <i>sum</i> на <i>nums[left]</i> и сдвигаем левый указатель <i>left</i> вправо.</p>
     * <p>Возврат результата:</p>
     * <p>Если <i>minLength</i> остался равен <i>Integer.MAX_VALUE</i>, значит, не найден ни один подмассив с суммой >= S, и возвращаем 0.
     * Иначе возвращаем minLength.
     */
    private static int minSubArraySum(int[] nums, int s) {

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum += nums[right];

            while (sum >= s) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * Максимальная сумма подмассива постоянной длины k в массиве array
     */
    private static int maxSubarraySum(int[] array, int k) {

        if (k > array.length) {
            return -1;
        }

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += array[i];
        }
        int windowSum = maxSum;
        int index = 0;
        while (k < array.length) {
            windowSum = windowSum + array[k] - array[index];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
            index++;
            k++;
        }
        return maxSum;
    }
}
