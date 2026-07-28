/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dsa.lab.pkgfinal;


public class SinglyLinkedList 
{
  
     Node insertAfter(Node head, int target, int value) 
    {

        Node current = head;

        while (current != null)
        {

            if (current.data == target)
            {

                Node newNode = new Node(value);
                newNode.next = current.next;
                current.next = newNode;
                break;
            }

            current = current.next;
        }

        return head;
    }

    void display(Node head) 
    {

        Node current = head;

        while (current != null) 
        {
            System.out.print(current.data);

            if (current.next != null)
            {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }
}