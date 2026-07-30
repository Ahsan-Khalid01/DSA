/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dslabtask4;

/**
 *
 * @author Ahsan Khalid
 */
public class Employe {
    private String name;
    private int id;
    private double salary;
    
    public Employe(String n,int id,double s)
    {
        this.name=n;
        this.id=id;
        this.salary=s;
    }
    
    public void updatedSalary(Employe e[])
    {
        int x=0;
        for (int i=0;i<e.length;i++)
        {
            if(e[i].salary<50000)
            {
              double newSalary =e[i].salary*0.10;
              e[i].salary= e[i].salary+newSalary;
              x=i;
            }
            
            System.out.println("Name "+e[x].name+" ID : "+e[x].id+" Salary : "+e[x].salary);
        }
    }

}
