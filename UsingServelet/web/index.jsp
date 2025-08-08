<%@include file="header.jsp" %>
<%@page import="dao.StudentDao" %>
<%@page import="entity.Student" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>

<%
    List<Student> list = StudentDao.showAllStudent();
    request.setAttribute("list", list);
%>

<div class="container">
    <h1 class="text-center">All Students</h1>

    <table class="table table-striped table-bordered">
        <thead>
            <tr>
                <th>ID</th>
                
                <th>Name</th>
                <th>Email</th>
                <th>Fee</th>
                <th>Photo</th> <!-- New column -->
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="s" items="${list}">
                <tr>
                    <td>${s.id}</td>
                    
                    <!-- Show the image if it exists -->
                    

                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.fee}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty s.photo}">
                                <img src="${s.photo}" width="80" height="80" style="object-fit: cover; border: 1px solid #ddd; border-radius: 5px;" />
                            </c:when>
                            <c:otherwise>
                                <span>No photo</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
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
