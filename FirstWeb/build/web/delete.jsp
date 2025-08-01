<%@page  import="dao.StudentDao" %>
<jsp:useBean class="entity.Student" id="s" ></jsp:useBean>
<jsp:setProperty name="s" property="*" />

<% 
    int result= StudentDao.deleteStudent(s.getId());
    
if(result > 0){
    
       response.sendRedirect("showallsrtudent.jsp");
    }
    else{
   response.sendRedirect("error.jsp");
    
    }

%>
