/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package dsa.lab.pkgfinal;

public class DSALabFinal 
{


    public static void main(String[] args)
    {
        
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("Original List:");
        list.display(head);

        head = list.insertAfter(head, 20, 25);

        System.out.println("List After Inserting 25 After 20:");
        list.display(head);
        
        
    }

}
