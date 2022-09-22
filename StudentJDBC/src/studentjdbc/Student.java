/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

/**
 *
 * @author pwn233
 */
public class Student {
    private int id;
    private String name;
    private double GPA;
    public Student () {
        
    }
    public Student(int id, String name, double GPA) {
        this.id = id;
        this.name = name;
        this.GPA = GPA;
    }

    Student(int size) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
