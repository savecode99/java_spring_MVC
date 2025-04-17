<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

   
    <!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="/client/lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link href="/client/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/client/css/style.css" rel="stylesheet">

    <title>Cập nhật thông tin</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/client/layout/header.jsp" />

    <div class="container-fluid px-4 d-flex justify-content-center align-items-center" style="min-height: 100vh;">
        <form:form method="post" action="/user/updateProfile/information" modelAttribute = "userUpdateDTO"
        class="p-4 border rounded shadow" style="width: 100%; max-width: 800px; background-color: #fff;">
            <h4 class="mb-4 text-center">Update User</h4>
            <div class="mb-4">
                <label for="InputEmail" class="form-label">Email: </label>
                <form:input type="email" class="form-control" path = "email" readonly="true"/>
            </div>   

            <div class="mb-4">
                <label for="InputPhoneNumber" class="form-label">Phone Number: </label>
                <form:input type="text" class="form-control" path = "phoneNumber" />
                <form:errors path="phoneNumber" cssClass="text-danger"/>
            </div>
      
            <div class="mb-4">
                <label for="InputFullName" class="form-label">FullName: </label>
                <form:input type="text" class="form-control" path = "fullName"  />
                <form:errors path="fullName" cssClass="text-danger"/>
            </div>
      
            <div class="mb-4">
                <label for="InputAddress" class="form-label">Address: </label>
                <form:input type="text" class="form-control" path = "address" />
                <form:errors path="address" cssClass="text-danger"/>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" class="btn btn-primary">Cập nhật</button>
                <button type="button" class="btn btn-primary" onclick="window.location.href='/';">Quay lại</button>
            </div>
        </form:form>
    </div>
  
    <jsp:include page="/WEB-INF/views/client/layout/footer.jsp" />
    <!-- JavaScript Libraries -->
    <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/client/lib/easing/easing.min.js"></script>
    <script src="/client/lib/waypoints/waypoints.min.js"></script>
    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script> -->

    <!-- Custom Scripts -->
    <script src="/client/js/main.js"></script>
</body>
</html>
