/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package assignment.part2.problem5;

import java.util.ArrayList;
/**
 *
 * @author Ahsan Khalid
 */
public class MatrixSearch 
{
    private ArrayList<ArrayList<Integer>> matrix;
    private int rows;
    private int cols;

    public MatrixSearch(int rows, int cols) 
    {
        this.rows = rows;
        this.cols  = cols;
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

    public void printMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                System.out.print(this.matrix.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

    public String searchElement(int searchValue) {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                if (this.matrix.get(i).get(j) == searchValue) {
                    return "Found at Row " + (i + 1) + ", Column " + (j + 1);
                }
            }
        }
        return searchValue + " not found in the matrix.";
    
}
}
