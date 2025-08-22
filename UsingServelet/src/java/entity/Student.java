/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WADA
 */
public class Student {

    private int id;
    private String name;
    private String email;
    private String photo;
    private float fee;

    private GradeClass gradeClass;

    public Student() {
    }

    public Student(int id, String name, String email, String photo, float fee) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.fee = fee;
    }

    public Student(String name, String email, String photo, float fee) {
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.fee = fee;
    }

    public Student(String name, String email, String photo, float fee, GradeClass gradeClass) {
        this.name = name;
        this.email = email;
        this.photo = photo;
        this.fee = fee;
        this.gradeClass = gradeClass;
    }
    
    
    
    

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public GradeClass getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(GradeClass gradeClass) {
        this.gradeClass = gradeClass;
    }

}
