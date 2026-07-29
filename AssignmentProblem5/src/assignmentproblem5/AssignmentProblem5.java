/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignmentproblem5;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentProblem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        LinkedListPalindrome list1 = new LinkedListPalindrome();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(2);
        list1.addNode(1);
        System.out.println("===================================================");
        System.out.println("Problem 5: Check if Linked List is Palindrome \n");
        System.out.print("Linked List  : ");
        list1.printList();

        if (list1.checkPalindrome()) 
        {
            System.out.println("Result       : Palindrome");
        } 
        else 
        {
            System.out.println("Result       : Not a Palindrome");
        }

        LinkedListPalindrome list2 = new LinkedListPalindrome();
        list2.addNode(1);
        list2.addNode(2);
        list2.addNode(3);
        list2.addNode(4);
        list2.addNode(5);

        System.out.print("\nLinked List  : ");
        list2.printList();

        if (list2.checkPalindrome())
        {
            System.out.println("Result       : Palindrome");
        }
        else
        {
            System.out.println("Result       : Not a Palindrome");
        }
           System.out.println("===================================================");
    }

    }


