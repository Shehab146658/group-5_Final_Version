/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongoDB;

import mongoDB.DB;
import java.util.ArrayList;
import mongo.Course;
import mongo.Student;

/**
 *
 * @author usfng
 */
public class Main {
    
    private static void insert() {
        DB db = new DB();
        
        Student youssef = new Student("Youssef", "youssef.negm@bue.edu.eg", 3);
        Student ahmed = new Student("Ahmed", "ahmed@bue.edu.eg", 2);
        Student ali = new Student("Ali", "ali@bue.edu.eg", 2);
        Student mohamed = new Student("Mohamed", "mohamed@bue.edu.eg", 1);
        
        Course oop = new Course("1", "Object Oriented Programming");
        Course intro = new Course("2", "Introduction to Programming");
        Course adv_db = new Course("3", "Advanced Databases");
        Course phy = new Course("4", "Physics");
        
        youssef.addCourse(phy);
        youssef.addCourse(adv_db);
        
        ahmed.addCourse(adv_db);
        ahmed.addCourse(intro);
        
        ali.addCourse(intro);
        ali.addCourse(oop);
        
        mohamed.addCourse(oop);
        
        db.insertStudent(youssef);
        db.insertStudent(ahmed);
        db.insertStudent(ali);
        db.insertStudent(mohamed);
        
        db.close();
    }
    
    public void update() {
        DB db = new DB();
        
        Student s = db.getStudentByMail("mohamed@bue.edu.eg");
        
        Course c = new Course("23", "Introduction to Java");
        
        s.addCourse(c);
        
        db.updateStudent(s);
        
        db.close();
    }
    
    public void delete() {
        DB db = new DB();
        db.deleteStudent("youssef.negm@bue.edu.eg");
    }
    
    public static void main(String[] args) {
        //insert(); //comment this line to avoid multiple insertions

        DB db = new DB();
       
        ArrayList<Student> students = db.getAllStudents();
        
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        
    }
    
}
