/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package singly.linked.list;

/**
 *
 * @author Ahsan Khalid
 */
public class Singly {
    private Node head;
    private Node tail;
    private Node x;
    private Node pre_x;
    
    public Singly()
    {
        head=new Node();
        x=tail=head;
        pre_x=head;
        
    }
    public void move()       
    {
        pre_x=x;
        x=x.GetNext();
    }

}
