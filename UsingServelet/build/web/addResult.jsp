<%@include file="header.jsp" %>

<div class="container">
    <!-- Make sure to set enctype for file upload -->
    <form method="post" action="resultServelet" >
        <input type="hidden" name="action" value="add">

        <div class="mb-3">
            <label for="name" class="form-label">Subject Name</label>
            <input name="subjectName" type="text" class="form-control" id="name" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Subject Code</label>
            <input name="subjectCode" type="text" class="form-control" id="email" required>
        </div>

        <div class="mb-3">
            <label for="fee" class="form-label">Mark</label>
            <input name="mark" type="text" class="form-control" id="fee" required>
        </div>
        <div class="mb-3">
            <label for="fee" class="form-label">Grade</label>
            <input name="grade" type="text" class="form-control" id="fee" required>
        </div>
        <div class="mb-3">
            <label for="fee" class="form-label">Student ID</label>
            <input name="studentId" type="text" class="form-control" id="fee" required>
        </div>

        

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="footer.jsp" %>
