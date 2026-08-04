/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dynamicqueue;

/**
 *
 * @author Ahsan Khalid
 */
public class Node {
    
    private int data;
    private Node link;
    
    public Node(int data ,Node link)
    {
        this.data=data;
        this.link=link;
        
    }
    public void SetData(int data)
    {
        this.data=data;
    }
     public void SetLink(Node link)
    {
        this.link=link;
    }
     
    public int getData() {return this.data;}
    public Node GetLink()
    {
        return this.link;
    }
    

}
