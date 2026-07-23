package dsa.studio;

/**
 * One node in a singly linked list. Holds a value and a reference
 * to the next node in the chain (or null if it's the last node).
 */
public class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}