/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tiktoktoe.game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
/**
 *
 * @author Ahsan Khalid
 */
public class GameFrame extends GameLogic implements ActionListener {
        JButton btns[][] = new JButton[3][3];
    JLabel lblTurn;
    Font f = new Font("TimesnewRoman", Font.BOLD, 40);

    public void addComps()
    {
        Font fn=new Font("Times new Roman",Font.BOLD+Font.ITALIC,22);
        lblTurn = new JLabel("Turn: X");
        lblTurn.setFont(fn);
        lblTurn.setBounds(140, 10, 200, 30);
        this.add(lblTurn);

        int x = 50, y = 50;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                btns[i][j] = new JButton("");
                btns[i][j].setFont(f);
                btns[i][j].setBounds(x, y, 80, 80);
                btns[i][j].addActionListener(this);
                this.add(btns[i][j]);
                x += 90;
            }
            x = 50;
            y += 90;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(e.getSource() == btns[i][j] && btns[i][j].getText().equals(""))
                {
                    btns[i][j].setText(String.valueOf(currentPlayer));
                    board[i][j] = currentPlayer;

                    if(checkWinner())
{
    JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " Wins!");
    resetGame();
    return;
}
else if(isDraw())
{
    
    JOptionPane.showMessageDialog(this, "Game Draw!");
    resetGame();
    return;
}

changePlayer();
lblTurn.setText("Turn: " + currentPlayer);
                }
            }
        }
    }

  
    @Override
    public boolean checkWinner()
    {
        for(int i=0; i<3; i++)
        {
            if(board[i][0]==currentPlayer && board[i][1]==currentPlayer && board[i][2]==currentPlayer)
                return true;

            if(board[0][i]==currentPlayer && board[1][i]==currentPlayer && board[2][i]==currentPlayer)
                return true;
        }

        if(board[0][0]==currentPlayer && board[1][1]==currentPlayer && board[2][2]==currentPlayer)
            return true;

        if(board[0][2]==currentPlayer && board[1][1]==currentPlayer && board[2][0]==currentPlayer)
            return true;

        return false;
    }

    public void resetGame()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = ' ';
                btns[i][j].setText("");
            }
        }
        currentPlayer = 'X';
        lblTurn.setText("Turn: X");
    }
    
    public boolean isDraw()
{
    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            if(board[i][j] == ' ')
            {
                return false;
            }
        }
    }
    return true;
}


}
