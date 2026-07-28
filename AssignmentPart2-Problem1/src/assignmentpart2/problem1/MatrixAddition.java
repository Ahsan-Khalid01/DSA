/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignmentpart2.problem1;
import java.util.ArrayList;
/**
 *
 * @author Ahsan Khalid
 */
public class MatrixAddition
{
    private ArrayList<ArrayList<Integer>> matrixA;
    private ArrayList<ArrayList<Integer>> matrixB;
    private int rows;
    private int cols;

    public MatrixAddition(int rows, int cols)
    {
        this.rows = rows;
        this.cols  = cols;
        this.matrixA = new ArrayList<>();
        this.matrixB = new ArrayList<>();
    }

    public ArrayList<ArrayList<Integer>> getMatrixA()
    { 
        return this.matrixA;
    }
    public ArrayList<ArrayList<Integer>> getMatrixB()
    { 
        return this.matrixB;
    }
    public int getRows()
    { 
        return this.rows;
    }
    public int getCols()
    { 
        return this.cols;
    }
    
    public void setMatrixA(ArrayList<ArrayList<Integer>> matrixA)
    {
        this.matrixA = matrixA;
    }
    public void setMatrixB(ArrayList<ArrayList<Integer>> matrixB)
    { 
        this.matrixB = matrixB;
    }
    public void setRows(int rows) 
    { 
        this.rows = rows;
    }
    public void setCols(int cols)
    { 
        this.cols = cols;
    }

    public void fillMatrixA(int[][] values) 
    {
        for (int i = 0; i < this.rows; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.cols; j++)
            {
                row.add(values[i][j]);
            }
            this.matrixA.add(row);
        }
    }

    public void fillMatrixB(int[][] values)
    {
        for (int i = 0; i < this.rows; i++) 
        {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < this.cols; j++)
            {
                row.add(values[i][j]);
            }
            this.matrixB.add(row);
        }
    }
  
    public void printMatrix(ArrayList<ArrayList<Integer>> matrix, String name)
    {
        System.out.println(name + ":");
        for (int i = 0; i < this.rows; i++) 
        {
            for (int j = 0; j < this.cols; j++)
            {
                System.out.print(matrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<Integer>> addMatrices() 
    {
        ArrayList<ArrayList<Integer>> resultMatrix = new ArrayList<>();

        for (int i = 0; i < this.rows; i++) 
        {
            ArrayList<Integer> resultRow = new ArrayList<>();
            for (int j = 0; j < this.cols; j++)
            {
                int sum = this.matrixA.get(i).get(j) + this.matrixB.get(i).get(j);
                resultRow.add(sum);
            }
            resultMatrix.add(resultRow);
        }

        return resultMatrix;
    }


}
