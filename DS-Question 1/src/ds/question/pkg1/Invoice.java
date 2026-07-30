/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ds.question.pkg1;

/**
 *
 * @author Ahsan Khalid
 */
public class Invoice {
    private String PartNO;
    private String PartDescription;
    private int PurchaseItemQuantity;
    private double Price;
    
    public Invoice(String pN,String pD,int pi,double p)
    {
        this.PartNO=pN;
        this.PartDescription=pD;
        this.PurchaseItemQuantity=pi;
        this.Price=p;
    }
    
    public void GetInvoiceAmount()
    {
        double TotalPrice=this.PurchaseItemQuantity*this.Price;
      //  System.out.printf("\n%-15s %-25s %-10d %-21f\n",this.PartNO,this.PartDescription,this.PurchaseItemQuantity,TotalPrice);
        System.out.println("Total price"+TotalPrice);
    }

}
