/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.html.HTML;
import util.DbUtil;

/**
 *
 * @author WADA
 */
public class StudentDao {

    static DbUtil du = new DbUtil();
    public static PreparedStatement ps;
    public static String sql;
    public static ResultSet rs;

    // For Save 
    public static int saveStudent(Student s) {

        int status = 0;

        sql = "insert into student(name, email, fee) values(?,?,?)";
        try {
            ps = du.getCon().prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setFloat(3, s.getFee());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    // For show all Data 
    public static List<Student> showAllStudent() {
        List<Student> stuList = new ArrayList<>();
        sql = "select * from student";

        try {
            ps = du.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getFloat("fee")
                );
                stuList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stuList;
    }

    public static int deleteStudent(int id) {

        int status = 0;
        sql = "delete from student where id = ?";

        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static Student getStudentById(int id) {
        Student s = new Student();
        sql = "select * from student  where id=?";

        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getFloat("fee")
                );

            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    
    public  static  int updateStudent(Student s){
        int status=0;
        
        sql="update student set name =?, email =?, fee= ? where id=?"; 
        
        try {
            ps=du.getCon().prepareStatement(sql);
            
            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setFloat(3, s.getFee());
            ps.setInt(4, s.getId());

            status = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
