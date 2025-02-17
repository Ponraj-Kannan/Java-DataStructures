import java.util.NoSuchElementException;

public class Queue1 {

    // Front and rear pointers for the queue
    private Node front = null;
    private Node rear = null;
    private int size = 0; // Correctly maintain size

    // Node class representing each element in the queue
    class Node {
        int data;   // Data stored in the node
        Node next;  // Pointer to the next node

        // Constructor to create a new node with the given data
        public Node(int d) {
            data = d;
            next = null;
        }
    }

    // Method to add an element to the queue
    void enQueue(int d) {
        Node node = new Node(d);  // Create a new node
        if (front == null) {  // If the queue is empty
            front = node;  // The new node is both the front and rear
            rear = node;
        } else {
            rear.next = node;  // Attach the new node to the end of the queue
            rear = rear.next;  // Move the rear pointer to the new node
        }
        size++;  // Increment size
    }

    // Method to check if the queue is empty
    boolean isEmpty() {
        return front == null;  // The queue is empty if the front pointer is null
    }

    // Method to remove and return the front element from the queue
    int deQueue() {
        if (isEmpty()) {  // If the queue is empty
            throw new NoSuchElementException("Queue is empty"); // Throw exception instead of returning -1
        }
        int val = front.data;  // Get the data from the front node
        front = front.next;  // Move the front pointer to the next node
        if (front == null) {
            rear = null; // If the queue is empty after dequeue, set rear to null
        }
        size--;  // Decrement size
        return val;  // Return the dequeued value
    }

    // Method to peek at the front element without removing it
    int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.data;
    }

    // Method to get the size of the queue
    int size() {
        return size;  // Use class-level size variable instead of recalculating
    }

    // Method to display the elements of the queue
    void display() {
        Node temp = front;  // Start from the front of the queue
        while (temp != null) {  // Traverse the queue
            System.out.print(temp.data + " ");  // Print each node's data
            temp = temp.next;  // Move to the next node
        }
        System.out.println();  // Print a newline after displaying the queue
    }
}
