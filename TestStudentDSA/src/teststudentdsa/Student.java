/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package teststudentdsa;

/**
 *
 * @author Ahsan Khalid
 */
public class Student {
    private String Name;
    private String RegNo;
    private double Cgpa;
    
    
    
    public Student(String n,String r,double cg)
    {
        this.Name=n;
        this.RegNo=r;
        this.Cgpa=cg;
    }
    
    public void MaxGpa(Student s[])
    {
        int a=0;
       double max=s[0].Cgpa;
      for(int i=1;i<s.length;i++)
      {
         
          if( s[i].Cgpa>max)
          {
              max=s[i].Cgpa;
              a=i;
              
          }
      }
        System.out.printf("%5s %22s %19f",s[a].Name,s[a].RegNo,max);
    }

}
