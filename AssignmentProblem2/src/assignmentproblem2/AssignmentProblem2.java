/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignmentproblem2;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentProblem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

        LinkedListMiddle myList = new LinkedListMiddle();
        myList.addNode(1);
        myList.addNode(2);
        myList.addNode(3);
        myList.addNode(4);
        myList.addNode(5);
        System.out.println("=================================================");
        System.out.println("Problem 2: Find the Middle Node \n");
        System.out.print("Linked List   : ");
        myList.printList();

        int middleValue = myList.findMiddle();
        System.out.println("Middle Element: " + middleValue);

        LinkedListMiddle myList2 = new LinkedListMiddle();
        myList2.addNode(10);
        myList2.addNode(20);
        myList2.addNode(30);
        myList2.addNode(40);

        System.out.print("\nLinked List   : ");
        myList2.printList();
        System.out.println("Middle Element: " + myList2.findMiddle());
        System.out.println("=================================================");
    }
}
    


