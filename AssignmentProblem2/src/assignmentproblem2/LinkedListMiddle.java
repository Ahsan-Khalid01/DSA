/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentproblem2;

/**
 *
 * @author Ahsan Khalid
 */
public class LinkedListMiddle 
{

    private Node head;
    public LinkedListMiddle() 
    {
        this.head = null;
    }
    public Node getHead()
    {
        return this.head;
    }
    public void setHead(Node head)
    {
        this.head = head;
    }
    public void addNode(int value)
    {
        Node newNode = new Node(value);

        if (this.head == null)
        {
            this.head = newNode;
            return;
        }

        Node current = this.head;
        while (current.getNext() != null)
        {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public void printList()
    {
        Node current = this.head;
        while (current != null)
        {
            System.out.print(current.getData());
            if (current.getNext() != null)
            {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }
    public int findMiddle() 
    {
        Node slowPointer = this.head;
        Node fastPointer = this.head;

        while (fastPointer != null && fastPointer.getNext() != null)
        {
            slowPointer = slowPointer.getNext();               
            fastPointer = fastPointer.getNext().getNext();     
        }

        return slowPointer.getData();
    }

}


