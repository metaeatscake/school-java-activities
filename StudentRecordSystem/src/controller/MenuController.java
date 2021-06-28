/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Menu;

/**
 *
 * @author bigjo
 */
public class MenuController {
    
    private Menu m;
    private String choice;
    
    public MenuController(Menu m){
        this.m = m;
    }
    
    public void printMenu(){
        System.out.println("\n"+m.getMenuTitle());
        for (int i = 0; i < m.getMenuLength(); i++) {
            System.out.println("["+(i+1)+"] " + m.getOption(i));
        }
        System.out.print("Enter choice: ");
    }
    
    public void printOption(){
        System.out.println("Selected Option: " + m.getOption(Integer.parseInt(this.choice) -1) );
    }
    
    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }
    
}
