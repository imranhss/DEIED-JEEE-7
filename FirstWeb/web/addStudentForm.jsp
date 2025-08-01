<%@include  file="header.jsp" %>

        <div class="container">
            <form method="post" action="addstudent.jsp">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Name</label>
                    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Email address</label>
                    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Fee</label>
                    <input name="fee" type="text" class="form-control" id="exampleInputPassword1">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>





<%@include file="footer.jsp" %>