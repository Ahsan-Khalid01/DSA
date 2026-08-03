/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package tiktoktoe.game;

import java.awt.Color;

/**
 *
 * @author Ahsan Khalid
 */
public class TiktokTOEGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameFrame frm = new GameFrame();
        frm.setSize(400, 450);
       // frm.setForeground(Color.red);
       frm.getContentPane().setBackground(Color.green);
        frm.setTitle("Tic Tac Toe");
        frm.setLayout(null);
        frm.setDefaultCloseOperation(3);
        frm.addComps();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        
    }

}
