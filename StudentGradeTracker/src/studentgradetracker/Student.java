/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package studentgradetracker;

/**
 *
 * @author Ahsan Khalid
 */
public class Student
{
     private String name;
    private double[] grades;
 
    public Student(String name, double[] grades) {
        this.name = name;
        this.grades = grades;
    }
 
    public String getName() {
        return name;
    }
 
    public double[] getGrades() {
        return grades;
    }
 
    public double getAverage() {
        double total = 0;
        for (double g : grades) {
            total += g;
        }
        return total / grades.length;
    }
 
    public double getHighest() {
        double max = grades[0];
        for (double g : grades) {
            if (g > max) max = g;
        }
        return max;
    }
 
    public double getLowest() {
        double min = grades[0];
        for (double g : grades) {
            if (g < min) min = g;
        }
        return min;
    }
 
    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }

}
