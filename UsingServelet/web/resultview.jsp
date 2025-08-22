<%@include file="header.jsp" %>
<%@page import="dao.ResultDao" %>
<%@page import="entity.Result" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>

<%
    List<Result> list = ResultDao.getAllResult();
    request.setAttribute("apple", list);
%>


<div class="container">
    <h1 class="text-center">All Result</h1>

    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                
                <th>Name</th>
                <th>Subject</th>
                <th>Subject Code</th>
                <th>Mark</th>
                <th>Grade</th> <!-- New column -->
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="r" items="${apple}">
                <tr>
                    <td>${r.id}</td>
                    
                    <!-- Show the image if it exists -->
                    

                    <td>${r.student.name}</td>
                    <td>${r.subjectName}</td>
                    <td>${r.subjectCode}</td>
                    <td>${r.mark}</td>
                    <td>${r.grade}</td>
                    
                    <td>
                        <a href="studentservlet?action=edit&id=${s.id}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="studentservlet?action=delete&id=${s.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this student?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<%@include file="footer.jsp" %>



