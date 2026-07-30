/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package ds.question.pkg1;

/**
 *
 * @author Ahsan Khalid
 */
public class DSQuestion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Invoice obj1=new Invoice("ST103","RAM",3,6400);
        Invoice obj2=new Invoice("LOP53","MotherBoard",1,7800);
        Invoice obj3=new Invoice("JK212","PSU",4,754);
        Invoice obj4=new Invoice("BV768","Mouse",9,800);
        Invoice obj5=new Invoice("SWE51","Printer",2,9876);
        
        System.out.println("====================================================================");
        System.out.printf("%5s %20s  %14s%17s\n","Part No","Part Description","Quantity","Total Price");
        System.out.println("--------------------------------------------------------------------");
        obj1.GetInvoiceAmount();
        obj2.GetInvoiceAmount();
        obj3.GetInvoiceAmount();
        obj4.GetInvoiceAmount();
        obj5.GetInvoiceAmount();
        System.out.println("====================================================================");

        
    }

}
