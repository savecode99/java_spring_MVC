<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
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
                            <div class = "">
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
                        </div>
                    </div>
                </main>
                
                <jsp:include page="../layout/footer.jsp"/>

            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="../js/scripts.js"></script>
    </body>
</html>
