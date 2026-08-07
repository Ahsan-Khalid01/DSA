/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practice;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author dcui
 */
public class pClass extends JFrame  {
    public void addcomponent()
    {
        JLabel l1=new JLabel();
        l1.setText("User Name");
        l1.setBounds(10,20, 200, 50);
        l1.setVisible(true);
        this.add(l1);
    }
    
}
