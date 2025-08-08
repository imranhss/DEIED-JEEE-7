/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servelet;

import dao.StudentDao;
import entity.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
@WebServlet("/studentservlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class StudentServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        try {
            if ("add".equals(action)) {
                Student s = new Student();
                s.setName(req.getParameter("name"));
                s.setEmail(req.getParameter("email"));
                s.setFee(Float.parseFloat(req.getParameter("fee")));

                // Get the uploaded photo
                Part filePart = req.getPart("photo");
                String fileName = extractFileName(filePart);

                // Save the file to a directory
                String savePath = getServletContext().getRealPath("/") + "images";
                filePart.write(savePath + "/" + fileName);

                s.setPhoto("images/" + fileName);  // Save path in DB

                StudentDao.saveStudent(s);
                resp.sendRedirect("index.jsp");

            } else if ("update".equals(action)) {
                Student s = new Student();
                s.setId(Integer.parseInt(req.getParameter("id")));
                s.setName(req.getParameter("name"));
                s.setEmail(req.getParameter("email"));
                s.setFee(Float.parseFloat(req.getParameter("fee")));

                // Get new photo if uploaded
                Part filePart = req.getPart("photo");
                String fileName = extractFileName(filePart);

                if (fileName != null && !fileName.isEmpty()) {
                    String savePath = getServletContext().getRealPath("/") + "images";
                    filePart.write(savePath + "/" + fileName);
                    s.setPhoto("images/" + fileName);
                } else {
                    // Keep old photo if none uploaded
                    Student old = StudentDao.getStudentById(s.getId());
                    s.setPhoto(old.getPhoto());
                }

                StudentDao.updateStudent(s);
                resp.sendRedirect("index.jsp");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        try {

            if ("delete".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                StudentDao.deleteStudent(id);
                resp.sendRedirect("index.jsp");
            } else if ("edit".equals(action)) {
                int id = Integer.parseInt(req.getParameter("id"));
                Student s = StudentDao.getStudentById(id);

                req.setAttribute("student", s);
                req.getRequestDispatcher("editStudent.jsp").forward(req, resp);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }

}
