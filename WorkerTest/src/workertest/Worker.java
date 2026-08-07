/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workertest;

/**
 *
 * @author dcui
 */
public class Worker {
    private String name;
    private int id;
    private int workinghour;
    public Worker()
    {
    }
    public Worker(String n,int id,int wh)
    {
        this.name=n;
        this.id=id;
        this.workinghour=wh;
        
    }
    public void setName(String n)
    {
        this.name=n;
    }
    public void setID(int id)
    {
        this.id=id;
    }
    public void setWorkingHOur(int wh)
    {
        this.workinghour=wh;
    }
    public String GetName()
    {
        return this.name;
    }
    public int GetID()
    {
        return this.id;
    }
    public int GetWorkingHOur()
    {
        return this.workinghour;
    }
    public void Display()
    {
    
    }
        
}
