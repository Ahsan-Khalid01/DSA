/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package binarytree;

/**
 *
 * @author Ahsan Khalid
 */
public class Tree1 {
    
    public static Node root;
    
   public Tree1()
   {
       this.root=null;
   }
   
   public void insert(int data)
   {
       Node newNode=new Node(data);
       if(root==null)
       {
           root= newNode;
       }
       Node current=root;
       Node parent=null;
     while(true)
     {
         parent=current;
         if(data < current.data)
         {
            current=current.left;
            if(current ==null)
            {
                parent.left=newNode;
                return;
            }
            
         }
         
         
     }
       
   }

}
