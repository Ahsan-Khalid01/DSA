/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dslabtask1;

/**
 *
 * @author Ahsan Khalid
 */
public class student {
    private String name;
    private int rollNo;
    private double gpa;
    
    public student(String n,int r,double gp)
    {
        this.name=n;
        this.rollNo=r;
        this.gpa=gp;
        
    }
     public void highiestGpa(student a[])
     {
         int x=0;
         double high=a[0].gpa;
         for(int i=1;i<a.length;i++)
         {
             if( a[i].gpa>high)
             {
                 high=a[i].gpa;
                 x=i;
                 
             }
             
         }
       
          System.out.printf("\n%2s %12d %16f\n\n",a[x].name,a[x].rollNo,a[x].gpa);
     }
     
    

}
