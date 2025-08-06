<%@include file="header.jsp" %>
<%@page  import="dao.StudentDao" %>
<%@page  import="entity.Student" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>

<% 
    List<Student> list= StudentDao.showAllStudent();
    
    request.setAttribute("list", list);
%>


<div class="container">
    <h1 class="text-center">All Students</h1>

    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Fee</th>
                <th>Action</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="s" items="${list}">
                <tr>
                    <td>${s.getId()}</td>
                    <td>${s.getName()}</td>
                    <td>${s.getEmail()}</td>
                    <td>${s.getFee()}</td>
                    <td>
                        <a href="studentservlet?action=edit&id=${s.id}" class="btn btn-warning">Edit</a>
                        <a href="studentservlet?action=delete&id=${s.id}" class="btn btn-danger">Delete</a>
                        
                    </td>

                </tr>
            </c:forEach>        
        </tbody>


    </table>
</div>


<%@include  file="footer.jsp" %>
