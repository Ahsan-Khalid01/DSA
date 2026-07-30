/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dslabtask3;

/**
 *
 * @author Ahsan Khalid
 */
public class Book {
    private String title;
    private String author;
    private int price;
    
    public Book(String t,String a,int p)
    {
        this.title=t;
        this.author=a;
        this.price=p;
    }
    
    public void GreaterPrice(Book b[])
    {
       for(int i=1; i<b.length;i++)
       {
           if(b[i].price>1000)
             
           {
               System.out.printf("%-20s  %-23s  %-20d\n",b[i].title,b[i].author,b[i].price) ;
           }
       }
  
    }

}
