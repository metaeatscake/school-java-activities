/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MenuController;
import controller.StudentController;
import controller.TeacherController;
import java.util.ArrayList;
import java.util.Scanner;
import model.Menu;
import model.Student;
import model.Teacher;

/**
 *
 * @author bigjo (Baz Ian Gil De Guzman)
 */
public class Main {
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        TeacherController tcon = new TeacherController();
        StudentController scon = new StudentController();

        Menu m1 = new Menu(new String[]{
            "Login",
            "Register",
            "Exit"
        });
        m1.setMenuTitle("Student Record System Login/Register Menu");
        MenuController cm1 = new MenuController(m1);
       
        
        do{
            Teacher tch = new Teacher();
            
            cm1.printMenu();
            cm1.setChoice(sc.nextLine().trim());
            
            switch(cm1.getChoice()){
                
                case "1":
                    
                    cm1.printOption();
                    
                    System.out.print("\nUsername: ");
                    tch.setUsername(sc.nextLine());
                    System.out.print("Password: ");
                    tch.setPassword(sc.nextLine());
                    
                    if (!tcon.verifyLogin(tch)) {
                        System.out.println("\nInvalid Username/Password, Login denied.");
                        break;
                    }
                    
                    tch = tcon.getAccountData(tch.getUsername());
                    System.out.println("\nLogin Success! Welcome " + tch.getName() + "!");
                    
                    Menu m2 = new Menu(new String[]{
                        "View students",
                        "Search a student",
                        "Add a student",
                        "Edit a student",
                        "Remove a student",
                        "Logout"
                    });
                    m2.setMenuTitle("Student Record System Main Dashboard");
                    MenuController cm2 = new MenuController(m2);
                    
                    do{
                        
                        Student std = new Student();
                        Student tempStd = new Student();
                        ArrayList<Student> stdArr = new ArrayList<>();
                        
                        cm2.printMenu();
                        cm2.setChoice(sc.nextLine().trim());
                        
                        switch(cm2.getChoice()){
                            
                            case "1":
                                
                                cm2.printOption();
                                stdArr = scon.viewAll(tch.getId());
                                
                                if (stdArr.isEmpty()) {
                                    System.out.println("\nNo registered Students found.");
                                    break;
                                }
                                
                                for(Student st : stdArr){
                                    scon.printStudent(st);
                                }
                                
                                break;
                                
                            case "2":
                                
                                cm2.printOption();
                                System.out.print("\nEnter student ID: ");
                                std.setStudentId(sc.nextLine().trim());
                                
                                if (!scon.checkStudentId(std.getStudentId(), tch.getId())) {
                                    System.out.println("\nThis Student ID is not handled by this teacher, or may not exist.");
                                    break;
                                }
                                
                                scon.printStudent(scon.view(std.getStudentId()));
                                
                                break;
                                
                            case "3":
                                
                                cm2.printOption();
                                System.out.print("\nEnter student ID: ");
                                std.setStudentId(sc.nextLine().trim());
                                
                                if (scon.checkStudentId(std.getStudentId())) {
                                    System.out.println("\nThis student ID is already registered");
                                    break;
                                }
                                
                                System.out.print("Enter student name: ");
                                std.setName(sc.nextLine().trim());
                                
                                System.out.print("Enter grade: ");
                                std.setGrade(Double.parseDouble(sc.nextLine().trim()));
                                
                                System.out.println(
                                        (scon.add(std, tch.getId())) ? 
                                                "\nStudent successfully registered!~":
                                                "\nStudent registration failed."
                                );
                                
                                break;
                                
                            case "4":
                                
                                cm2.printOption();
                                System.out.print("\nEnter student ID: ");
                                std.setStudentId(sc.nextLine().trim());
                                
                                if (!scon.checkStudentId(std.getStudentId(), tch.getId())) {
                                    System.out.println("\nThis Student ID is not handled by this teacher, or may not exist.");
                                    break;
                                }
                                
                                tempStd = scon.view(std.getStudentId());
                                scon.printStudent(tempStd);
                                
                                System.out.print("\nEnter new Student ID: ");
                                std.setStudentId(sc.nextLine().trim());
                                System.out.print("Enter new student name: ");
                                std.setName(sc.nextLine().trim());
                                System.out.print("Enter new grade: ");
                                std.setGrade(Double.parseDouble(sc.nextLine().trim()));
                                
                                System.out.println(
                                        (scon.edit(tempStd, std)) ?
                                                "\nStudent successfully edited!":
                                                "\nStudent edit failed."
                                );
                                
                                break;
                                
                            case "5":
                                
                                cm2.printOption();
                                System.out.print("\nEnter student ID: ");
                                std.setStudentId(sc.nextLine().trim());
                                
                                if (!scon.checkStudentId(std.getStudentId(), tch.getId())) {
                                    System.out.println("\nThis Student ID is not handled by this teacher, or may not exist.");
                                    break;
                                }
                                
                                System.out.println(
                                        (scon.delete(std.getStudentId())) ? 
                                                "\nStudent successfully deleted":
                                                "\nStudent deletion failed"
                                );
                                
                                break;
                                
                            case "6":
                                
                                System.out.println("\nGoodbye");
                                
                                break;
                                
                            default:
                                
                                System.out.println("\nInvalid input.");
                                
                                break;
                        }
                        
                    }while(!cm2.getChoice().equals( Integer.toString( m2.getMenuLength() ) ) );
                    
                    break;
                
                case "2":
                    
                    cm1.printOption();
                    
                    System.out.print("\nEnter your name: ");
                    tch.setName(sc.nextLine().trim());
                    
                    System.out.print("Enter your username: ");
                    tch.setUsername(sc.nextLine().trim());
                    
                    if(!tcon.verifyUsername(tch.getUsername())){
                        System.out.println("\nThis user already exists, please register a new username");
                        break;
                    }
                    
                    System.out.print("Enter your password: ");
                    tch.setPassword(sc.nextLine().trim());
                    
                    System.out.println(
                            (tcon.add(tch)) ?
                                    "\nTeacher successfully registered":
                                    "\nSomething went wrong with the registration"
                    );
                    
                    break;
                
                case "3":
                    
                    System.out.println("\nGoodbye");
                    break;
                    
                default:
                    
                    System.out.println("\nInvalid Input, please try again.");
                    break;
            }
        } while(!cm1.getChoice().equals( Integer.toString( m1.getMenuLength() ) ) );
        
    }
}
