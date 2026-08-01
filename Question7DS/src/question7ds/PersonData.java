/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package question7ds;

/**
 *
 * @author Ahsan Khalid
 */
public class PersonData 
{
    private String name;
    private int age;
    private String dateOfBirth;

    public PersonData()
    {
    }
    public PersonData(String name, int age, String dateOfBirth)
    {
        this.name = name;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
    public void display()
    {
        System.out.println(name + "   " + age + "   " + dateOfBirth);
    }

}
