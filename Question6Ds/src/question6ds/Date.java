/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package question6ds;

/**
 *
 * @author Ahsan Khalid
 */
public class Date 
{
     private int day;
    private int month;
    private int year;

    public void setDate(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void displayDate() 
    {
        System.out.println(day + "/" + month + "/" + year);
    }

}
