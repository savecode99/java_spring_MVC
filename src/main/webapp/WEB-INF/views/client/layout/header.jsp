<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navbar start -->
<div class="container-fluid fixed-top">
    <div class="container px-0">
        <nav class="navbar navbar-light bg-white navbar-expand-xl">
            <a href="/" class="navbar-brand">
                <h1 class="text-primary display-6">LaptopShop</h1>
            </a>
            <button class="navbar-toggler py-2 px-3" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarCollapse">
                <span class="fa fa-bars text-primary"></span>
            </button>
            <div class="collapse navbar-collapse bg-white justify-content-between mx-5 " id="navbarCollapse">
                <div class="navbar-nav w-100">
                    <a href="/" class="nav-item nav-link active">Trang chủ</a>
                    <a href="/products" class="nav-item nav-link active">Sản phẩm</a>
                </div>   
                <div class="d-flex m-3 me-0 w-100 justify-content-end">
                
                    <c:if test="${not empty pageContext.request.userPrincipal}">

                        <a href="/cart-detail" class="position-relative me-4 my-auto">
                        <i class="fa fa-shopping-bag fa-2x"></i>
                        <span
                            class="position-absolute bg-secondary rounded-circle d-flex align-items-center justify-content-center text-dark px-1"
                            style="top: -5px; left: 15px; height: 20px; min-width: 20px;">${sessionScope.sum}</span>
                        </a>

                        <div class="dropdown my-auto">
                        <a href="#" class="dropdown" role="button" id="dropdownMenuLink"
                            data-bs-toggle="dropdown" aria-expanded="false" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fas fa-user fa-2x"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end p-4" aria-labelledby="dropdownMenuLink">
                            <li class="d-flex align-items-center flex-column" style="min-width: 300px;">
                                <img style="width: 150px; height: 150px; border-radius: 50%; overflow: hidden;"src="/images/product/${sessionScope.avatar}" />
                                <div class="text-center my-3">
                                    welcome
                                    ${sessionScope.fullname} 
                                    <!-- <c:out value="${pageContext.request.userPrincipal.name}" /> -->
                                </div>
                            </li>
                            <li><a class="dropdown-item" href="/user/updateProfile/information">Quản lý tài khoản</a></li>
                            <li><a class="dropdown-item" href="/user/updateProfile/change-password">Thay đổi mật khẩu</a></li>
                            <li><a class="dropdown-item" href="/user/orders">Đơn hàng</a></li>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li>
                                <form action="/logout" method="post">
                                    <button class="dropdown-item" href="/login">Đăng xuất</button>
                                    <div>
                                        <input type="hidden" name="${_csrf.parameterName}" 
                                        value="${_csrf.token}"/>
                                    </div>
                                </form>
                                
                            </li>
                        </ul>
                        </div>

                    </c:if>
                    
                    <c:if test="${empty pageContext.request.userPrincipal}">
                       
                        <a href="/login" class="nav-item nav-link active">Đăng nhập</a>
                    </c:if>
                </div>
            </div>
        </nav>
    </div>
</div>
<!-- Navbar End -->