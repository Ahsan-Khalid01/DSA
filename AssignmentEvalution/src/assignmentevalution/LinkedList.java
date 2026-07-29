/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentevalution;

/**
 *
 * @author Ahsan Khalid
 */
public class LinkedList 
{
    Node previous;
    Node Current;

    private Node head;
    
    public LinkedList()
    {
        this.head=null;
        Node n=new Node();
    }
    public void Move()
    {
        previous=Current;
        Current=Current.getNext();
        
     }
    public void InsertData(int d)
    {
     
        Node n=new Node(d);
    }
   
    
  public void DeleteEven()
  {
      previous = head;
      Current =head.getNext();
      while(Current.getNext()!=null)
      {
          if(Current.getData()%2==0)
          {
              previous=Current.getNext();
              Move();
          }
      }
      
      Node a=head;
      while(Current.getNext()!=null)
      {
          System.out.println("  after Delete  : "  + Current.getData());
      }
       
  }
  
  
}
