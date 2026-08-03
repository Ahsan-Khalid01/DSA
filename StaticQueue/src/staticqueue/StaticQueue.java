/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package staticqueue;

import java.util.Scanner;

/**
 *
 * @author Ahsan Khalid
 */
public class StaticQueue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue obj=new Queue(10);
        int choice ;
        Scanner input=new Scanner(System.in);
        while (true)
        {
            System.out.printf("\n1"
                    + " 1 > Insert\n 2 > delete \n 3 > Search \n 4 > Dsiplay\n 5 > exit\n\nEnter a Choice.......");
            choice =input.nextInt();
            if(choice ==1 )
            {
                int value;
                System.out.println("Enter Value for Insertion..");
                value=input.nextInt();
                obj.Insert(value);
            }
            else if(choice ==2 )
            {
                obj.Delete();
            }
            else if(choice ==3)
            {
                 int value;
                System.out.println("Enter Value for Searching..");
                value=input.nextInt();
                obj.search(value);
            }
            else if(choice ==4)
            {
                System.out.println("");
                obj.display();
            }
            else if(choice ==5)
            {
                break;
            }
            else
            {
                System.out.println("Invalid Input  Try Again");
            }
            
        }
        
    }

}
