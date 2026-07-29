/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package assignmentevalution;

/**
 *
 * @author Ahsan Khalid
 */
public class AssignmentEvalution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        LinkedList obj=new LinkedList();
        obj.InsertData(77);
        obj.InsertData(10);
        obj.InsertData(24);
        obj.InsertData(11);
        obj.InsertData(31);
        obj.InsertData(90);
        //obj.PrintOrginal();
        System.out.println("");
        obj.DeleteEven();
    }

}
