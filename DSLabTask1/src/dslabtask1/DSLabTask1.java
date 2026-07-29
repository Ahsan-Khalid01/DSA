/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package dslabtask1;

/**
 *
 * @author Ahsan Khalid
 */
public class DSLabTask1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        student s[]=new student[5];
        s[0]=new student("Ahsan Khalid",115,3.3);
        s[1]=new student("Abdur Rahim",212,3.4);
        s[2]=new student("Tayyab Malik",121,2.2);
        s[3]=new student("Ahmed",151,3.1);
        s[4]=new student("Ibtesam Gul",103,3.6);
        System.out.println("================================================");
        System.out.printf("%38s","-----: HIGHIEST GPA :-----\n");
         System.out.println("================================================");
        System.out.printf("\n%2s %12s %10s\n","Student Name :","Roll NO :","GPA :");
         s[0].highiestGpa(s);
         System.out.println("================================================");
        
        
        
    }

}
