/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author bigjo
 */
public class StudentController {
    
    private Connection conn;
    private PreparedStatement pstm;
    
    public void establishConnection(){
        try{
            
            String db_src = "studentrecorddb";
            String db_user = "root";
            String db_pass = "";
            
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db_src, db_user, db_pass);
        
        } catch(SQLException ex){
            System.out.println("Cannot Establish Connection\n"+ex);
        }
    }
    
    public boolean add(Student s, int teacherId){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "INSERT INTO tbl_students(student_id, name, grade, teacher_id) VALUES (?,?,?,?)";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, s.getStudentId());
            this.pstm.setString(2, s.getName());
            this.pstm.setDouble(3, s.getGrade());
            this.pstm.setInt(4, teacherId);
            this.pstm.executeUpdate();
            success = true;
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
    
    public boolean edit(Student oldS, Student s){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "UPDATE tbl_students SET "
                + "student_id = ?, "
                + "name = ?, "
                + "grade = ? "
                + "WHERE student_id = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, s.getStudentId());
            this.pstm.setString(2, s.getName());
            this.pstm.setDouble(3, s.getGrade());
            this.pstm.setString(4, oldS.getStudentId());
            this.pstm.executeUpdate();
            success = true;
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
        
    }
    
    public boolean delete(String studentId){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "DELETE FROM tbl_students WHERE student_id = ?";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, studentId);
            this.pstm.executeUpdate();
            success = true;
        
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
        
    }
    
    public Student view(String studentId){
        
        this.establishConnection();
        ResultSet rs = null;
        Student s = null;
        
        String query = "SELECT * FROM tbl_students WHERE student_id = ?";
        
        try{
            this.pstm =  this.conn.prepareStatement(query);
            this.pstm.setString(1, studentId);
            rs = this.pstm.executeQuery();
            rs.next();
            
            s = new Student(
                    rs.getInt("id"),
                    rs.getString("student_id"),
                    rs.getString("name"),
                    rs.getDouble("grade"),
                    rs.getInt("teacher_id")
            );
        }catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return s;
    }
    
    public ArrayList<Student> viewAll(int teacherId){
    
        this.establishConnection();
        ArrayList<Student> studentList= new ArrayList<>();
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_students WHERE teacher_id = ?";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, teacherId);
            rs = this.pstm.executeQuery();
            
            while(rs.next()){
                
                studentList.add(new Student(
                    rs.getInt("id"),
                    rs.getString("student_id"),
                    rs.getString("name"),
                    rs.getDouble("grade"),
                    rs.getInt("teacher_id")
                ));
            }
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return studentList;
    }
    
    public boolean checkStudentId(String studentId, int teacherId){
        
        this.establishConnection();
        boolean success = false;
        ResultSet rs = null;
        
        String query = "SELECT count(*) as countStudentId FROM tbl_students "
                + " WHERE student_id = ? "
                + " AND teacher_id = ?";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, studentId);
            this.pstm.setInt(2, teacherId);
            rs = this.pstm.executeQuery();
            rs.next();
            
            if(rs.getInt("countStudentId") == 1){
                success = true;
            }
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
    
        public boolean checkStudentId(String studentId){
        
        this.establishConnection();
        boolean success = false;
        ResultSet rs = null;
        
        String query = "SELECT count(*) as countStudentId FROM tbl_students "
                + " WHERE student_id = ? ";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, studentId);
            rs = this.pstm.executeQuery();
            rs.next();
            
            if(rs.getInt("countStudentId") == 1){
                success = true;
            }
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
    
    public void printStudent(Student s){
        System.out.println("\nStudent ID: " + s.getStudentId());
        System.out.println("Name: " + s.getName());
        System.out.println("Grade: " + s.getGrade());
    }
}
