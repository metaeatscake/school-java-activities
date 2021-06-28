/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UserObjectController;
import java.util.ArrayList;
import java.util.Scanner;
import model.User;

/**
 *
 * @author bigjo
 */
public class Main {
 
    public static void main(String args[]){
    
        Scanner sc = new Scanner(System.in);
        UserObjectController uoc = new UserObjectController();
        int opt = 0;
        
        do{
        
            System.out.println("[1] View all users");
            System.out.println("[2] Add new user");
            System.out.println("[3] Edit user");
            System.out.println("[4] Delete user");
            System.out.println("[5] View Specific User");
            System.out.println("[6] Exit");
            
            
            System.out.print("Choose an option: ");
            opt = Integer.parseInt(sc.nextLine());
            
            switch(opt){
                
                case 1:
                    
                    ArrayList<User> userList = uoc.viewAllUsers();
                    
                    
                    if(userList != null){
                        for(User i : userList){
                            System.out.println("User ID: " + i.getId());
                            System.out.println("User Name: " + i.getName());
                            System.out.println("User Age: " + i.getAge());
                            System.out.println("User Address: " + i.getAddress());
                            System.out.println("------\n");
                        }
                    } else{
                        System.out.println("\nNo User data to display\n");
                    }
                    break;
                
                case 2:
                    
                    String name = "", address = "";
                    int age = 0;
                    
                    System.out.print("\nEnter name: ");
                    name = sc.nextLine();
                    System.out.print("Enter age: ");
                    age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter address: ");
                    address = sc.nextLine();
                    
                    User u = new User(name, age, address);
                    
                    if(uoc.addUser(u)){
                        System.out.println("\nUser successfully added!");
                    }
                    
                    break;
                    
                case 3:
                    
                    int userId = 0;
                    
                    System.out.print("Enter user ID to update: ");
                    userId = Integer.parseInt(sc.nextLine());
                    
                    u = uoc.viewSpecificUser(userId);
                    
                    if(u != null){
                        System.out.print("Enter new name: ");
                        name = sc.nextLine();

                        System.out.print("Enter new address: ");
                        address = sc.nextLine();

                        System.out.print("Enter new age: ");
                        age = Integer.parseInt(sc.nextLine());

                        u = new User(name, age, address);

                        if(uoc.editUser(u, userId) == true ){
                            System.out.println("\nUser Successfully edited");
                        }
                    }
                    
                    break;
                    
                case 4:
                    
                    System.out.print("Enter user ID to delete: ");
                    userId = Integer.parseInt(sc.nextLine());
                    
                    u = uoc.viewSpecificUser(userId);
                    if (uoc.deleteUser(userId) == true && u != null) {
                        System.out.println("\nUser successfully deleted");
                    }
                    
                    break;
                    
                case 5:
                    
                    System.out.print("Enter user id: ");
                    userId = Integer.parseInt(sc.nextLine());
                    
                    u = uoc.viewSpecificUser(userId);
                    
                    if (u != null) {
                        System.out.println("User ID: " + u.getId());
                        System.out.println("Name: " + u.getName());
                        System.out.println("Age: " + u.getAge());
                        System.out.println("Address: " + u.getAddress());
                    }
                    
                    break;
                    
                case 6:
                    
                    System.out.println("Goodbye");
                    
                    break;
                    
                default:
                    
                    System.out.println("\nInvalid Choice\n");
            }
            
        } while(opt != 6);
        
    }
    
}
