/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package singly.linked.list;

/**
 *
 * @author Ahsan Khalid
 */
public class Node {
    private int data;
    private Node next;
    
    
    public Node()
    {
        this.data=1;
        this.next=null;
    }
    
    public void SetData(int d)
    {
        this.data=d;
    }
    public int GetData()
    {
        return this.data;
    }
    
    public void SetNext(Node n)
    {
        this.next=n;
    }
    
    public Node GetNext()
            
    {
        return this.next;
    }

}
