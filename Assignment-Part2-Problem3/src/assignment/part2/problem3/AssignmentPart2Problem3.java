/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignment.part2.problem3;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentPart2Problem3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MaxInEachRow obj = new MaxInEachRow(3, 4);
        int[][] values = {
            {3, 7, 2, 9},
            {5, 1, 8, 4},
            {6, 0, 3, 2}
        };

        obj.fillMatrix(values);
        System.out.println("========================================================");
        System.out.println("Problem 3: Find Maximum Element in Each Row \n");
        obj.printMatrix();
        System.out.println();
        obj.printMaxInEachRow();
         System.out.println("========================================================");
    
}
    

}
