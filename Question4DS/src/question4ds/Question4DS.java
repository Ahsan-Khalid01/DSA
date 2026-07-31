/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package question4ds;
import java.util.Scanner;
/**
 *
 * @author Ahsan Khalid
 */
public class Question4DS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          Scanner input = new Scanner(System.in);

        System.out.print("Enter size of matrix: ");
        int size = input.nextInt();

        Matrix m = new Matrix(size);

        System.out.println("Enter matrix elements:");
        m.inputMatrix(input);

        System.out.println("----- Matrix -----\n");
        m.displayMatrix();

        System.out.println("\nDiagonal Sum = " + m.getDiagonalSum());
    }    }


