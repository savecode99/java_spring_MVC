<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Table User</title>
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
                <div class = "col-12 mx-auto">

                    <div class="d-flex justify-content-between">
                        <h3>Table Users</h3>
                        <a href="/admin/user/create"><button class = "btn btn-primary">Create New User</button></a>
                    </div>

                    <table class="table table-bordered">
                        <thead>
                          <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Email</th>
                            <th scope="col">FullName</th>
                            <th scope="col">Action</th>
                          </tr>
                        </thead>

                        <tbody>
                            <c:forEach var="user" items="${listUser}" >
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.email}</td>
                                    <td>${user.fullName}</td>
                                    <td>
                                        <div class="">
                                            <a href="/admin/user/show/${user.id}" class = "btn btn-primary" >View</a>
                                            <a href="/admin/user/update/${user.id}" class = "btn btn-warning" >Update</a>
                                            <a href="/admin/user/delete/${user.id}" class = "btn btn-danger" >Delete</a>
                                            
                                        </div>
                                        
                                    </td>
                                  </tr>
                                
                            </c:forEach>
                        </tbody>
                      </table>
                </div>
        </div>
    </div>
</body>
</html>