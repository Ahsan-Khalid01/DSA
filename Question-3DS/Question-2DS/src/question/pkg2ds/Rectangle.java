/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package question.pkg2ds;

/**
 *
 * @author Ahsan Khalid
 */
public class Rectangle {
    
    private double length;
    private double width;
    public void setData(double length, double width) 
    {
        this.length = length;
        this.width = width;
    }

    public double getArea()
    {
        return length * width;
    }

}
