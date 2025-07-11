/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testsupperandsubclass.geomatry;

/**
 *
 * @author WADA
 */
public class Student extends Person{
    
    private int studentId;
    private String department;
    private String address;

    public Student() {
    }

    public Student(int studentId, String department, String address) {
        this.studentId = studentId;
        this.department = department;
        this.address = address;
    }

    public Student(int studentId, String department, String address, int id, String name, String email) {
        super(id, name, email);
        this.studentId = studentId;
        this.department = department;
        this.address = address;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
       
        String result= "Name "+ super.getName()+ " Email "+ super.getEmail()+" Department "+ department+ " Address "+ address;
        
      return result;
    }

    
    
    

    
    
    
    

}
