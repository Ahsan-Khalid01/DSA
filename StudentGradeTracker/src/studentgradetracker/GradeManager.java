/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentgradetracker;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ahsan Khalid
 */
public class GradeManager {
     private List<Student> students;
 
    public GradeManager() {
        students = new ArrayList<>();
    }
 
    public void addStudent(Student student) {
        students.add(student);
    }
 
    public void removeStudent(String name) {
        students.removeIf(s -> s.getName().equalsIgnoreCase(name));
    }
 
    public Student findStudent(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
 
    public List<Student> getAllStudents() {
        return students;
    }
 
    public double getClassAverage() {
        if (students.isEmpty()) return 0;
        double total = 0;
        for (Student s : students) {
            total += s.getAverage();
        }
        return total / students.size();
    }
 
    public Student getTopStudent() {
        if (students.isEmpty()) return null;
        Student top = students.get(0);
        for (Student s : students) {
            if (s.getAverage() > top.getAverage()) {
                top = s;
            }
        }
        return top;
    }
 
    public Student getLowestStudent() {
        if (students.isEmpty()) return null;
        Student lowest = students.get(0);
        for (Student s : students) {
            if (s.getAverage() < lowest.getAverage()) {
                lowest = s;
            }
        }
        return lowest;
    }
 
    public boolean isEmpty() {
        return students.isEmpty();
    }

}
