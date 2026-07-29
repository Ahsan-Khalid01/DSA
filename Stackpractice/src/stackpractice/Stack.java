/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package stackpractice;

/**
 *
 * @author Ahsan Khalid
 */
public class Stack {
    int top;
    int size;
    int []arr;
    
    public Stack()
    { }
    public Stack(int arrSize)
    {
        size=arrSize;
        arr=new int[size];
        top=-1;
    }
    public void push(int value)
    {
        if(top==size-1)
        {
            System.out.println("Stack is Full");
        }
        else
        {
            top=top+1;
            arr[top]=value;
            System.out.println("Value Added");
        }
        
    }
    public void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
        }
        else
        {
            top=top-1;
            System.out.println("POP successfull");
        }
    }
    public void Search(int value)
    {
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]==value)
           {
               System.out.printf("Value Found  \n Index %d   : Value  %d  ",i,arr[i]);
           }
           else
           {
               System.out.println("Value not Found");
           }
       }
    }
    
    public void Display()
    {
        for(int i=0;i<=top;i++)
        {
            System.out.printf("  %d    ",arr[i]);
        }
    }
    public void Update(int value, int newValue)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==value)
            {
                arr[i]=newValue;
                System.out.println("Update successfully");
            }
            else
            {
                System.out.println("Value not Found");  
            }
        }
    }

}
