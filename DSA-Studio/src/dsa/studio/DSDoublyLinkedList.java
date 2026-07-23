package dsa.studio;

import java.util.ArrayList;
import java.util.List;

/**
 * A doubly linked list built from DNode objects. Keeping both a head
 * and a tail pointer means insertAtTail no longer needs to traverse
 * the whole list -- that's the main practical advantage over a
 * singly linked list.
 */
public class DSDoublyLinkedList 
{

    private DNode head;
    private DNode tail;
    private int size;

    public DSDoublyLinkedList() 
    {
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize() 
    {
        return size;
    }

    private int[] toArray() 
    {
        int[] result = new int[size];
        DNode current = head;
        int i = 0;
        while (current != null) {
            result[i] = current.data;
            i++;
            current = current.next;
        }
        return result;
    }

    public List<AnimationStep> insertAtHead(int value)
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        DNode newNode = new DNode(value);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

        steps.add(AnimationStep.success(toArray(), 0, "Inserted " + value + " at the head (index 0)"));
        return steps;
    }

    public List<AnimationStep> insertAtTail(int value) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        DNode newNode = new DNode(value);

        if (tail == null) {
            head = newNode;
            tail = newNode;
            size++;
            steps.add(AnimationStep.success(toArray(), 0, "List was empty. Inserted " + value + " as the first node"));
            return steps;
        }

        int[] tailBox = new int[1];
        tailBox[0] = size - 1;
        steps.add(AnimationStep.highlight(toArray(), tailBox, "Tail pointer already known -- no traversal needed, going straight to index " + (size - 1)));

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;

        steps.add(AnimationStep.success(toArray(), size - 1, "Inserted " + value + " at the tail (index " + (size - 1) + ")"));
        return steps;
    }

    public List<AnimationStep> insertAtPosition(int value, int position) 
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        if (position < 0 || position > size) {
            steps.add(AnimationStep.idle(toArray(), "Invalid position " + position));
            return steps;
        }
        if (position == 0)
        {
            return insertAtHead(value);
        }
        if (position == size) 
        {
            return insertAtTail(value);
        }

        DNode current = head;
        int index = 0;
        while (index < position - 1)
        {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(toArray(), box, "Traversing... currently at index " + index));
            current = current.next;
            index++;
        }

        int[] box = new int[1];
        box[0] = index;
        steps.add(AnimationStep.highlight(toArray(), box, "Found insertion point, right after index " + index));

        DNode newNode = new DNode(value);
        DNode afterNode = current.next;

        newNode.next = afterNode;
        newNode.prev = current;
        current.next = newNode;
        afterNode.prev = newNode;
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

        DNode current = head;
        int index = 0;
        while (index < position) {
            current = current.next;
            index++;
        }

        int[] box = new int[1];
        box[0] = position;
        steps.add(AnimationStep.highlight(toArray(), box, "Deleting node at index " + position + " (" + current.data + ") using its own prev/next links"));

        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }

        size--;
        steps.add(AnimationStep.idle(toArray(), "Delete complete, size is now " + size));
        return steps;
    }

    public List<AnimationStep> search(int value) {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();

        DNode current = head;
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

    public List<AnimationStep> reverseTraverse()
    {
        List<AnimationStep> steps = new ArrayList<AnimationStep>();
        int[] snapshot = toArray();

        DNode current = tail;
        int index = size - 1;

        while (current != null) {
            int[] box = new int[1];
            box[0] = index;
            steps.add(AnimationStep.highlight(snapshot, box, "Traversing backward using prev pointer -- at index " + index + " (" + current.data + ")"));
            current = current.prev;
            index--;
        }

        steps.add(AnimationStep.idle(snapshot, "Backward traversal complete"));
        return steps;
    }
}