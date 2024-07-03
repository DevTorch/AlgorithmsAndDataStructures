package algorithms.data;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] listElements;

    public DynamicArray() {
        this.listElements = (T[]) new Object[0];
    }

    /**
     * Adds an element to the dynamic array.
     *
     * @param  element   the element to be added
     * @return          void
     */
    public void add(T element) {
        T[] tempElements = Arrays.copyOf(listElements, listElements.length + 1);
        tempElements[listElements.length] = element;
        listElements = tempElements;
    }
    /**
     * Adds an element at the specified index in the dynamic array.
     *
     * @param  index   the index at which the element should be added
     * @param  element the element to be added
     */
    public void add(int index, T element) {
        T[] tempElements = Arrays.copyOf(listElements, listElements.length + 1);
        System.arraycopy(listElements, index, tempElements, index + 1, listElements.length - index);
        tempElements[index] = element;
        listElements = tempElements;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns void.
     *
     * @param  index   the index of the element to be removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void remove(int index) {
        if (index < 0 || index >= listElements.length) {
            throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds Exception");
        }
        T[] tempElements = Arrays.copyOf(listElements, listElements.length - 1);
        System.arraycopy(listElements, 0, tempElements, 0, index);
        System.arraycopy(listElements, index + 1, tempElements, index, listElements.length - index - 1);
        listElements = tempElements;
    }

    public T get(int index) {
        if (index > (listElements.length - 1) || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Array Index Out Of Bounds Exception");
        }
        return listElements[index];
    }

    public int getSize() {
        return listElements.length;
    }

    public static <T> void printDynamicArray(DynamicArray<T> array) {
        for (int i = 0; i < array.getSize(); i++) {
            System.out.printf("%d: %s%n", (i + 1), array.get(i));
        }
    }

    /**
     * Returns an iterator over the elements in this DynamicArray. The elements are
     * iterated in the order they were added to the DynamicArray.
     *
     * @return an Iterator over the elements in this DynamicArray
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private int currentElementIndex;

        @Override
        public boolean hasNext() {
            return currentElementIndex < listElements.length;
        }

        @Override
        public T next() {
            return listElements[currentElementIndex++];
        }
    }
}