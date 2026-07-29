/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package teststudentdsa;

/**
 *
 * @author Ahsan Khalid
 */
public class TestStudentDSA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Student[]arr=new Student[3];
        arr[0]=new Student("Ahmed Gul ","FA24-BCS-114",2.2);
        arr[1]=new Student("Ahsan Khalid","FA24-BCS-115",3.1);
        arr[2]=new Student("Abdur rahim ","FA24-BCS-141",3.3);
          System.out.println("============================================================");
        System.out.println("                ----: Maximum CGPA :----");
        System.out.println("============================================================");
        System.out.printf("%5s %20s %15s\n\n","Student Name","Registration","CGPA");
       // System.out.println("------------------------------------------------------------");
        arr[0].MaxGpa(arr);
        System.out.println("");
        System.out.println("============================================================");
        
    }

}
