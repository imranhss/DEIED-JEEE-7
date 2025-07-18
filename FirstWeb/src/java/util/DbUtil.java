/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author WADA
 */
public class DbUtil {
    
    private Connection connection=null;
    private String url="jdbc:mysql://localhost:3306/jee";
    private String user="root";
    private String password="1234";    
    private String driver="com.mysql.cj.jdbc.Driver";
    
    
    public  Connection getCon(){
    
        try {
            connection=DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(DbUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection ;
    
    }
    
}
