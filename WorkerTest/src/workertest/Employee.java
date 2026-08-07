/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workertest;

/**
 *
 * @author dcui
 */
public class Employee extends Worker {
    private String DepartmentName;
    private double salary;
    public Employee(String name,int id,int wh,String dn,double s)
    {
        super(name,id,wh);
        this.DepartmentName=dn;
        this.salary=s;
    }
    @Override
    public void Display()
    {
        System.out.println("\n=========: Employe Details :=========\n");
        System.out.printf("Employe ID:   %d\nEmploye Name:   %s\nDepartment Name:   %s\nWorking Hour:   %d\nSalary:   %f\n\n",this.GetID(),this.GetName(),this.DepartmentName,this.GetWorkingHOur(),this.salary);
    }
      
    
    
    
}
