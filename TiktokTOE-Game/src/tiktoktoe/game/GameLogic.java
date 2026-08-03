/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tiktoktoe.game;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Ahsan Khalid
 */
public class GameLogic extends JFrame {
    char board[][] = new char[3][3];
    char currentPlayer = 'X';

    public GameLogic()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    public boolean checkWinner()
    {
        return false; // overridden in child class
    }

    public void changePlayer()
    {
        if(currentPlayer == 'X')
            currentPlayer = 'O';
        else
            currentPlayer = 'X';
    }

}
