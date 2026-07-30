/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package dslabtask3;

/**
 *
 * @author Ahsan Khalid
 */
public class DSLabTask3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Book arr[]=new Book[5];
        arr[0]=new Book("Data Structure","Ali Muhammad",345);
        arr[1]=new Book("Operating System ","Shahab Udin",1380);
        arr[2]=new Book("Computer Networks","Muhammad Sobhan",1900);
        arr[3]=new Book("Urdu ","Nehmat Shah",700);
        arr[4]=new Book("Islamyat","Naseer Khan",1250);
        System.out.println("=======================================================");
        System.out.println("         ----: Books With Highiest Price :----");
        System.out.println("=======================================================");
        System.out.printf("%2s  %15s %23s","Book Title ","Author","Price");
        System.out.println("\n-------------------------------------------------------");
        arr[0].GreaterPrice(arr);
        System.out.println("=======================================================\n");
    }

}
