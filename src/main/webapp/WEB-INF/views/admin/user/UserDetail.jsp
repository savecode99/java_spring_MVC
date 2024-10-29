<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>UserDetail</title>

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
                    <ul class="list-group list-group-flush">
                    <li class="list-group-item">ID: ${userDetail.id} </li>
                    <li class="list-group-item">FullName: ${userDetail.fullName}</li>
                    <li class="list-group-item">Address: ${userDetail.address}</li>
                    <li class="list-group-item">PhoneNumber: ${userDetail.phoneNumber}</li>
                    </ul>
                </div>
                    <a href="/admin/user" class="btn btn-success mt-3">Back</a>
                
            </div>
        </div>
    </div>
</body>
</html>