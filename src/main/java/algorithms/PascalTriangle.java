package algorithms;

import java.util.Arrays;

/**
 * <p>Напишите метод, в который вводится натуральное число N, а метод возвращает треугольник Паскаля. Число N –
 * степень или количество этажей в треугольнике.</p>
 * <p>P.S. Треугольник должен быть выровнен по центру.
 * Между соседними числами в ряду должен быть ровно 1 пробел.</p>
 *
 * @implNote Треугольник Паскаля (арифметический треугольник) — бесконечная таблица биномиальных коэффициентов,
 * имеющая треугольную форму. В этом треугольнике на вершине и по бокам стоят единицы.
 * Каждое число равно сумме двух расположенных над ним чисел. Строки треугольника симметричны
 * относительно вертикальной оси. Назван в честь Блеза Паскаля.
 */

public class PascalTriangle {

    public static void main(String[] args) {

        System.out.println(getPascalTriangle(25));
    }

    /**
     * Метод, формирующий дерево Паскаля
     *
     * @param  n   Размерность треугольника Паскаля, высота в строках.
     * @return     возврат результирующей строки
     */
    public static String getPascalTriangle(int n) {

        StringBuilder resultString = new StringBuilder();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            long element_ij = 1;

            resultString.append(element_ij);
            for (int j = 1; j <= i; j++) {
                element_ij *= (i - j + 1);
                element_ij /= j;
                resultString.append(" ").append(element_ij);
            }
            strings[i] = String.valueOf(resultString);
            resultString.setLength(0);
        }
        int whitespace;
        for (int i = 0; i < n; i++) {
            whitespace = ((strings[n - 1].length() - strings[i].length()) / 2);
            strings[i] = " ".repeat(whitespace) + strings[i];
        }
        Arrays.stream(strings).forEach((e) -> resultString.append(e + "\n"));

        return String.valueOf(resultString);
    }
}
