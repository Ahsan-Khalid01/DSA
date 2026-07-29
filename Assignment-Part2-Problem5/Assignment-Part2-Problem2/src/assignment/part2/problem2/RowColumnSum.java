/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignment.part2.problem2;
import java.util.ArrayList;

/**
 *
 * @author Ahsan Khalid
 */
public class RowColumnSum 
{
    
    private ArrayList<ArrayList<Integer>> matrix;
    private int rows;
    private int cols;

    public RowColumnSum(int rows, int cols) 
    {
        this.rows = rows;
        this.cols = cols;
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

    public void printRowSums()
    {
        System.out.println("Row Sums:");
        for (int i = 0; i < this.rows; i++)
        {
            int rowSum = 0;
            for (int j = 0; j < this.cols; j++)
            {
                rowSum += this.matrix.get(i).get(j);
            }
            System.out.println("  Row " + (i + 1) + " sum = " + rowSum);
        }
    }

    public void printColumnSums()
    {
        System.out.println("Column Sums:");
        for (int j = 0; j < this.cols; j++)
        {
            int colSum = 0;
            for (int i = 0; i < this.rows; i++)
            {
                colSum += this.matrix.get(i).get(j);
            }
            System.out.println("  Column " + (j + 1) + " sum = " + colSum);
        }
    }
}


