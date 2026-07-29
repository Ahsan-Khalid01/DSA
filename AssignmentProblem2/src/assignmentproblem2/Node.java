/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentproblem2;

/**
 *
 * @author Ahsan Khalid
 */
public class Node
{
    private int data;
    private Node next;   
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    public int getData()
    {
        return this.data;
    }

    public void setData(int data) 
    {
        this.data = data;
    }
  
    public Node getNext()
    {
        return this.next;
    }

    public void setNext(Node next) 
    {
        this.next = next;
    }



}
