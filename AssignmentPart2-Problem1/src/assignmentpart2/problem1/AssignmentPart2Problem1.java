/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignmentpart2.problem1;
import java.util.ArrayList;
/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentPart2Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
      
        MatrixAddition obj = new MatrixAddition(3, 3);

        int[][] a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] b = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        obj.fillMatrixA(a);
        obj.fillMatrixB(b);
        System.out.println("=======================================================");
        System.out.println("Problem 1: Matrix Addition using 2D ArrayList \n");
        obj.printMatrix(obj.getMatrixA(), "Matrix A");
        System.out.println();
        obj.printMatrix(obj.getMatrixB(), "Matrix B");
        System.out.println();

        ArrayList<ArrayList<Integer>> result = obj.addMatrices();
        obj.printMatrix(result, "Result (A + B)");
          System.out.println("=======================================================");
    }

    

}
