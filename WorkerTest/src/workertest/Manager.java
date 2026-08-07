/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workertest;

/**
 *
 * @author dcui
 */
public class Manager extends Worker
{
    private int NumofProject;
    private int NumofEmploye;
    private double salary;
    public Manager(String n,int id,int wh,int Nop,int noE,double sal)
    {
        super(n,id,wh);
        this.NumofProject=Nop;
        this.NumofEmploye=noE;
        this.salary=sal;
    }
    @Override
    public void Display()
    {
        System.out.println("\n========: Manager Details :========\n");
        System.out.printf("Manager Name:    %s\nManager ID:    %d\nWorking Hour:    %d\nNumber Of Projects:    %d\nNumber Of Employes Managed:    %d\nSalary:    %f",this.GetName(),this.GetID(),this.GetWorkingHOur(),this.NumofProject,this.NumofEmploye,this.salary);
    }
         
}
