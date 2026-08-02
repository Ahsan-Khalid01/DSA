/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package taskfrequency;

/**
 *
 * @author Ahsan Khalid
 */
public class TaskFrequency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arr = {1, 2, 2, 3, 3, 3};

        FrequencyHelper obj = new FrequencyHelper();
        int[] result = obj.getFrequency(arr);
        System.out.println("========================");
        System.out.println("  :-- Frequency :-- ");
        System.out.println("========================\n");
        for (int i = 0; i < result.length; i++) {
            System.out.println(i + " -> " + result[i]);
        }
          System.out.println("========================\n");

    }

}
