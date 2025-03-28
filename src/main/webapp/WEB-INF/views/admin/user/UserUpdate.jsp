<!-- <%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Welcome my shop</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        
        <jsp:include page="../layout/header.jsp"/>


        <div id="layoutSidenav">
            
            <jsp:include page="../layout/sidebar.jsp"/>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage User</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div>
                            <div class = "container mt-5">
                                <div class = "row">
                                        <div class = "col-md-6 col-12 mx-auto">
                                            <h2>Update User</h2>
                                            <form:form method = "POST"
                                            action = "/admin/user/update" modelAttribute = "user"
                                            >
                                                <div class="mb-3">
                                                    <label for="InputEmail" class="form-label">Email: </label>
                                                    <form:input type="email" class="form-control" path = "email" readonly="true"/>
                                                </div>
                                          
                                                <div class="mb-3" style="display: none;">
                                                    <label for="InputID" class="form-label" >ID: </label>
                                                    <form:input type="text" class="form-control" path = "id" />
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
                                                <div class="d-flex justify-content-between">
                                                    <button type="submit" class="btn btn-warning">Update</button>
                                                    <button type="button" class="btn btn-secondary" onclick="window.location.href='/admin/user';">Cancel</button>
                                                </div>
                                            </form:form>
                                            
                                            
                                        </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
                
                <jsp:include page="../layout/footer.jsp"/>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
    </body>
</html> -->
