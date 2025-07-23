<%@page  import="dao.StudentDao" %>
<jsp:useBean class="entity.Student" id="s" ></jsp:useBean>
<jsp:setProperty name="s" property="*" />

<% 
    int result= StudentDao.saveStudent(s);
    
if(result > 0){
    
       response.sendRedirect("home.jsp");
    }
    else{
   response.sendRedirect("addStudentForm.jsp");
    
    }

%>
