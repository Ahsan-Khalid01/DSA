/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package question6ds;
import java.util.Scanner;
/**
 *
 * @author Ahsan Khalid
 */
public class Question6Ds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Day");
        int day = input.nextInt();
        System.out.println("Enter Month");
        int month = input.nextInt();
        System.out.println("Enter year");
        int year = input.nextInt();

        Date date = new Date();
        date.setDate(day, month, year);

        System.out.println("----- Date -----\n");
        date.displayDate();
    }

    }


