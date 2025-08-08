<%@include file="header.jsp" %>

<div class="container">
    <!-- Make sure to set enctype for file upload -->
    <form method="post" action="studentservlet" enctype="multipart/form-data">
        <input type="hidden" name="action" value="add">

        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input name="name" type="text" class="form-control" id="name" required>
        </div>

        <div class="mb-3">
            <label for="email" class="form-label">Email address</label>
            <input name="email" type="email" class="form-control" id="email" required>
        </div>

        <div class="mb-3">
            <label for="fee" class="form-label">Fee</label>
            <input name="fee" type="text" class="form-control" id="fee" required>
        </div>

        <div class="mb-3">
            <label for="photo" class="form-label">Photo</label>
            <input name="photo" type="file" class="form-control" id="photo" accept="image/*">
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="footer.jsp" %>
