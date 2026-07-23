package dsa.studio;

import java.util.ArrayList;
import java.util.List;

/**
 * A singly linked list built from Node objects chained together with
 * "next" references -- there is no backing array here at all. Every
 * operation walks the chain one node at a time (traversal), which is
 * the key difference from DSArray's direct index access.
 */
public class DSLinkedList {

    private Node head;
    private int size;

    public DSLinkedList() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // Walks the whole chain and returns the values in order, head to tail.
    // Used only to build a "snapshot" for the animation, not by the real
    // list logic itself.
    private int[] toArray() {
        int[] result = new int[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }

    public List<AnimationStep> insertAtHead(int value) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        size++;

        steps.add(AnimationStep.success(toArray(), 0, "Inserted " + value + " at the head (index 0)"));
        return steps;
    }

    public List<AnimationStep> insertAtTail(int value) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            size++;
            steps.add(AnimationStep.success(toArray(), 0, "List was empty. Inserted " + value + " as the first node"));
            return steps;
        }

        Node current = head;
        int index = 0;
        while (current.next != null) {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(toArray(), box, "Traversing... currently at index " + index + " (" + current.data + ")"));
            current = current.next;
            index++;
        }

        int[] lastBox = new int[1];
        lastBox[0] = index;
        steps.add(AnimationStep.highlight(toArray(), lastBox, "Reached the last node at index " + index));

        current.next = newNode;
        size++;
        steps.add(AnimationStep.success(toArray(), size - 1, "Inserted " + value + " at the tail (index " + (size - 1) + ")"));
        return steps;
    }

    public List<AnimationStep> insertAtPosition(int value, int position) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (position < 0 || position > size) {
            steps.add(AnimationStep.idle(toArray(), "Invalid position " + position));
            return steps;
        }
        if (position == 0) {
            return insertAtHead(value);
        }

        Node current = head;
        int index = 0;
        while (index < position - 1) {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(toArray(), box, "Traversing... currently at index " + index));
            current = current.next;
            index++;
        }

        int[] box = new int[1];
        box[0] = index;
        steps.add(AnimationStep.highlight(toArray(), box, "Found insertion point, right after index " + index));

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
        size++;

        steps.add(AnimationStep.success(toArray(), position, "Inserted " + value + " at index " + position));
        return steps;
    }

    public List<AnimationStep> deleteAtPosition(int position) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (head == null || position < 0 || position >= size) {
            steps.add(AnimationStep.idle(toArray(), "Invalid position " + position));
            return steps;
        }

        if (position == 0) {
            int[] box = new int[1];
            box[0] = 0;
            steps.add(AnimationStep.highlight(toArray(), box, "Removing head node (" + head.data + ")"));
            head = head.next;
            size--;
            steps.add(AnimationStep.idle(toArray(), "Delete complete, size is now " + size));
            return steps;
        }

        Node current = head;
        int index = 0;
        while (index < position - 1) {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(toArray(), box, "Traversing... currently at index " + index));
            current = current.next;
            index++;
        }

        int[] removeBoxes = new int[2];
        removeBoxes[0] = index;
        removeBoxes[1] = index + 1;
        steps.add(AnimationStep.highlight(toArray(), removeBoxes, "Removing node at index " + (index + 1) + " (" + current.next.data + ")"));

        current.next = current.next.next;
        size--;
        steps.add(AnimationStep.idle(toArray(), "Delete complete, size is now " + size));
        return steps;
    }

    public List<AnimationStep> search(int value) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        Node current = head;
        int index = 0;
        while (current != null) {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(toArray(), box, "Comparing index " + index + " (" + current.data + ") with " + value));

            if (current.data == value) {
                steps.add(AnimationStep.success(toArray(), index, "Found " + value + " at index " + index));
                return steps;
            }
            current = current.next;
            index++;
        }

        steps.add(AnimationStep.idle(toArray(), value + " not found in the list"));
        return steps;
    }

    public List<AnimationStep> reverse() {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();
        int[] originalOrder = toArray();

        Node prev = null;
        Node current = head;
        int index = 0;

        while (current != null) {
            Node nextNode = current.next;

            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(originalOrder, box, "Reversing pointer at index " + index + " (" + current.data + ")"));

            current.next = prev;
            prev = current;
            current = nextNode;
            index++;
        }

        head = prev;
        steps.add(AnimationStep.idle(toArray(), "Reverse complete"));
        return steps;
    }
}