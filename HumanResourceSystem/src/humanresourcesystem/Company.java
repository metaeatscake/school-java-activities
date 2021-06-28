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
public class Company {

    /**
     * @param args the command line arguments
     */
    
    private String companyName;
    private String companyLocation;
    
    public Company(){
        this.companyName = "";
        this.companyLocation = "";
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }
    
    public static void main(String[] args) {
        
        Department d1 = new Department();
        Employee e1 = new Employee();
        Company c1 = new Company();
        
        // Company Code
        c1.setCompanyName("Pomhub");
        c1.setCompanyLocation("New Mexico, Germany");
        
        System.out.println("Company Name: " + c1.getCompanyName());
        System.out.println("Company Location: " + c1.getCompanyLocation());
        
        // Department Code
        d1.setDepartmentId(12);
        d1.setDepartmentDesc("Department of Food and Drug Administration");
        d1.setDepartmentName("DFDA");
        
        System.out.println("Department ID: " + d1.getDepartmentId());
        System.out.println("Department Name: " + d1.getDepartmentName());
        System.out.println("Department Description: " + d1.getDepartmentDesc());
        
        // Employee Code
        e1.setEmployeeId(22);
        e1.setEmployeeName("Jonny Seens");
        e1.setEmployeeEmail("Seens@gamerMail.com");
        e1.setBasicSalary(69420);
        
        e1.displayEmployeeInfo();
        System.out.println("Gross Salary: " + e1.computeGrossSalary(100));
        
    }
    
}
