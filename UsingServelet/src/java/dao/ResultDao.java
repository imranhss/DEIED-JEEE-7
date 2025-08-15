/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import static dao.StudentDao.du;
import static dao.StudentDao.ps;
import static dao.StudentDao.sql;
import entity.Result;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DbUtil;

/**
 *
 * @author WADA
 */
public class ResultDao {
    
    static DbUtil du = new DbUtil();
    public static PreparedStatement ps;
    public static String sql;
    public static ResultSet rs;
    
    
    public static int saveResult(Result r) {

        int status = 0;

        sql = "insert into result(subjectName, mark, subjectCode, grade, studentId) values(?,?,?,?,?)";
        try {
            ps = du.getCon().prepareStatement(sql);
            
            ps.setString(1, r.getSubjectName());
            ps.setFloat(2, r.getMark());
            ps.setInt(3, r.getSubjectCode());
            ps.setString(4, r.getGrade());
            ps.setInt(5, r.getStudentId());
            
            status  = ps.executeUpdate();
 

        } catch (SQLException ex) {
            Logger.getLogger(ResultDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }
    
    
    
}
