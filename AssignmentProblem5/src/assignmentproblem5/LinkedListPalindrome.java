/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentproblem5;

import java.util.ArrayList;
/**
 *
 * @author Ahsan Khalid
 */
public class LinkedListPalindrome 
{
    private Node head;

    public LinkedListPalindrome()
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

    public boolean checkPalindrome() 
    {
        ArrayList<Integer> valuesList = new ArrayList<>();

        Node current = this.head;
        while (current != null)
        {
            valuesList.add(current.getData());
            current = current.getNext();
        }

        int leftIndex  = 0;
        int rightIndex = valuesList.size() - 1;

        while (leftIndex < rightIndex) 
        {
            if (!valuesList.get(leftIndex).equals(valuesList.get(rightIndex)))
            {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }

}
