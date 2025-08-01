<%@include file="header.jsp" %>

<%@page import="entity.Student" %>
<%@page import="dao.StudentDao" %>


<%
    String id=request.getParameter("id");    
    Student s=StudentDao.getStudentById(Integer.parseInt(id));
%>

<div class="container">
            <form method="post" action="edit.jsp">
                <input  type="hidden"  value="<%=s.getId()%>" name="id"> 
                
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Name</label>
                    <input value="<%=s.getName()%>" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"  name ="name">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input value="<%=s.getEmail()%>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Fee</label>
                    <input value="<%=s.getFee()%>" type="text" class="form-control" id="exampleInputPassword1" name="fee">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>





<%@include file="footer.jsp" %>