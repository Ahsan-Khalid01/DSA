/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentproblem1;

/**
 *
 * @author Ahsan Khalid
 */
public class LinkedList
{

    private Node head;
    public LinkedList()
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

    public void reverseList()
    {
        Node previous = null;
        Node current  = this.head;
        Node nextNode = null;

        while (current != null)
        {
             nextNode = current.getNext(); 
            current.setNext(previous);      
            previous = current;           
            current  = nextNode;            
        }

        this.head = previous;
    }

}


