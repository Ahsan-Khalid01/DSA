/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignment.part2.problem5;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentPart2Problem5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     

        MatrixSearch obj = new MatrixSearch(3, 3);

        int[][] values = {
            {10, 20, 30},
            {40, 50, 60},
            {70, 80, 90}
        };

        obj.fillMatrix(values);
        System.out.println("=====================================================");
        System.out.println("Problem 5: Search for an Element in 2D ArrayList\n");
        obj.printMatrix();
        System.out.println();

        System.out.println("Searching for 50 -> " + obj.searchElement(50));
        System.out.println("Searching for 90 -> " + obj.searchElement(90));
        System.out.println("Searching for 25 -> " + obj.searchElement(25));
        System.out.println("=====================================================");
    }
}
  
