/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testgui;

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dcui
 */
public class  class1 extends JFrame implements ActionListener
{
    public void addcom()
    {
        
        JLabel lb=new JLabel();
        lb.setText("Name");
        lb.setBounds(10,10, 100, 30);
        this.add(lb);
        
        JTextField txt=new JTextField();
        String n=
        n=txt.getText();
        
        txt.setBounds(130, 10, 200, 30);
        this.add(txt);
        
        JButton btn=new JButton();
        btn.setText("login");
        btn.setBounds(20, 60, 150, 50);
        this.add(btn);
        btn.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input=e.getActionCommand();
        if(input.compareTo("login")==0)
        {
           // JOptionPane.showMessageDialog(null,"Login Successful");
            JOptionPane.showInputDialog("enter Name");
        }
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
