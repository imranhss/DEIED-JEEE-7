/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.StudentDao.du;
import static dao.StudentDao.ps;
import static dao.StudentDao.rs;
import static dao.StudentDao.sql;
import entity.Student;
import entity.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

/**
 *
 * @author WADA
 */
public class TeacherDao {

    static DbUtil du = new DbUtil();
    public static PreparedStatement ps;
    public static String sql;
    public static ResultSet rs;
    
    
     // For Save 
    public static int saveTeacher(Teacher t) {

        int status = 0;

        sql = "insert into teacher(name, email, gender, department) values(?,?,?)";
        try {
            ps = du.getCon().prepareStatement(sql);

            ps.setString(1, t.getName());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getGender());
            ps.setString(4, t.getDepartment());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    // For show all Data 
    public static List<Teacher> showAllStudent() {
        List<Teacher> teacherList = new ArrayList<>();
        sql = "select * from teacher";

        try {
            ps = du.getCon().prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                Teacher s = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("department")
                        
                );
                teacherList.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return teacherList;
    }

    public static int deleteTeacher(int id) {

        int status = 0;
        sql = "delete from teacher where id = ?";

        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static Teacher getTeacherById(int id) {
        Teacher t = new Teacher();
        sql = "select * from teacher  where id=?";

        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                t = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("gender"),
                        rs.getString("department")
                       
                );
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    
    
    public  static  int updateTeacher(Teacher t){
        int status=0;
        
        sql="update student set name =?, email =?, gender= ?, department=? where id=?"; 
        
        try {
            ps=du.getCon().prepareStatement(sql);
            
            ps.setString(1, t.getName());
            ps.setString(2, t.getEmail());
            ps.setString(3, t.getGender());
            ps.setString(4, t.getDepartment());
            ps.setInt(5, t.getId());

            status = ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

}
