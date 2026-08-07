/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package workertest;

/**
 *
 * @author dcui
 */
public class WorkerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Worker []w=new Worker[5];
        w[0]=new Employee("Rehan Malik",001,9,"Huminity",65000);
        w[1]=new Manager("Ahsan Khalid",1011,8,12,300,14000);
        w[2]=new Employee("Subhan Khan",002,7,"Electrical ",52000);
        w[3]=new Manager("Shahid Khan",2101,8,16,342,13500);
        w[4]=new Employee("Shahabullah",1018,9,"Computer Science",70000);
        for(int i=0;i<w.length;i++)
        {
            w[i].Display();
        }
        Project []p=new Project[5];
        p[0]=new Project("Bank Application",65);
        p[1]=new Project("Delivery App System",44);
        p[2]=new Project("Web Development ",77);
        p[3]=new Project("Online Voting System",48);
        p[4]=new Project("Ludo Game",88);
        for(int j=0;j<p.length;j++)
        {
            p[j].pDisplay();
        }
        
    }
    
}
