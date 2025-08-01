<%@page  import="dao.StudentDao" %>
<jsp:useBean class="entity.Student" id="s" ></jsp:useBean>
<jsp:setProperty name="s" property="*" />

<% 
    int result= StudentDao.updateStudent(s);
    
if(result > 0){
    
       response.sendRedirect("showallsrtudent.jsp");
    }
    else{
   response.sendRedirect("editFrom.jsp");
    
    }

%>
