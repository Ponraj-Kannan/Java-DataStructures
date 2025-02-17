import java.util.NoSuchElementException;

public class SinglyLinkedList1 {

    private Node head = null; // Head of the LinkedList
    private int size = 0; // Maintain size of the LinkedList

    // Node class representing each element in the LinkedList
    class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to check if the LinkedList is empty
    boolean isEmpty() {
        return size == 0;
    }

    // Method to add a Node at the beginning
    void addFirst(int d) {
        Node node = new Node(d);
        node.next = head;
        head = node;
        size++;
    }

    // Method to add a Node at the end
    void addLast(int d) {
        Node node = new Node(d);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    // Method to add a Node at a specific index
    void add(int index, int d) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            addFirst(d);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        Node node = new Node(d);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    // Method to remove the first Node
    void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        head = head.next;
        size--;
    }

    // Method to remove the last Node
    void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        if (size == 1) {
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        size--;
    }

    // Method to remove a Node at a specific index
    void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    // Method to get the size of the LinkedList
    int size() {
        return size;
    }

    // Method to search for an element
    boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Method to get the first element
    int getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    // Method to get the last element
    int getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Method to get the element at a specific index
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Method to update an element at a specific index
    int set(int index, int d) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        int oldValue = temp.data;
        temp.data = d;
        return oldValue;
    }

    // Method to display the LinkedList
    void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
