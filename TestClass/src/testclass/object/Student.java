
package testclass.object;


public class Student {
    
    public  int id;
    public String name; 
    public String address;
    public String email;
    public String cell;
    public String fatherName;
    public String motherName;
    public String department;

    public Student() {
    }

    public Student(int MyId, String name, String address, String email, String cell, String fatherName, String motherName, String department) {
        this.id = MyId;
        this.name = name;
        this.address = address;
        this.email = email;
        this.cell = cell;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.department = department;
    }
    
    
    
    public  void printStuInfo(){
    
        System.out.println("My name is "+ name +" and ID is "+id );
    }
    
    
    
}
