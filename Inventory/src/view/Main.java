/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ItemController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Item;

/**
 *
 * @author bigjo
 */
public class Main {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        ItemController ic = new ItemController();
        Item item = null;
        int itemId = -1;
        boolean querySuccess = false;
        
        int opt = 0;
        
        do{
        
            String[] menuArray = new String[]{
              "View all items",
              "View specific item",
              "Add Item",
              "Edit Item",
              "Delete Item",
              "Exit"
            };
            
            for (int i = 0; i < menuArray.length; i++) {
                System.out.println("["+(i+1)+"] " + menuArray[i]);
            }
            
            System.out.print("Enter choice: ");
            opt = Integer.parseInt(sc.nextLine());
            
            switch(opt){
            
                case 1:
                    
                    System.out.println("Chosen Option: " +menuArray[opt-1]);
                    
                    ArrayList<Item> itemList = ic.viewAllItems();
                    
                    if (itemList.isEmpty()) {
                        System.out.println("\nNo items to display.\n");
                        break;
                    }
                    
                    for(Item i : itemList){
                        System.out.println("\n-----------");
                        System.out.println("Item ID: " + i.getId());
                        System.out.println("Name: " + i.getName());
                        System.out.println("Quantity: " + i.getQty());
                        System.out.println("Price: " + i.getPrice());
                        System.out.println("-------------\n");
                    }
                    
                    break;
                    
                case 2:
                    
                    System.out.println("Chosen Option: " +menuArray[opt-1]);
                    
                    System.out.print("Enter item ID: ");
                    itemId = Integer.parseInt(sc.nextLine());
                    
                    item = ic.viewItemById(itemId);
                    
                    if (item != null) {
                        System.out.println("\n-----------");
                        System.out.println("Item ID: " + item.getId());
                        System.out.println("Name: " + item.getName());
                        System.out.println("Quantity: " + item.getQty());
                        System.out.println("Price: " + item.getPrice());
                        System.out.println("-------------\n");
                    }
                    
                    break;
                    
                case 3:
                    
                    String name = "";
                    int qty = 0;
                    double price = 0.0;
                    
                    System.out.println("Chosen Option: " +menuArray[opt-1]);
                    
                    System.out.print("Enter name: ");
                    name = sc.nextLine();
                    
                    boolean tableNoData = (ic.viewAllItems().isEmpty());
                    
                    if (tableNoData) {
                        System.out.println("\nThis table has no data\n");
                        break;
                    }
                    
                    boolean itemAlreadyExists = (ic.getCountByName(name) != 0);
                    
                    if (itemAlreadyExists) {
                        System.out.println("\nThis item already exists\n");
                        break;                      
                    }
                    
                    else{
                        System.out.print("Enter quantity: ");
                        qty = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter price: ");
                        price = Double.parseDouble(sc.nextLine());

                        item = new Item(name, qty, price);

                        querySuccess = ic.addItem(item);

                        System.out.println((querySuccess)? "\nItem successfully added\n":"\nItem input failed\n");
                    }
                    
                    break;
                    
                case 4: 
                    
                    System.out.println("Chosen Option: " +menuArray[opt-1]);
                    
                    System.out.print("Enter item ID to edit: ");
                    itemId = Integer.parseInt(sc.nextLine());
                    
                    if (ic.viewItemById(itemId) == null) {
                        break;
                    }
                    
                    String newName = "";
                    int newQty = 0;
                    double newPrice = 0.0;
                    
                    System.out.print("Enter new item name: ");
                    newName = sc.nextLine();
                    System.out.print("Enter new item quantity: ");
                    newQty = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter new item price: ");
                    newPrice = Double.parseDouble(sc.nextLine());
                    
                    item = new Item(newName, newQty, newPrice);
                    
                    boolean success = ic.editItem(item, itemId);
                    
                    System.out.println((success)? "\nItem Successfully Edited\n": "\nItem edit failed\n");
                    
                    break;
                    
                case 5:
                    
                    System.out.println("Chosen Option: " +menuArray[opt-1]);
                    
                    System.out.print("Enter item id to delete: ");
                    itemId = Integer.parseInt(sc.nextLine());
                    
                    if (ic.viewItemById(itemId) == null) {
                        break;
                    }
                    
                    success = ic.deleteItem(itemId);
                    System.out.println((success)? "\nItem successfully deleted\n" : "\nDelete failed\n");
                    break;
                    
                case 6:
                    
                    System.out.println("Goodbye, thank you.");
                    
                    break;
                    
                default:
                
                    System.out.println("\nInvalid input.\n");
            }
            
        } while(opt != 6);
        
        
    }
}
