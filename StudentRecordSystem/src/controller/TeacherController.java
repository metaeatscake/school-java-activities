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
import model.Teacher;

/**
 *
 * @author bigjo
 */
public class TeacherController {
    
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
    
    public boolean add(Teacher t){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "INSERT INTO tbl_teachers(name, username, password) VALUES(?, ?, ?)";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, t.getName());
            this.pstm.setString(2, t.getUsername());
            this.pstm.setString(3, t.getPassword());
            this.pstm.executeUpdate();
            success = true;
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
    
    //UNUSED FUNCTIONS
    public boolean edit(int teacherId){
        boolean success = false;
        return success;
    }
    public boolean delete(int teacherId){
        boolean success = false;
        return success;
    }
    public ArrayList<Teacher> viewAll(){
        ArrayList<Teacher> list = new ArrayList<>();
        return list;
    }
    
    public Teacher getAccountData(String username){
        this.establishConnection();
        Teacher t = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_teachers WHERE username = ?";
        
        try{
            
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, username);
            rs = this.pstm.executeQuery();
            rs.next();
            
            t = new Teacher(
                rs.getInt("id"), 
                rs.getString("name"), 
                rs.getString("username"), 
                rs.getString("password")
            );
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return t;
    }
    
    public boolean verifyLogin(Teacher t){
        
        this.establishConnection();
        boolean success = false;
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) as countValidLogin FROM tbl_teachers WHERE username = ? AND password = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, t.getUsername());
            this.pstm.setString(2, t.getPassword());
            
            rs = this.pstm.executeQuery();
            rs.next();
            if(rs.getInt("countValidLogin") == 1){
                success = true;
            }
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
    
    public boolean verifyUsername(String username){
        this.establishConnection();
        boolean success = false;
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) as countValidUsername FROM tbl_teachers WHERE username = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, username);
            
            rs = this.pstm.executeQuery();
            rs.next();
            if(rs.getInt("countValidUsername") == 0){
                success = true;
            }
            
        } catch(SQLException ex){
            System.out.println("SQL Error: " + ex);
        } catch(Exception ex){
            System.out.println("Strange Error: " + ex);
        }
        
        return success;
    }
}
