/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignment.part2.problem3;
import java.util.ArrayList;
/**
 *
 * @author Ahsan Khalid
 */
public class MaxInEachRow
{
    private ArrayList<ArrayList<Integer>> matrix;
    private int rows;
    private int cols;

    public MaxInEachRow(int rows, int cols)
    {
        this.rows   = rows;
        this.cols   = cols;
        this.matrix = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getMatrix()
    {
        return this.matrix;
    }
    public int getRows()
    {
       return this.rows;
    }
    public int getCols() 
    {
        return this.cols;
    }

    public void setMatrix(ArrayList<ArrayList<Integer>> matrix)
    {
        this.matrix = matrix; 
    }
    public void setRows(int rows)
    { 
        this.rows = rows;
    }
    public void setCols(int cols)
    {
        this.cols = cols;
    }

    public void fillMatrix(int[][] values)
    {
        for (int i = 0; i < this.rows; i++) 
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.cols; j++) 
            {
                row.add(values[i][j]);
            }
            this.matrix.add(row);
        }
    }

  
    public void printMatrix()
    {
        System.out.println("Matrix:");
        for (int i = 0; i < this.rows; i++)
        {
            for (int j = 0; j < this.cols; j++)
            {
                System.out.print(this.matrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public void printMaxInEachRow() 
    {
        System.out.println("Maximum Element in Each Row:");
        for (int i = 0; i < this.rows; i++)
        {
            int maxValue = this.matrix.get(i).get(0); 

            for (int j = 1; j < this.cols; j++)
            {
                if (this.matrix.get(i).get(j) > maxValue)
                {
                    maxValue = this.matrix.get(i).get(j);
                }
            }

            System.out.println("  Row " + (i + 1) + " max = " + maxValue);
        }
    }


}
