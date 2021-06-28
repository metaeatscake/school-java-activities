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
import java.util.Comparator;
import model.User;

/**
 *
 * @author bigjo
 */
public class UserObjectController{
    
    private Connection conn;
    private PreparedStatement pstm;
    
    public void establishConnection(){
        try{
            // Can potentially error because of database name mismatch. SQL File not provided. :(
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_tutorial", "root", "");
        }
        catch(SQLException ex){
            System.out.println("Cannot establish connection. " + ex);
        }
    }
    
    public boolean addUser(User u){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "INSERT INTO tbl_users(name, age, address) VALUES(?, ?, ?)";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, u.getName());
            this.pstm.setInt(2, u.getAge());
            this.pstm.setString(3, u.getAddress());
            
            this.pstm.executeUpdate();
            success = true;
            
        } catch(SQLException ex){
            System.out.println("Cannot add user. " + ex);
        }
        
        return success;
    }
    
    public boolean editUser(User u, int userId){
        this.establishConnection();
        boolean success = false;
        
        

        
        // Update query
        String query = "UPDATE tbl_users SET name = ?, age = ?, address = ? WHERE id = ?";
        
        try{
            
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, u.getName());
            this.pstm.setInt(2, u.getAge());
            this.pstm.setString(3, u.getAddress());
            this.pstm.setInt(4, userId);

            this.pstm.executeUpdate();

            success = true;
            
        }catch(Exception ex){
            System.out.println("Cannot Update User. " + ex);
        }
        
        return success;
    }
    
    public boolean deleteUser(int userId){
        this.establishConnection();
        boolean success = false;
        
        String query = "DELETE FROM tbl_users WHERE id= ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, userId);
            this.pstm.executeUpdate();
            
            success = true;
        } catch(Exception ex){
            System.out.println("Cannot Delete User. " + ex);
        }
        
        return success;
    }
    
    public ArrayList<User> viewAllUsers(){
        this.establishConnection();
        
        ArrayList<User> userList = new ArrayList<>();
        User u = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_users";
        
        try{
            
            String verify = "SELECT COUNT(*) as rowCount FROM tbl_users";
            this.pstm = this.conn.prepareStatement(verify);
            rs = this.pstm.executeQuery();
            rs.next();
            int rowCount = rs.getInt("rowCount");
            
            
            this.pstm = this.conn.prepareStatement(query);
            rs = this.pstm.executeQuery();
            
            if(rowCount != 0){
                
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address =  rs.getString("address");

                    u = new User(id, name, age, address);
                    userList.add(u);
                }
                
            }
            
            else{
                throw new Exception("The table has no data");
            }

            
        }catch(Exception ex){
            System.out.println("Cannot view users. " + ex);
        }
        
        return userList;
        
    }
    
    public User viewSpecificUser(int userID){
        
        this.establishConnection();
        User u = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_users WHERE id = ?";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, userID);
            
            rs = this.pstm.executeQuery();
            
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String address =  rs.getString("address");

                u = new User(id, name, age, address);
            }
            
            else{
                throw new Exception("This user ID does not exist");
            }
            
        } catch(Exception ex){
            System.out.println("Cannot select user. " + ex);
        }
        
        return u;
    }
    
}
