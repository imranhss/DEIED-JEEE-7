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
import java.util.ArrayList;
import java.util.List;
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
            ps.setInt(5, r.getStudent().getId());

            status = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ResultDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

    public static List<Result> getAllResult() {
        List<Result> resultList = new ArrayList<>();

        sql = "select r.id, s.name, r.subjectName, r.mark, r.subjectCode, r.grade from result r join student s on s.id= r.studentId";

        try {
            ps = du.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setName(rs.getString("name"));

                Result result = new Result();
                result.setId(rs.getInt("id"));
                result.setGrade(rs.getString("grade"));
                result.setSubjectName(rs.getString("subjectName"));
                result.setMark(rs.getFloat("mark"));
                result.setSubjectCode(rs.getInt("subjectCode"));
                result.setStudent(s);

                resultList.add(result);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ResultDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(resultList);
        
        return resultList;
    }
    
    
    

}
