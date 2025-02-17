import java.util.NoSuchElementException;

public class Stack1 {

    private Node top = null; // Top of the stack
    private int size = 0; // Variable to track the size of the stack

    // Inner class representing a node in the stack
    class Node {
        int data; // Data stored in the node
        Node next; // Reference to the next node in the stack

        // Constructor to initialize a new node with data
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to push an element onto the stack
    void push(int d) {
        Node node = new Node(d); // Create a new node with the given data
        node.next = top; // Link the new node to the current top
        top = node; // Update the top to the new node
        size++; // Increment size
    }

    // Method to check if the stack is empty
    boolean isEmpty() {
        return top == null; // If top is null, the stack is empty
    }

    // Method to pop an element from the stack
    int pop() {
        if (isEmpty()) { // If the stack is empty
            throw new NoSuchElementException("Stack is empty"); // Throw an exception
        }
        int val = top.data; // Get the data from the top node
        top = top.next; // Move the top to the next node
        size--; // Decrement size
        return val; // Return the popped value
    }

    // Method to peek at the top element without removing it
    int peek() {
        if (isEmpty()) { // If the stack is empty
            throw new NoSuchElementException("Stack is empty"); // Throw an exception
        }
        return top.data; // Return the top value
    }

    // Method to get the size of the stack
    int size() {
        return size; // Return the stored size instead of recalculating
    }

    // Method to display the stack elements
    void display() {
        Node temp = top; // Temporary pointer to traverse the stack
        while (temp != null) { // Traverse until the end of the stack
            System.out.print(temp.data + " "); // Print the data in the node
            temp = temp.next; // Move to the next node
        }
        System.out.println(); // Newline after printing all elements
    }
}
