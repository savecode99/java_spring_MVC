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
                            <div class ="container mt-5">
                                <div class = "row">
                                    <div class = "col-12 mx-auto">
                        
                                        <div class="d-flex justify-content-between">
                                            <h1>UserDetail with ID = ${id}</h1>
                                        </div>
                                        <div class="card" style="width: 70%;">
                                            <div class="card-header">
                                                <h2>Infomation</h2>
                                            </div>
                                        <div class="row g-0">
                                            
                                            
                                            <div class="col-md-8">
                                                <ul class="list-group list-group-flush">
                                                <li class="list-group-item">ID: ${userDetail.id} </li>
                                                <li class="list-group-item">FullName: ${userDetail.fullName}</li>
                                                <li class="list-group-item">Address: ${userDetail.address}</li>
                                                <li class="list-group-item">PhoneNumber: ${userDetail.phoneNumber}</li>
                                                </ul>

                                            </div>
                                            
                                            <div class="col-md-4 text-center my-auto">
                                                <img src="../../../images/avatar/${userDetail.avatar}" alt="User Avatar" class="card-img-top" style="max-width: 150px; margin: 10px auto;">
                                            </div>
                                        </div>
                                        </div>
                                            <a href="/admin/user" class="btn btn-success mt-3">Back</a>
                                        
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
