/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package diceroll;

import java.util.Random;

/**
 *
 * @author Ahsan Khalid
 */
public class DiceRoll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int frq[]=new int [7];
        Random rd=new Random();
        for (int i=0; i<100000;i++)
        {
            int num=rd.nextInt(6)+1;
            frq[num]++;
        
        }
        for (int j=1;j<frq.length;j++)
        {
            System.out.printf("Frequency of %d   = %d\n",j,frq[j]);
        }
    }

}
