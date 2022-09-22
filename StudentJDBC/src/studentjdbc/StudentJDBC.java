/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import utilities.DatabaseDriver;
import utilities.DatabaseHandler;

/**
 *
 * @author pwn233
 */
public class StudentJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String url = "jdbc:derby://localhost:1527/student";
        String user = "stu";
        String passwd = "stu";

        DatabaseDriver dbDriver = new DatabaseDriver(driver, url, user, passwd);
        DatabaseHandler dbHandler = new DatabaseHandler(dbDriver);
        Student stud1 = new Student(1, "Kue", 3.52);
        Student stud2 = new Student(2, "Saint", 2.86);
        Student stud3 = new Student(3, "Seenam", 3.24);
        StudentTable.insertStudent(dbHandler, stud1);
        StudentTable.insertStudent(dbHandler, stud2);
        StudentTable.insertStudent(dbHandler, stud3);
        ArrayList<Student> studentList = StudentTable.findAllStudent(dbHandler);
        System.out.println("Insert");
        if (studentList != null) {
            printAllStudent(studentList);
        }
        
        Student stud4 = StudentTable.findStudentById(dbHandler, 1);
        stud4.setName("Beat");
        stud4.setGPA(1.56);
        StudentTable.updateStudent(dbHandler, stud4);
        //StudentTable.removeStudent(dbHandler, stud4);
        studentList = StudentTable.findAllStudent(dbHandler);
        System.out.println("Update : student id = 1, {name = beat, GPA = 1.56}");
        if (studentList != null) {
            printAllStudent(studentList);
        }
        
        StudentTable.removeStudent(dbHandler, stud2);
        studentList = StudentTable.findAllStudent(dbHandler);
        System.out.println("Delete : student name = Saint, {name = Saint}");
        if (studentList != null) {
            printAllStudent(studentList);
        }
        
        resetData(dbHandler, studentList, stud1, stud2, stud3, stud4);
        dbHandler.closeConnection();
    }
    
    public static void printAllStudent(ArrayList<Student> studentList) {
        for(int i = 0; i < studentList.size(); i++) {
            System.out.print(studentList.get(i).getId() + " ");
            System.out.print(studentList.get(i).getName() + " ");
            System.out.println(studentList.get(i).getGPA() + " ");
        }    
    }
    public static void printStudent(Student student) {
            System.out.print(student.getId() + " ");
            System.out.print(student.getName() + " ");
            System.out.println(student.getGPA() + " ");
    }
    public static void resetData(DatabaseHandler dbHandler, ArrayList<Student> studentList, Student stud1, Student stud2, Student stud3, Student stud4) throws SQLException
    {
        StudentTable.removeStudent(dbHandler, stud1);
        StudentTable.removeStudent(dbHandler, stud2);
        StudentTable.removeStudent(dbHandler, stud3);
        StudentTable.removeStudent(dbHandler, stud4);
        studentList = StudentTable.findAllStudent(dbHandler);
    }    
}
