/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package duplicatearrayremoved;

import java.util.Scanner;

/**
 *
 * @author Ahsan Khalid
 */
public class Array {

    
    int arr[]=new int[6];
    
    public void Duplicateremove()
    {
        Scanner input=new Scanner(System.in);
        for(int i=0;i<arr.length;i++)
        {
            System.out.printf("Enter the Value of Index [ %d ]   :  ",i);
            arr[i]=input.nextInt();
        }
        
        System.out.println(" Orignal Array : ");
        for(int a=0;a<arr.length;a++)
        {
            System.out.printf("  %d  ",arr[a]); 
        }
        
        for(int i=0;i<arr.length;i++)
        {
            
            for(int j=1;j<arr.length;j++)
            {
                if(arr[i]!=arr[j])
                {
                     System.out.printf(" %d ", arr[i]);
                    
                }
            }
            
        }
       
    
        
    
}
}
