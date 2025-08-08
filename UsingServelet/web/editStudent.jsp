<%@include file="header.jsp" %>
<%@page import="entity.Student" %>

<%
    Student s = (Student) request.getAttribute("student");
%>

<div class="container">
    <form method="post" action="studentservlet" enctype="multipart/form-data">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="id" value="<%=s.getId()%>">

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input value="<%=s.getName()%>" type="text" class="form-control" id="name" name="name" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input value="<%=s.getEmail()%>" type="email" class="form-control" id="email" name="email" required>
        </div>

        <div class="mb-3">
            <label for="fee" class="form-label">Fee</label>
            <input value="<%=s.getFee()%>" type="text" class="form-control" id="fee" name="fee" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Current Photo</label><br>
            <% if (s.getPhoto() != null && !s.getPhoto().isEmpty()) { %>
                <img src="<%=s.getPhoto()%>" width="120" height="120" style="border:1px solid #ccc;" />
            <% } else { %>
                <p>No photo uploaded.</p>
            <% } %>
        </div>

        <div class="mb-3">
            <label for="photo" class="form-label">Change Photo (optional)</label>
            <input type="file" class="form-control" id="photo" name="photo" accept="image/*">
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>

<%@include file="footer.jsp" %>
