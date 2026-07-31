/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package question4ds;
import java.util.Scanner;
/**
 *
 * @author Ahsan Khalid
 */
public class Matrix {

  private int[][] data;
    private int size;
    public Matrix(int size)
    {
        this.size = size;
        data = new int[size][size];
    }
    public void inputMatrix(Scanner input)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++) 
            {
                data[i][j] = input.nextInt();
            }
        }
    }
    public void displayMatrix()
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++) 
            {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int getDiagonalSum()
    {
        int sum = 0;
        for(int i = 0; i < size; i++)
        {
            sum += data[i][i];
        }
        return sum;
    }

}
