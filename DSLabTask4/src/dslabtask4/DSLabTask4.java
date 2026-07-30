/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package dslabtask4;

/**
 *
 * @author Ahsan Khalid
 */
public class DSLabTask4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Employe obj[]=new Employe [5];
        obj[0]=new Employe("Ahmed Gul",23,45000);
        obj[1]=new Employe("Shabab Khan",88,13000);
        obj[2]=new Employe ("Ahsan Khalid",115,160000);
        obj[3]=new Employe("Rahim khan",81,27000);
        obj[4]=new Employe ("Umer GUl ",76,540000);
        
        obj[0].updatedSalary(obj);
        
    }

}
