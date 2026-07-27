/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package removeduplicatevlaues;

import java.util.Scanner;

/**
 *
 * @author Ahsan Khalid
 */
public class workingclass {
    
    int arr[]=new int[6];
    
    public void input()
    {
       // System.out.println("Orignal Array");
        for(int i=0;i<arr.length;i++)
        {
        Scanner inp=new Scanner(System.in);
        System.out.printf("Enter the Valur of index [%d]  :  \n",i);
        arr[i]=inp.nextInt();
        }
        System.out.println("Orignal Array");
        
        for(int j=0;j<arr.length;j++)
        {
           // System.out.println("Orignal Array");
            System.out.printf(" %d ",arr[j]);
        }
    }
    
    public void removeDuplicate()
    {
        System.out.println("\n\nAfter Reemove Duplicate Values\n");
         // int ar2[]=new int[6];
        
        for(int i=0;i<arr.length;i++){
        int check=arr[i];
        for(int j=0;j<arr.length;j++){
            if(check !=arr[j])
            {
                System.out.printf(" %d ", arr[j]);
             // ar2[j]=arr[j];  //int ar2[]=new int[6];
            }
            
            }
   //  System.out.printf(" %d ",ar2[i]); }
        
       // System.out.printf(" %d ",ar2[i]);
            
    }
    

    }
}
