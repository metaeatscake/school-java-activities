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
public class Menu {
    
    private String[] menuOptions;
    private String choice;
    private String menuTitle;

    public Menu(String[] menuOptions) {
        this.menuOptions = menuOptions;
    }

    public String[] getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String[] menuOptions, String menuTitle) {
        this.menuOptions = menuOptions;
        this.menuTitle = menuTitle;
    }
    
    public String getMenuTitle(){
        return this.menuTitle;
    }
    
    public void setMenuTitle(String menuTitle){
        this.menuTitle = menuTitle;
    }
    
    public String getOption(int key){
        return this.menuOptions[key];
    }
    
    public int getMenuLength(){
        return menuOptions.length;
    }
    
}
