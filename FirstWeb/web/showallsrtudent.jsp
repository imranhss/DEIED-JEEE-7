<%@page  import="dao.StudentDao" %>
<%@page  import="entity.Student" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*"%>

<% 
    List<Student> list= StudentDao.showAllStudent();
    
    request.setAttribute("list", list);
%>

<h1>All Students</h1>

<table border="1">
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
                <td></td>
                
            </tr>
        </c:forEach>
        
    </tbody>
    
    
</table>



