package algorithms.tasks.bellintegrator;

public class BellIntegratorStringToLong {

    // ЗАДАЧА С СОБЕСЕДОВАНИЯ BELL INTEGRATOR

    public static void main(String[] args) {

        System.out.printf("Result: %d\n", strToInt("5739485347"));
        System.out.printf("Result: %d\n", strToLongJVM("5739485348"));
    }

    // Циклы:
    private static long strToInt(String number) {
        long result = 0;

        for (int i = 0; i < number.length(); i++) {
            if (Character.isDigit(number.charAt(i))) {
                result = result * 10 + number.charAt(i) - '0';
            } else {
                throw new NumberFormatException();
            }
        }
        return result;
    }

    // Стандартные средства:
    private static long strToLongJVM(String number) {
        return Long.parseLong(number);
    }
}
