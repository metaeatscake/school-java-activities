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
public class Teacher {
    
    private int id;
    private String name;
    private String username;
    private String password;

    // Retrieve data
    public Teacher(int id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // Add data
    public Teacher(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    // Hold data for verification
    public Teacher(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // For use of Views 
    public Teacher(){
        this.id = 0;
        this.name = "";
        this.username = "";
        this.password = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
