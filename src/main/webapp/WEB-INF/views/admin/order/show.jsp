<%@page contentType="text/html" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Welcome back</title>
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
                        <h1 class="mt-4">Dashboard</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active">Dashboard</li>
                        </ol>
                        <div>
                            <div class = "">
                                <div class = "row">
                                        <div class = "col-12 mx-auto">
                        
                                            <div class="d-flex justify-content-between">
                                                <h3>Table Order</h3>
                                            </div>
                        
                                            <table class="table table-bordered " style="text-align: center;">
                                                <thead >
                                                  <tr>
                                                    <th scope="col">ID</th>
                                                    <th scope="col">Receiver</th>
                                                    <th scope="col">Address</th>
                                                    <th scope="col">PhoneNumber</th>
                                                    <th scope="col">Total_Price</th>
                                                    <th scope="col">Time</th>
                                                    <th scope="col">Status</th>
                                                    <th scope="col">Action</th>
                                                  </tr>
                                                </thead>
                        
                                                <tbody >
                                                    <c:forEach var="Order" items="${ListOrder}" >
                                                        <tr>
                                                            <td>${Order.id}</td>
                                                            <td>${Order.nameReceiver}</td>
                                                            <td>${Order.address}</td>
                                                            <td>${Order.phoneNumber}</td>
                                                            <td>${Order.totalPrice}</td>
                                                            <td>${Order.createdAt}</td>                                                           
                                                            <td>${Order.statusEnum}</td>
                                                            <td>
                                                                <div class="">
                                                                    <a href="/admin/order/show/${Order.id}" class = "btn btn-primary" >View</a>
                                                                    <a href="/admin/product/update/${product.id}" class = "btn btn-warning" >Update</a>
                                                                    <a href="/admin/order/cancel/${Order.id}" class = "btn btn-danger" >Cancel</a>
                                                                    
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
