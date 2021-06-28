/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods1;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author bigjo (Ian De Guzman)
 */
public class Methods1 {

    /**
     * @param args the command line arguments
     */
    
    private static double num1;
    private static double num2;
    
    private static void showMenu(){
        System.out.println("[1] Perimeter of a rectangle");
        System.out.println("[2] Factorial of a number");
        System.out.println("[3] Area of a triangle");
        System.out.println("[4] Exit");
    }
    
    private static void perimeter(){
        System.out.println("\nPerimeter: "+((2*num1)+(2*num2)));
    }
    
    private static double factorial(){
        double result = 1;
        
        for (int i = 1; i <= num1; i++) {
            result *= i;
        }
        
        return result;
    }
    
    private static void area(double base, double height){
        System.out.println("Area = "+ ( (base*height)/2 ) );
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
                            System.out.print("Enter value for length: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for width: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            perimeter();
                            val1 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a real number, please try again.");
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
                            System.out.print("Enter value for factorial: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            
                            System.out.println("\nFactorial: "+factorial());
                            val2 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a real number, please try again.");
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
                            System.out.print("Enter value for base: ");
                            num1 = Integer.parseInt(sc.nextLine());
                            System.out.print("Enter value for height: ");
                            num2 = Integer.parseInt(sc.nextLine());
                            
                            area(num1, num2);
                            val3 = true;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\nInput is not a real number, please try again.");
                        }
                        catch(InputMismatchException e){
                            System.out.println("\nInput is not a number. please try again.");
                        }
                    }
                break;
                
                case 4:
                    System.out.println("\nGoodbye");
                break;
                
                default: System.out.println("\nNumber given is not a valid choice, try again.");
            }
        }while(choice != 4);
        
    }
    
}
