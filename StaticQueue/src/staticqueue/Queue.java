/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package staticqueue;

/**
 *
 * @author Ahsan Khalid
 */
public class Queue {
    int size,len,front,rear;
    int queue[];
    
    public Queue(int s)
    {
        this.size=s;
        queue=new int[size];
        len=0;
        front=-1;
        rear=-1;
    }
    
    public boolean isEmpty()
    {
        return rear==-1;
    }
    public boolean isFull()
    {
        return front==0 && rear==size-1;
    }
    
    
    
    public void Insert(int value)
    {
        if(isEmpty())
        {
          len++;
          front=0;
          rear=0;
          queue [rear]=value;
        }
        else if(rear +1 >=size)
        {
            System.out.println("Queue overFlow");  
        }
        else if(rear +1 < size)
        {
            queue[++rear]=value;
            len++;
        }
    }
    
    public void Delete()
    {
        if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
        else if(rear == front)
        {
            front =-1;
            rear=-1;
            len--;
            System.out.println("Deleted Successfully");
        }
        else
        {
            front++;
            len--;
             System.out.println("Deleted Successfully");
            
        }
        
    }
    
    public void search(int value)
    {
       if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
       else 
       {
                for(int i=front;i<=rear;i++)
                {
                    if(queue[i]==value)
                    {
                        System.out.println("Value Found at  :"+ i);
                    }
                    else
                    {
                        System.out.println("Not Found");
                    }
                }
                
        }
    } 
    
    public void display()
    {
       if(isEmpty())
        {
            System.out.println("Queue is Empty");
        }
       else
       {
           for(int i=front;i<=rear;i++)
           {
               System.out.printf("[%d] ",queue[i]);
           }
       }
    }
}


