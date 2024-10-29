<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create a user</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- link css -->
    <link rel="stylesheet" href="">

</head>
<body>
    
        <div class = "container mt-5">
            <div class = "row">
                    <div class = "col-md-6 col-12 mx-auto">
                        <h2>Create New User</h2>
                        <form:form method = "POST"
                        action = "/admin/user/create" modelAttribute = "user"
                        >
                            <div class="mb-3">
                                <label for="InputEmail" class="form-label">Email: </label>
                                <form:input type="email" class="form-control" path = "email" />
                            </div>
                      
                            <div class="mb-3">
                                <label for="InputPassword" class="form-label">Password: </label>
                                <form:input type="password" class="form-control" path = "password" />
                            </div>
                      
                            <div class="mb-3">
                                <label for="InputPhoneNumber" class="form-label">Phone Number: </label>
                                <form:input type="text" class="form-control" path = "phoneNumber" />
                            </div>
                      
                            <div class="mb-3">
                                <label for="InputFullName" class="form-label">FullName: </label>
                                <form:input type="text" class="form-control" path = "fullName"  />
                            </div>
                      
                            <div class="mb-3">
                                <label for="InputAddress" class="form-label">Address: </label>
                                <form:input type="text" class="form-control" path = "address" />
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form:form>
                        
                    </div>
            </div>
        </div>
        
        

        

</body>
</html>