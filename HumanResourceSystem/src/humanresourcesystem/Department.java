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
public class Department {
    
    private int departmentId;
    private String departmentName;
    private String departmentDesc;
    
    public Department(){
        this.departmentId = 0;
        this.departmentName = "";
        this.departmentDesc = "";
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentDesc() {
        return departmentDesc;
    }

    public void setDepartmentDesc(String departmentDesc) {
        this.departmentDesc = departmentDesc;
    }
    
    
}
