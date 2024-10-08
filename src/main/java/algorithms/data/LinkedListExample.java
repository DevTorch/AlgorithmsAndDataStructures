package algorithms.data;

public class LinkedListExample<T> {

    private Node<T> head;

    public void addFirst(T t) {

        Node<T> firstNode = new Node<>(t);
        firstNode.next = head;
        head = firstNode;
    }

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }

        currentNode.next = new Node<>(t);
    }

    public int get(T t) {
        if (head == null) {
            return -1;
        }

        if (head.value.equals(t)) {
            return 0;
        }

        Node<T> currentNode = head;
        int index = 0;
        while (currentNode.next != null) {
            ++index;
            if (currentNode.next.value.equals(t)) {
                return index;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "LinkedListExample {" +
               " head = " + head +
               '}';
    }

    public void remove(T t) {

        if (head == null) {
            return;
        }

        if (head.value.equals(t)) {
            head = head.next;
            return;
        }

        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value.equals(t)) {
                currentNode.next = currentNode.next.next;
                return;
            }
            currentNode = currentNode.next;
        }

    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node {" +
                   "value = " + value +
                   ", next = " + next +
                   '}';
        }
    }
}
