/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author bigjo (Ian De Guzman)
 */
public class Methods {

    /**
     * @param args the command line arguments
     */
    
    private static double num1;
    private static double num2;
    
    private static void showMenu(){
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");
        System.out.println("[5] Exit");
    }
    
    private static void add(){
        System.out.println("Sum = "+ (num1+num2));
    }
    
    private static double subtract(){
        return num1-num2;
    }
    
    private static void multiply(double num1, double num2){
        System.out.println("Product = "+ (num1*num2));
    }
    
    private static double divide(double num1, double num2){
        return num1/num2;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        
        do{
            
            boolean valid = false;
            while(!valid){
                try{
                    showMenu();
                    System.out.print("\nEnter choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    valid = true;
                }
                catch(NumberFormatException e){
                    System.out.println("\nInput is not a whole number, please try again.");
                }
                catch(InputMismatchException e){
                    System.out.println("\nInput is not a number. please try again.");
                }
            }
            
            switch(choice){
                
                case 1:
                    boolean val1 = false;
                    
                    while(!val1){
                        try{
                            System.out.print("Enter value for num1: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for num2: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            add();
                            val1 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a whole number, please try again.");
                        }
                        catch(InputMismatchException e){
                            System.out.println("\nInput is not a number. please try again.");
                        }
                    }
                break;
                
                case 2:
                    boolean val2 = false;
                    
                    while(!val2){
                        try{
                            System.out.print("Enter value for num1: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for num2: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            System.out.println("The difference is: "+subtract());
                            val2 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a whole number, please try again.");
                        }
                        catch(InputMismatchException e){
                            System.out.println("\nInput is not a number. please try again.");
                        }
                    }
                break;
                
                case 3:
                    boolean val3 = false;
                    
                    while(!val3){
                        try{
                            System.out.print("Enter value for num1: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for num2: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            multiply(num1, num2);
                            val3 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a whole number, please try again.");
                        }
                        catch(InputMismatchException e){
                            System.out.println("\nInput is not a number. please try again.");
                        }
                    }
                break;
                
                case 4:
                    boolean val4 = false;
                    
                    while(!val4){
                        try{
                            System.out.print("Enter value for num1: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for num2: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            System.out.println("The quotient is: "+divide(num1, num2));
                            val4 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a whole number, please try again.");
                        }
                        catch(InputMismatchException e){
                            System.out.println("\nInput is not a number. please try again.");
                        }
                    }
                break;
                
                case 5:
                    System.out.println("\nGoodbye");
                break;
                
                default: System.out.println("\nInvalid input, try again.");
            }
        }while(choice != 5);
        
    }
    
}
