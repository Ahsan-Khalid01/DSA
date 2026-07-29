/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package stackpractice;

import java.util.Scanner;

/**
 *
 * @author Ahsan Khalid
 */
public class Stackpractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack obj=new Stack(5);
        int opt;
        while(true)
        {
            System.out.println("Select Option ");
            System.out.println("1 : Push\n2 : POP\n3  : Search \n4 : Update \n5 : Display\n6 : Exit");
            Scanner input=new Scanner(System.in);
            opt=input.nextInt();
            
            if(opt==1)
            {
                System.out.println("Enter Value ");
                int value=input.nextInt();
                obj.push(value);
            }
            else if(opt==2)
            {
                obj.pop();
            }
             else if(opt==3)
            {
                System.out.println("Enter Value ");
                int value=input.nextInt();
                obj.Search(value);
                
            }
             else if(opt==4)
            {
                System.out.println("Enter Value that u want to update");
                int value=input.nextInt();
                System.out.println("Enter New Value");
                int newValue=input.nextInt();
                obj.Update(value, newValue);
                
            }
             else if(opt==5)
            {
                obj.Display();
            }
             else if(opt==6)
            {
                break;
            }
             else 
            {
                System.out.println("invalid input");
            }
            
        }
    }

}
