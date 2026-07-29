/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignment.part2.problem2;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentPart2Problem2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        RowColumnSum obj = new RowColumnSum(3, 3);
        int[][] values = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        obj.fillMatrix(values);
        System.out.println("==========================================");
        System.out.println("Problem 2: Row and Column Sum \n");
        obj.printMatrix();
        System.out.println();
        obj.printRowSums();
        System.out.println();
        obj.printColumnSums();
                System.out.println("==========================================");
    }
}
    


