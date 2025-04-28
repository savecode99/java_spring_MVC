<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Đơn hàng của bạn</title>

    <link href="/client/css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="/client/css/style.css" rel="stylesheet">
</head>
<body >
    <jsp:include page="/WEB-INF/views/client/layout/header.jsp" />

    <div class="container mt-5">
        <h2 class="mb-4 text-center">Danh sách đơn hàng</h2>

        
        <div class="row">
            <c:forEach var="order" items="${orders}">
                <div class="col-md-6 mb-4">
                    <div class="card shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">Đơn hàng</h5>
                            <p class="card-text">
                                <c:forEach var="orderDetail" items= "${order.orders_detail}">
                                    <div>
                                        <strong>Sản phẩm:</strong> ${orderDetail.product.name}
                                        <strong>Số lượng:</strong> ${orderDetail.quantity}
                                    </div>
                                </c:forEach>
                                <strong>Tổng tiền:</strong> ${order.totalPrice}₫
                                <div>
                                    <!-- <strong>Trạng thái:</strong> ${order.statusEnum} -->
                                    <strong>Trạng thái:</strong>
                                    <c:choose>
                                        <c:when test="${order.statusEnum == 'PENDING'}">Chờ xác nhận</c:when>
                                        <c:when test="${order.statusEnum == 'CONFIRMED'}">Đã xác nhận</c:when>
                                        <c:when test="${order.statusEnum == 'SHIPPING'}">Đang giao</c:when>
                                        <c:when test="${order.statusEnum == 'DELIVERED'}">Đã giao</c:when>
                                        <c:when test="${order.statusEnum == 'CANCELED'}">Đã hủy</c:when>
                                    </c:choose>
                                </div>
                                
                            </p>

                            
                            <c:if test="${order.statusEnum == 'PENDING' || order.statusEnum == 'CONFIRMED'}">
                                <form action="/user/cancel/order/${order.id}" method="post" onsubmit="return confirm('Bạn có chắc muốn hủy đơn hàng này');">
                                    <!-- <input type="hidden" name="orderId" value="${order.id}"> -->
                                    <div>
                                        <input type="hidden" name="${_csrf.parameterName}" 
                                        value="${_csrf.token}"/>
                                    </div>
                                    <button type="submit" class="btn btn-danger btn-sm">Hủy đơn hàng</button>
                                    
                                </form>
                            </c:if>
                        
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
