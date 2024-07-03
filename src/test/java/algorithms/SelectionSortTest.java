package algorithms;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void selectionSortTest() {

        List<Integer> actual = new ArrayList<>(Arrays.asList(6, 1, 5, 2, 4, 3));
        List<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        var sorted = SelectionSort.classicSelectionSort(actual);

        assertEquals(expected, sorted);

    }

    @Test
    void getSmallestElementTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(6, 1, 5, 2, 4, 3));
        assertEquals(1, SelectionSort.getSmallest(list));
    }
}