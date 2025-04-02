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

     <title>Welcome</title>
</head>
<body>

    <!-- Spinner Start -->
    <div id="spinner" class="show w-100 vh-100 bg-white position-fixed translate-middle top-50 start-50  d-flex align-items-center justify-content-center">
        <div class="spinner-grow text-primary" role="status"></div>
    </div>
    <!-- Spinner End -->


    <!-- Navbar start -->
    <jsp:include page="../layout/header.jsp"/>
    <!-- Navbar End -->

    <!-- Hero Start -->
    <div class="container-fluid py-5 mb-5 hero-header">
        <div class="container py-5">
            <div class="row g-5 align-items-center">
                <div class="col-md-12 col-lg-7">
                    <h4 class="mb-3 text-secondary">Cam kết</h4>
                    <h1 class="mb-3 text-secondary">Rẻ vô địch</h1>
                    <h1 class="mb-4 display-3 text-primary">Uy tín 100%</h1>
                    
                    <div class="position-relative mx-auto">
                        <input class="form-control border-2 border-secondary w-75 py-3 px-4 rounded-pill" type="number" placeholder="Search">
                        <button type="submit" class="btn btn-primary border-2 border-secondary py-3 px-4 position-absolute rounded-pill text-white h-100" style="top: 0; right: 25%;">Submit Now</button>
                    </div>
                </div>
                <div class="col-md-12 col-lg-5">
                    <div id="carouselId" class="carousel slide position-relative" data-bs-ride="carousel">
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active rounded">
                                <img src="client/img/mac1.jpg" class="img-fluid w-100 h-100 bg-secondary rounded" alt="First slide">
                                <a href="#" class="btn px-4 py-2 text-white rounded">Macbook</a>
                            </div>
                            <div class="carousel-item rounded">
                                <img src="client/img/gaming.jpg" class="img-fluid w-100 h-100 rounded" alt="Second slide">
                                <a href="#" class="btn px-4 py-2 text-white rounded">Gaming</a>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselId" data-bs-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselId" data-bs-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Hero End -->


 


    <!-- Fruits Shop Start-->
    <div class="container-fluid fruite py-5">
        <div class="container py-5">
            <div class="tab-class text-center">
                <div class="row g-4">
                    <div class="col-lg-4 text-start">
                        <h1>Sản phẩm nổi bật</h1>
                    </div>
                    <div class="col-lg-8 text-end">
                        <ul class="nav nav-pills d-inline-flex text-center mb-5">
                            <li class="nav-item">
                                <button class="d-flex m-2 py-2 bg-light rounded-pill active" onclick="window.location.href='/'" style="border: none; background: none; cursor: pointer;">
                                    <span class="text-dark" style="width: 130px;">All Products</span>
                                </button>
                            </li>
                            <li class="nav-item dropdown">
                                <div class="dropdown my-auto">
                                    <!-- Nút để mở menu -->
                                    <a class="d-flex m-2 py-2 bg-light rounded-pill active dropdown-toggle" role="button" href="#" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
                                    <span class="text-dark" style="width: 130px;">Search</span>
                                    </a>
                                    <!-- Nội dung menu -->
                                    <ul class="dropdown-menu dropdown-menu-end p-4" aria-labelledby="dropdownMenuLink">
                                        <c:forEach var="factory" items="${listFac}" >
                                            <li><a class="dropdown-item" href="/filterByFactory?factory=${factory}">${factory}</a></li>
                                        </c:forEach>
                                    </ul>

                                </div>
                                
                            </li>
                            
                        </ul>
                    </div>
                </div>
                <div class="tab-content">
                    <div id="tab-1" class="tab-pane fade show p-0 active">
                        <div class="row g-4">
                            <div class="col-lg-12">
                                <div class="row g-4">
                                    <c:forEach var="product" items="${listPro}" >
                                        <div class="col-md-6 col-lg-4 col-xl-3">
                                            <div class="rounded position-relative fruite-item">
                                                <div class="fruite-img">
                                                    <img src="/images/product/${product.image}" class="img-fluid w-100 rounded-top" alt="">
                                                </div>
                                            
                                                <div class="p-4 border border-secondary border-top-0 rounded-bottom">
                                                    <h4 style="font-size: 15px;">
                                                        <a href="/product/${product.id}">${product.name}</a>
                                                    </h4>
                                                    <p style="font-size: 13px;">${product.shortDesc}</p>
                                                    <div class="d-flex flex-lg-wrap">
                                                        <p style="font-size: 15px; text-align: center; width: 100%;"
                                                            class="text-dark  fw-bold mb-3">
                                                            <fmt:formatNumber type="number" value="${product.price}"/>đ
                                                        </p>
                                                        
                                                        
                                                        <form action="/add-product/${product.id}" method="post">
                                                            <button href="#" class="btn border border-secondary rounded-pill px-4 py-2 mb-4 text-primary">
                                                                <i class="fa fa-shopping-bag me-2 text-primary" style="text-align: center;"></i> Add to cart
                                                            </button>   
                                                            <input type="hidden" name="${_csrf.parameterName}" 
                                                            value="${_csrf.token}"/>
    
                                                        </form>
                                        
                                                        
                                                    </div>
                                                </div>
                                            </div>
                                            
                                        </div>
                                        
                                    </c:forEach>
                                    
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>      
        </div>
    </div>
    <!-- Fruits Shop End-->

       <!-- Featurs Section Start -->
       <jsp:include page="../layout/banner.jsp"/>
       <!-- Featurs Section End -->





    <!-- Footer Start -->
    <jsp:include page="../layout/footer.jsp"/>
    <!-- Footer End -->

    <!-- Copyright Start -->
    <div class="container-fluid copyright bg-dark py-4">
        <div class="container">
            <div class="row">
                <div class="col-md-6 text-center text-md-start mb-3 mb-md-0">
                    <span class="text-light"><a href="#"><i class="fas fa-copyright text-light me-2"></i>Your Site Name</a>, All right reserved.</span>
                </div>
                <div class="col-md-6 my-auto text-center text-md-end text-white">
                    Designed By <a class="border-bottom" href="https://htmlcodex.com">HTML Codex</a> Distributed By <a class="border-bottom" href="https://themewagon.com">ThemeWagon</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Copyright End -->



    <!-- Back to Top -->
    <a href="#" class="btn btn-primary border-3 border-primary rounded-circle back-to-top"><i class="fa fa-arrow-up"></i></a>   

    
<!-- JavaScript Libraries -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="/client/lib/easing/easing.min.js"></script>
<script src="/client/lib/waypoints/waypoints.min.js"></script>
<script src="/client/lib/lightbox/js/lightbox.min.js"></script>
<script src="/client/lib/owlcarousel/owl.carousel.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="/client/js/main.js"></script>
</body>
</html>