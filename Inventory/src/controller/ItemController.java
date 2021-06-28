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
import model.Item;

/**
 *
 * @author bigjo
 */
public class ItemController {
    
    private Connection conn;
    private PreparedStatement pstm;
    
    public void establishConnection(){
        try{
            
            String db_src = "itemsdb";
            String db_user = "root";
            String db_pass = "";
            
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db_src, db_user, db_pass);
        
        } catch(SQLException ex){
            System.out.println("Cannot Establish Connection\n"+ex);
        }
    }
    
    public boolean addItem(Item i){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "INSERT INTO tbl_items(name, quantity, price) "
                + "VALUES(?, ?, ?)";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, i.getName());
            this.pstm.setInt(2, i.getQty());
            this.pstm.setDouble(3, i.getPrice());
            
            this.pstm.executeUpdate();
            
            success = true;
            
        }catch(SQLException ex){
            System.out.println("Cannot add Item.\t" + ex);
        }
        
        return success;
    }
    
    public boolean editItem(Item i, int itemId){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "UPDATE tbl_items SET name = ?, quantity = ?, price = ? WHERE id = ?";
        
        try{
            
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, i.getName());
            this.pstm.setInt(2, i.getQty());
            this.pstm.setDouble(3, i.getPrice());
            this.pstm.setInt(4, itemId);
            
            this.pstm.executeUpdate();
            
            success = true;
            
        } catch(SQLException ex){
            System.out.println("Cannot edit Item.\t" + ex);
        }
        
        return success;
    }
    
    public boolean deleteItem(int itemId){
        
        this.establishConnection();
        boolean success = false;
        
        String query = "DELETE FROM tbl_items WHERE id = ?";
        
        try{
        
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, itemId);
            this.pstm.executeUpdate();
            
            success = true;
        
        }catch(SQLException ex){
            System.out.println("Cannot delete item\t"+ex);
        }
        
        return success;
    }
    
    public ArrayList<Item> viewAllItems(){
        
        this.establishConnection();
        
        ArrayList<Item> itemList = new ArrayList<>();
        Item i = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_items";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            rs = this.pstm.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int qty = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                i = new Item(id, name, qty, price);
                itemList.add(i);
            }
            
        }catch(SQLException ex){
            System.out.println("Cannot view all items\t"+ex);
        }
        
        return itemList;
    }
    
    public Item viewItemById(int itemId){
        
        this.establishConnection();
        
        Item i = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_items WHERE id = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setInt(1, itemId);
            
            rs = this.pstm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int qty = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                i = new Item(id, name, qty, price);
            } else{
                throw new SQLException("This id does not exist");
            }
            
        }catch(SQLException ex){
            System.out.println("\nCannot select item\t"+ex+"\n");
        }
        
        return i;
    }
    
    public Item viewItemByName(String itemName){
        this.establishConnection();
        
        Item i = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM tbl_items WHERE name = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, itemName.trim());
            
            rs = this.pstm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int qty = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                i = new Item(id, name, qty, price);
            } else{
                throw new SQLException("This id does not exist");
            }
            
        }catch(SQLException ex){
            System.out.println("Cannot view item\t"+ex);
        }
        
        return i;
    }
    
    public int getCountByName(String name){
        int count = 0;
        
        ResultSet rs = null;
        
        String query = "SELECT COUNT(*) as rowCount FROM tbl_items WHERE name = ?";
        
        try{
            this.pstm = this.conn.prepareStatement(query);
            this.pstm.setString(1, name.trim());
            
            rs = this.pstm.executeQuery();
            
            rs.next();
            count = rs.getInt("rowCount");
        
        }catch(SQLException ex){
            System.out.println("Cannot get Item count\t"+ex);
        }
        
        return count;
    }
    
}
