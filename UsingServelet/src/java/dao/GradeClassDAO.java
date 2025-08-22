/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.GradeClass;
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
public class GradeClassDAO {

    static DbUtil du = new DbUtil();
    public static PreparedStatement ps;
    public static String sql;
    public static ResultSet rs;

    public static List<GradeClass> getAllClasses() {
        List<GradeClass> classList = new ArrayList<>();
        String query = "SELECT * FROM grade_class"; // Assuming table name is grade_class

        try {
            ps = du.getCon().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                GradeClass gc = new GradeClass();
                gc.setId(rs.getInt("id"));
                gc.setName(rs.getString("name"));
                classList.add(gc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return classList;
    }

    // Save a new GradeClass
    public static int saveGradeClass(GradeClass gradeClass) {
        int status = 0;
        String sql = "INSERT INTO grade_class (name) VALUES (?)";
        try {
            ps = du.getCon().prepareStatement(sql);
            ps.setString(1, gradeClass.getName());
            int rowsInserted = ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(GradeClassDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return status;
    }

}
