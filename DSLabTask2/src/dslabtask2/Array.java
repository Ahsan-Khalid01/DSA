/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dslabtask2;

import java.util.Scanner;

/**
 *
 * @author Ahsan Khalid
 */
public class Array {
    int arr[]=new int[8];
    
    
    public void removeDuplicate()
    {
       Scanner input=new Scanner(System.in);
       for(int i=0;i<arr.length;i++)
       {
           System.out.printf("Enter the Value of Index %d: ",i);
           arr[i]=input.nextInt();
       }
        System.out.println("Orignal Array ");
        for(int j=0;j<arr.length;j++)
        {
            System.out.printf(" %d  ",arr[j]);
           // System.out.println("");
        }
        
        for(int a=0;a<arr.length;a++)
        {
            if(arr[a]!=arr[a+1])
            {
               for(int b=0;b<arr.length;b++)
               {
                   arr[b]=arr[a];
                   System.out.println(arr[b]);
               }
            }
        }
        System.out.println("");
       
    }

}
