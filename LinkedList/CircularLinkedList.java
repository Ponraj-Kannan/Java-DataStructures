public class CircularLinkedList {

    private Node head = null; // Head of the Circular LinkedList
    private int size = 0; // Keeps track of the number of elements in the list

    // Node class representing each element in the Circular LinkedList
    class Node {
        int data; // Data to be stored in the Node
        Node next; // Reference to the next Node in the Circular LinkedList

        // Constructor to create a new Node with given data
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to add a Node with data 'd' at the beginning of the Circular LinkedList
    void addFirst(int d) {
        Node node = new Node(d); // Create a new Node
        if (head == null) {
            head = node; // If the list is empty, set head to the new Node
            node.next = head; // Maintain circular reference
        } else {
            Node temp = head;
            while (temp.next != head) { // Find the last node
                temp = temp.next;
            }
            node.next = head; // New node points to the current head
            temp.next = node; // Last node now points to the new node
            head = node; // Update head to the new node
        }
        size++; // Increment size
    }

    // Method to add a Node with data 'd' at the end of the Circular LinkedList
    void addLast(int d) {
        Node node = new Node(d); // Create a new Node
        if (head == null) {
            head = node; // If the list is empty, set head to the new Node
            node.next = head; // Maintain circular reference
        } else {
            Node temp = head;
            while (temp.next != head) { // Traverse to the last Node
                temp = temp.next;
            }
            temp.next = node; // Last node points to new node
            node.next = head; // New node points back to head (circular reference)
        }
        size++; // Increment size
    }

    // Method to remove the first Node of the Circular LinkedList
    void removeFirst() {
        if (head == null) return; // If list is empty, do nothing
        if (head.next == head) { // If only one node exists
            head = null;
        } else {
            Node temp = head;
            while (temp.next != head) { // Find last node
                temp = temp.next;
            }
            head = head.next; // Move head to the next node
            temp.next = head; // Last node now points to new head
        }
        size--; // Decrement size
    }

    // Method to remove the last Node of the Circular LinkedList
    void removeLast() {
        if (head == null) return; // If list is empty, do nothing
        if (head.next == head) { // If only one node exists
            head = null;
        } else {
            Node temp = head;
            while (temp.next.next != head) { // Find second last node
                temp = temp.next;
            }
            temp.next = head; // Second last node now points to head
        }
        size--; // Decrement size
    }

    // Method to return the size of the Circular LinkedList
    int size() {
        return size; // Directly return the size variable
    }

    // Method to search for a key in the Circular LinkedList
    boolean search(int key) {
        if (head == null) return false; // If list is empty, key is not found
        Node temp = head;
        do {
            if (temp.data == key) return true; // If key matches, return true
            temp = temp.next;
        } while (temp != head); // Continue until we reach head again
        return false; // Key not found
    }

    // Method to display the Circular LinkedList
    void display() {
        if (head == null) { // If list is empty, print message
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> "); // Print node data
            temp = temp.next;
        } while (temp != head); // Stop when we reach head again
        System.out.println("(Back to Head)"); // Indicate circular nature
    }
}
