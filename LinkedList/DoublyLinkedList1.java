public class DoublyLinkedList1 {

    private Node head = null; // Head of the LinkedList
    private int size = 0; // Keeps track of the number of elements in the list

    // Node class representing each element in the LinkedList
    class Node {
        int data;
        Node next, prev;

        // Constructor to create a new Node with given data
        public Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    // Method to add a Node with data 'd' at the end of the LinkedList
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
            node.prev = temp;
        }
        size++; // Increment size
    }

    // Method to add a Node with data 'd' at the beginning of the LinkedList
    void addFirst(int d) {
        Node node = new Node(d);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++; // Increment size
    }

    // Method to add a Node at a specific index
    void add(int index, int d) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(d);
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            Node node = new Node(d);
            node.next = temp.next;
            node.prev = temp;

            if (temp.next != null) {
                temp.next.prev = node;
            }
            temp.next = node;
            size++; // Increment size
        }
    }

    // Method to remove the first Node
    void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--; // Decrement size
        }
    }

    // Method to remove the last Node
    void removeLast() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.prev.next = null;
            }
            size--; // Decrement size
        }
    }

    // Method to remove a Node at a specific index
    void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 1; i < index; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next != null) {
                temp.next.prev = temp;
            }
            size--; // Decrement size
        }
    }

    // Method to return the size of the LinkedList
    int size() {
        return size; // Directly return the size variable
    }

    // Method to search for a key in the LinkedList
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

    // Method to get the first element of the LinkedList
    int getFirst() {
        return (head != null) ? head.data : -1;
    }

    // Method to get the last element of the LinkedList
    int getLast() {
        Node temp = head;
        if (temp == null) return -1;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Method to get the element at a specific index
    int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // Method to update the element at a specific index and return the old value
    int set(int index, int d) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        int oldVal = temp.data;
        temp.data = d;
        return oldVal;
    }

    // Method to display the LinkedList
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
