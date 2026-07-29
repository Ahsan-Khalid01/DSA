/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignmentproblem1;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentProblem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        LinkedList myList = new LinkedList();

        myList.addNode(1);
        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(4);
        myList.addNode(5);
        System.out.println("==================================================");
        System.out.println("Problem 1: Reverse a Singly Linked List \n");
        System.out.print("Original List : ");
        myList.printList();

        myList.reverseList();

        System.out.print("Reversed List : ");
        myList.printList();
        System.out.println("==================================================");
    }
    }


