<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@600;800&display=swap" rel="stylesheet">

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

    <title>Danh Sách Sản Phẩm</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/client/layout/header.jsp" />

    <div class="container my-5">
        <h1 class="text-center mb-4">Danh Sách Sản Phẩm</h1>

        <!-- Nếu danh sách rỗng -->
        <c:if test="${empty products}">
            <div class="text-center my-5">
                <h3 class="text-danger">No product</h3>
            </div>
        </c:if>

        <!-- Nếu có sản phẩm -->
        <c:if test="${not empty products}">
            <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
                <c:forEach var="product" items="${products}">
                    <div class="col-md-6 col-lg-4 col-xl-3 d-flex">
                        <div class="rounded position-relative fruite-item w-100 h-100">
                            <div class="fruite-img">
                                <img src="/images/product/${product.image}" class="img-fluid w-100 rounded-top" alt="">
                            </div>

                            <div class="p-4 border border-secondary border-top-0 rounded-bottom text-center">
                                <h4 style="font-size: 15px;">
                                    <a href="/product/${product.id}">${product.name}</a>
                                </h4>
                                <p style="font-size: 13px;">${product.shortDesc}</p>
                                <div class="d-flex flex-lg-wrap justify-content-center">
                                    <p style="font-size: 15px; text-align: center; width: 100%;"
                                       class="text-dark fw-bold mb-3">
                                        <fmt:formatNumber type="number" value="${product.price}"/>đ
                                    </p>

                                    <form action="/add-product/${product.id}" method="post" class="d-flex justify-content-center">
                                        <button type="submit" class="btn border border-secondary rounded-pill px-4 py-2 mb-4 text-primary">
                                            <i class="fa fa-shopping-bag me-2 text-primary"></i> Add to cart
                                        </button>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:if>

    </div>

    <jsp:include page="/WEB-INF/views/client/layout/footer.jsp" />

    <!-- JavaScript Libraries -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/client/lib/easing/easing.min.js"></script>
    <script src="/client/lib/waypoints/waypoints.min.js"></script>
    <script src="/client/lib/lightbox/js/lightbox.min.js"></script>
    <script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Custom Scripts -->
    <script src="/client/js/main.js"></script>
</body>
</html>
