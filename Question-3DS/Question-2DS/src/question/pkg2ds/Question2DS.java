/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package question.pkg2ds;

/**
 *
 * @author Ahsan Khalid
 */
public class Question2DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Rectangle r1 = new Rectangle();
        r1.setData(5, 4);

        Rectangle r2 = new Rectangle();
        r2.setData(6, 3);

        System.out.println("=====================================");

        if (r1.getArea() > r2.getArea())
        {
            System.out.println("Rectangle 1 is larger");
        }
        else
        {
            System.out.println("Rectangle 2 is larger");
        }
                System.out.println("=====================================");
    }

}
