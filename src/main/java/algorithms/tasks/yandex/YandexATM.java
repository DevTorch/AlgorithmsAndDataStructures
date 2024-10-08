package algorithms.tasks.yandex;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
 >ЗАДАЧА С СОБЕСЕДОВАНИЙ В ЯНДЕКС:
 Про банкомат:
 - Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
 - При выдаче купюры списываются с баланса банкомата.
 - Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
 */

public class YandexATM {
    private static final int MINIMAL_VALUE = Banknote.FIFTY.getValue();
    private static final Map<Banknote, Integer> initialBanknotes =
            new TreeMap<>(Comparator.comparing(Banknote::getValue).reversed());

    public static void main(String[] args) {

        YandexATM.deposit(Banknote.FIFTY, 50);
        YandexATM.deposit(Banknote.HUNDRED, 16);
        YandexATM.deposit(Banknote.FIVE_HUNDRED, 15);
        YandexATM.deposit(Banknote.THOUSAND, 7);
        YandexATM.deposit(Banknote.FIVE_THOUSAND, 5);

        System.out.printf("7_650: %s\n", withdraw(7_650));
        System.out.printf("-1: %s\n", withdraw(49));
        printBalance();
    }

    private static Map<Banknote, Integer> withdraw(int amount) {

        if (amount <= MINIMAL_VALUE || amount % MINIMAL_VALUE != 0) {
            return new TreeMap<>(){{
                put(Banknote.NOT_POSSIBLE, -1);
            }};
        }

        Map<Banknote, Integer> toWithdraw = new TreeMap<>(Comparator.comparing(Banknote::getValue).reversed());

        for (Banknote banknote : initialBanknotes.keySet()) {
            int count = initialBanknotes.get(banknote);
            int numBanknotes = Math.min(amount / banknote.getValue(), count);

            if (numBanknotes > 0) {
                toWithdraw.put(banknote, numBanknotes);
                amount -= numBanknotes * banknote.getValue();
            }
        }
        if (amount > 0) {
            return new TreeMap<>(){{
                put(Banknote.NOT_POSSIBLE, -1);
            }};
        }

        for (Map.Entry<Banknote, Integer> entry : toWithdraw.entrySet()) {
            initialBanknotes.put(entry.getKey(), initialBanknotes.get(entry.getKey()) - entry.getValue());
        }
        return toWithdraw;
    }

    public static void deposit(Banknote banknote, int count) {
        if (initialBanknotes.containsKey(banknote)) {
            initialBanknotes.replace(banknote, initialBanknotes.get(banknote) + count);
        } else {
            initialBanknotes.put(banknote, count);
        }
    }

    private static void printBalance() {
        for (Map.Entry<Banknote, Integer> banknote : initialBanknotes.entrySet()) {
            System.out.println(banknote.getKey().getValue() + "₽" + " " + banknote.getValue());
        }
    }

    private static void printBalance(Map<Banknote, Integer> withdraw) {
        for (Map.Entry<Banknote, Integer> entry : withdraw.entrySet()) {
            System.out.println(entry.getKey().getValue() + "₽" + " " + entry.getValue());
        }
    }
}

enum Banknote {
    FIFTY(50),
    HUNDRED(100),
    FIVE_HUNDRED(500),
    THOUSAND(1000),
    FIVE_THOUSAND(5000),
    NOT_POSSIBLE(-1);

    private final int value;

    Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}