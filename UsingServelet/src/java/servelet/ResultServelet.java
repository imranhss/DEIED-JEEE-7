/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servelet;

import dao.ResultDao;
import dao.StudentDao;
import entity.Result;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;

/**
 *
 * @author WADA
 */

@WebServlet("/resultServelet")
public class ResultServelet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {
                
                
                Student s = new Student();
                s.setId(Integer.parseInt(req.getParameter("studentId")));
                
                
                Result r= new Result();
                
                r.setGrade(req.getParameter("grade"));
                r.setSubjectCode(Integer.parseInt(req.getParameter("subjectCode")));

                r.setSubjectName(req.getParameter("subjectName"));
                r.setMark(Float.parseFloat(req.getParameter("mark")));
                
                r.setStudent(s);
                
                

                ResultDao.saveResult(r);
                resp.sendRedirect("index.jsp");

            } else if ("update".equals(action)) {
                

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
    
    
    
    
}
