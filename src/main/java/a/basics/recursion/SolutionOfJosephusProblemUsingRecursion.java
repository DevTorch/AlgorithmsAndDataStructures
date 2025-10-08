package a.basics.recursion;

/**
 * Задача Иосифа Флавия – это математическая головоломка, в которой группа людей стоит по кругу и убивает
 * каждого m-го человека, пока не останется один выживший. Задача состоит в том, чтобы определить,
 * какое начальное местоположение человека позволит ему остаться в живых, и она основана на легенде о самом Иосифе Флавии,
 * который спасся от смерти во время Иудейской войны, вычислив свое местоположение
*/

public class SolutionOfJosephusProblemUsingRecursion {
    public static void main(String[] args) {
        System.out.println(josephusProblem(5, 3));
        System.out.println(josephusProblem(6, 3));
        System.out.println(josephusProblem(7, 3));
        System.out.println(josephusProblem(154, 5));
    }

    private static int josephusProblem(int capacity, int m) {
        if (capacity == 1) {
            return 0;
        }
        return (josephusProblem(capacity - 1, m) + m) % capacity;
    }
}
