package a.basics.recursion;


/**
 * <p>Ханойская башня - это математическая головоломка, в которой у нас есть три стержня (A, B и C) и N дисков. Изначально все диски расположены в порядке уменьшения диаметра, т.е. самый маленький диск находится сверху, а они - на стержне A. Цель головоломки состоит в том, чтобы переместить всю стопку на другой стержень (здесь рассматривается С), соблюдая следующие простые правила:
 * <p>
 * Одновременно можно перемещать только один диск.
 * Каждый ход состоит в том, чтобы взять верхний диск из одной стопки и поместить его поверх другой стопки, т.е. диск может быть перемещен только в том случае, если он является самым верхним диском в стопке.
 * Ни один диск не может быть помещен поверх диска меньшего размера
 * <p>
 * <p>Пример:
 * <p>Input: 2
 * <p>Output: Disk 1 moved from A to B
 * <p>Disk 2 moved from A to C
 * <p>Disk 1 moved from B to C
 * <p>
 * <p>Input: 3
 * <p>Output:
 * <p>Disk 1 moved from A to C
 * <p>Disk 2 moved from A to B
 * <p>Disk 1 moved from C to B
 * <p>Disk 3 moved from A to C
 * <p>Disk 1 moved from B to A
 * <p>Disk 2 moved from B to C
 * <p>Disk 1 moved from A to C
 * <p>
 * <p>Input: 4
 * <p>Output:
 * <p>Disk 1 moved from A to B
 * <p>Disk 2 moved from A to C
 * <p>Disk 1 moved from B to C
 * <p>Disk 3 moved from A to B
 * <p>Disk 1 moved from C to A
 * <p>Disk 2 moved from C to B
 * <p>Disk 1 moved from A to B
 * <p>Disk 4 moved from A to C
 * <p>Disk 1 moved from B to C
 * <p>Disk 2 moved from B to A
 * <p>Disk 1 moved from C to A
 * <p>Disk 3 moved from B to C
 * <p>Disk 1 moved from A to B
 * <p>Disk 2 moved from A to C
 * <p>Disk 1 moved from B to C
 */
public class TowerOfHanoiProblem {

    private static int step = 1;

    public static void main(String[] args) {

        towerOfHanoiProblem(3, 'A', 'C', 'B');
    }

    private static void towerOfHanoiProblem(int n, char fromRod, char toRod, char auxRod) {

        if (n == 0) {
            return;
        }

        towerOfHanoiProblem(n - 1, fromRod, auxRod, toRod);
        System.out.println(step++ + ". Disk " + n + " moved from " + fromRod + " to " + toRod);
        towerOfHanoiProblem(n - 1, auxRod, toRod, fromRod);
    }
}
