/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workertest;

/**
 *
 * @author dcui
 */
public class Project {
    private String ProjectName;
    private double Progress;
    public Project(String pN,double p)
    {
        this.ProjectName=pN;
        this.Progress=p;
    }
    public String GetProjectName()
    {
        return this.ProjectName;
    }
    public double GetProgress()
    {
        return this.Progress;
    }
    public void pDisplay()
    {
        System.out.println("\n======: Project Information :======\n");
        System.out.printf("Project Name:    %s\nTotal Progress:     %f \n",this.ProjectName,this.Progress);
       
    }
    
}
