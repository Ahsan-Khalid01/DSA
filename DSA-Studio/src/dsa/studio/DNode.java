package dsa.studio;

/**
 * One node in a doubly linked list. Holds a value plus references to
 * both the next node AND the previous node -- this is the key
 * difference from a singly linked Node, which only points forward.
 */
public class DNode {

    public int data;
    public DNode next;
    public DNode prev;

    public DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}