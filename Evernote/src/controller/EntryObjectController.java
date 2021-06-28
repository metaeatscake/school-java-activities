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
import model.Entry;

/**
 *
 * @author bigjo
 */
public class EntryObjectController {
    
    private Connection conn;
    private PreparedStatement pstm;
    
    public void establishConnection(){
        try{
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/evernotedb", "root", "");
        }
        catch(SQLException ex){
            System.out.println("Cannot establish connection. " + ex);
        }
    }
    
    public boolean addEntry(Entry e){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "INSERT INTO tbl_entries(title, content) VALUES (?, ?)";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, e.getTitle());
            this.pstm.setString(2, e.getContent());
            
            this.pstm.executeUpdate();
            success = true;
            
        } catch(SQLException ex){
            System.out.println("Cannot add entry. " + ex);
        }
        
        return success;
    }
    
    public boolean editEntry(Entry e, int entryId){
        this.establishConnection();
        
        boolean success = false;
        
        String query = "UPDATE tbl_entries SET title = ?, content = ? WHERE id = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, e.getTitle());
            this.pstm.setString(2, e.getContent());
            this.pstm.setInt(3, entryId);
            
            this.pstm.executeUpdate();
            
            success = true;
                    
        } catch(Exception ex){
            System.out.println("Cannot edit entry. " + ex);
        }
        
        return success;
    }
    
    public boolean deleteEntry(int entryId){
        this.establishConnection();
        boolean success = false;
        
        String query = "DELETE FROM tbl_entries WHERE id = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, entryId);
            this.pstm.executeUpdate();
            
            success = true;
        } catch (Exception ex){
            System.out.println("Cannot Delete Entry. " + ex);
        }
        
        return success;
    }
    
    public ArrayList<Entry> viewAllEntries(){
        this.establishConnection();
        
        ArrayList<Entry> entryList = new ArrayList<>();
        Entry e = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_entries";
        
        try{
            
            String verify = "SELECT COUNT(*) as dataCount FROM tbl_entries";
            this.pstm = this.conn.prepareStatement(verify);
            rs = this.pstm.executeQuery();
            rs.next();
            int rowCount = rs.getInt("dataCount");
        
            this.pstm = this.conn.prepareStatement(query);
            rs = this.pstm.executeQuery();
            
            if (rowCount != 0) {
                
                while(rs.next()){
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String content =  rs.getString("content");
                    String datetime = rs.getString("datetime");
                    
                    e = new Entry(id, title, content, datetime);
                    entryList.add(e);
                }
                
            }
            else{
                throw new Exception("The table has no data");
            }
            
        }catch(Exception ex){
            System.out.println("Cannot view all entries." + ex);
        }
        
        return entryList;
    }
    
    public Entry viewSpecificEntry(int entryId){
        this.establishConnection();
        Entry e = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_entries WHERE id = ?";
        
        try{
            
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1,entryId);
            
            rs = this.pstm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content =  rs.getString("content");
                String datetime = rs.getString("datetime");
                
                e = new Entry(id, title, content, datetime);
            }
            
            else{
                throw new Exception("This entry ID does not exist");
            }
        
        } catch (Exception ex){
            System.out.println("Cannot display entry. " + ex);
        }
        
        
        return e;
    }
}
