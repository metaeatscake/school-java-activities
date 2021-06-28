/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package humanresourcesystem;

/**
 *
 * @author bigjo
 */
public class Employee {
    
    private int employeeId;
    private String employeeName;
    private String employeeEmail;
    private double basicSalary;

    public Employee() {
        this.employeeId = 0;
        this.employeeName = "";
        this.employeeEmail = "";
        this.basicSalary = 0.0;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
    
    public void displayEmployeeInfo(){
        System.out.println("\nEmployee ID: " + this.employeeId);
        System.out.println("Employee Name: " + this.employeeName);
        System.out.println("Employee Email: " + this.employeeEmail);
        System.out.println("Employee Basic Salary: " + this.basicSalary);
    }
    
    public double computeGrossSalary(int hrsWorked){
        return this.basicSalary * hrsWorked;
    }
    
    
}
