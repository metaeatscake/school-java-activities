/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EntryObjectController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Entry;

/**
 *
 * @author bigjo
 */
public class Main {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        EntryObjectController eoc = new EntryObjectController();
        Entry e = null;
        int entryId = -1;
        
        int opt = 0;
        
        do{
        
            String[] menuArray = new String[]{
              "View all entries",
              "View specific entry",
              "Add an entry",
              "Edit an entry",
              "Delete an entry",
              "Exit"
            };
            
            for (int i = 0; i < menuArray.length; i++) {
                System.out.println("["+(i+1)+"] " + menuArray[i]);
            }
            
            System.out.print("Enter choice: ");
            opt = Integer.parseInt(sc.nextLine());
            
            switch(opt){
            
                case 1:
                    
                    ArrayList<Entry> entryList = eoc.viewAllEntries();
                    
                    if (entryList != null) {
                        for(Entry i : entryList){
                            System.out.println("\n-----------");
                            System.out.println("Entry ID: " + i.getId());
                            System.out.println("Title: " + i.getTitle());
                            System.out.println("Content: " + i.getContent());
                            System.out.println("Post Time: " + i.getDatetime());
                            System.out.println("-------------\n");
                        }
                    }else{
                        System.out.println("\nNo Notes to display");
                    }
                    
                    break;
                    
                case 2:
                    
                    System.out.print("Enter post ID: ");
                    entryId = Integer.parseInt(sc.nextLine());
                    
                    e = eoc.viewSpecificEntry(entryId);
                    
                    if (e != null) {
                        System.out.println("\n-----------");
                        System.out.println("Entry ID: " + e.getId());
                        System.out.println("Title: " + e.getTitle());
                        System.out.println("Content: " + e.getContent());
                        System.out.println("Post Time: " + e.getDatetime());
                        System.out.println("-------------\n");
                    }
                    
                    break;
                    
                case 3:
                    
                    String title = "", content = "";
                    
                    System.out.print("Enter Note Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Content: ");
                    content = sc.nextLine();
                    
                    e = new Entry(title, content);
                    
                    System.out.println((eoc.addEntry(e))? "Entry successfully added!" : "Entry insert failed.");
                    
                    break;
                    
                case 4: 
                    
                    System.out.print("Enter entry ID to edit: ");
                    entryId = Integer.parseInt(sc.nextLine());
                    
                    e = eoc.viewSpecificEntry(entryId);
                    
                    if (e != null) {
                        System.out.print("Enter new title: ");
                        title = sc.nextLine();
                        
                        System.out.print("Enter new note content: ");
                        content = sc.nextLine();
                        
                        e = new Entry(title, content);
                        
                        System.out.println(
                                (eoc.editEntry(e, entryId)) ?
                                        "Note successfully edited" : 
                                        "Note edit failed"
                        );
                    }
                    
                    break;
                    
                case 5:
                    
                    System.out.print("Enter entry ID to delete: ");
                    entryId = Integer.parseInt(sc.nextLine());
                    
                    e = eoc.viewSpecificEntry(entryId);
                    
                    if (e != null && eoc.deleteEntry(entryId) == true) {
                        System.out.println("\nNote successfully deleted");
                    }
                    
                    break;
                    
                case 6:
                    
                    System.out.println("Goodbye, thank you.");
                    
                    break;
                    
                default:
                
                    System.out.println("Invalid input.");
            }
            
        } while(opt != 6);
        
        
    }
}
