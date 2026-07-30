/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package questionno8ds;

/**
 *
 * @author Ahsan Khalid
 */
public class point {
    private int x;
    private int y;
    
    public point()
    {
        this.x=0;
        this.y=0;
    }
    
    public void setx(int a)
    {
        this.x=a;
    }
    public void sety(int b)
    {
        this.y=b;
    }
    
    public int getx()
    {
        return this.x;
    }
    public int gety()
    {
        return this.y;
    }
    
    public void distance(point other)
    {
     int d=((this.x - other.x)*(this.x-other.x)) + ((this.y-other.y)*(this.y*other.y));
        System.out.println("Distance :"+d);
    }

}
