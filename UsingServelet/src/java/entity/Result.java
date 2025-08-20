/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author WADA
 */
public class Result {
    
    private int id; 
    private String subjectName;
    private float mark;
    private int subjectCode;
    private String grade;
//    private int studentId;
    private Student student;

    public Result() {
    }

    public Result(int id, String subjectName, float mark, int subjectCode, String grade, Student student) {
        this.id = id;
        this.subjectName = subjectName;
        this.mark = mark;
        this.subjectCode = subjectCode;
        this.grade = grade;
        this.student = student;
    }

    public Result(int id, String subjectName, float mark, int subjectCode, String grade) {
        this.id = id;
        this.subjectName = subjectName;
        this.mark = mark;
        this.subjectCode = subjectCode;
        this.grade = grade;
    }

    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(int subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Result{" + "id=" + id + ", subjectName=" + subjectName + ", mark=" + mark + ", subjectCode=" + subjectCode + ", grade=" + grade + ", student=" + student + '}';
    }

    
    

    
    
    
    
    
}
