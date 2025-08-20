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
//@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
//        maxFileSize = 1024 * 1024 * 10, // 10MB
//        maxRequestSize = 1024 * 1024 * 50)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50
)
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
                String fileName = extractCustomFileName(filePart, s);

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
                String fileName = extractCustomFileName(filePart, s);

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

    // Method to generate a custom filename using student name and current time, keeping original file extension
    private String extractCustomFileName(Part part, Student student) {

        // Get the value of the "content-disposition" header from the uploaded part
        // This header typically looks like: form-data; name="photo"; filename="example.jpg"
        String contentDisp = part.getHeader("content-disposition");

        // Initialize a variable to hold the original filename from the header
        String originalFileName = "";

        // Split the header into parts using semicolon as delimiter
        // Each part may contain information like name or filename
        for (String partValue : contentDisp.split(";")) {

            // Trim whitespace from the part and check if it starts with "filename"
            // This indicates that this part contains the uploaded file's name
            if (partValue.trim().startsWith("filename")) {

                // Extract the filename value from the string
                // partValue.indexOf('=') gets the index of the '=' character
                // +2 skips the '=' and the opening quote (")
                // partValue.length() - 1 skips the closing quote (")
                originalFileName = partValue.substring(partValue.indexOf('=') + 2, partValue.length() - 1);

                // Exit the loop once the filename is found
                break;
            }
        }

        // Initialize a variable to store the file extension (e.g., ".jpg", ".png")
        String extension = "";

        // Find the position of the last dot in the filename to get the extension
        int dotIndex = originalFileName.lastIndexOf(".");

        // If a dot exists and is not at the start or end, extract the extension
        if (dotIndex > 0) {
            extension = originalFileName.substring(dotIndex);  // includes the dot (e.g., ".jpg")
        }

        // Get the student name and remove all non-alphanumeric characters to make it safe for a filename
        // For example, "John Doe!" becomes "JohnDoe"
        String safeName = student.getName().trim().replaceAll("[^a-zA-Z0-9]", "");

        // Generate the current time in milliseconds (used to make filename unique)
        // This helps avoid overwriting files with the same name
        long currentMilliSecond = System.currentTimeMillis();

        // Combine the sanitized student name, the current time, and the original file extension
        // For example: "JohnDoe_1723559694321.jpg"
        String customFileName = safeName + "_" + currentMilliSecond + extension;

        // Return the newly generated unique filename
        return customFileName;
    }

}
