/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author bigjo
 */
public class Student {
    
    private int id;
    private String studentId;
    private String name;
    private double grade;
    private int teacherId;

    // Retrieve data
    public Student(int id, String studentId, String name, double grade, int teacherId) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.teacherId = teacherId;
    }
    
    // Update data
    public Student(String studentId, String name, double grade) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
    }

    // Add data
    public Student(String studentId, String name, double grade, int teacherId) {
        this.studentId = studentId;
        this.name = name;
        this.grade = grade;
        this.teacherId = teacherId;
    }
    
    // For use of View.
    public Student(){
        this.id = 0;
        this.studentId = "";
        this.name = "";
        this.grade = 0;
        this.teacherId = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    
    
}
