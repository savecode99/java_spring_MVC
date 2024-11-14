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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            $(document).ready(() => {
            const avatarFile = $("#imageProduct");
            avatarFile.change(function (e) {
            const imgURL = URL.createObjectURL(e.target.files[0]);
            $("#avatarPreview").attr("src", imgURL);
            $("#avatarPreview").css({ "display": "block" });
            });
        });
        </script>
    </head>
    <body class="sb-nav-fixed">
        
        <jsp:include page="../layout/header.jsp"/>


        <div id="layoutSidenav">
            
            <jsp:include page="../layout/sidebar.jsp"/>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Manage Product</h1>
                        
                        <div>
                            <div class = "mt-5">
                                <div class = "row">
                                        <div class = "col-md-6 col-12 mx-auto">
                                            <h2>Create New Product</h2>
                                            <form:form method = "POST"
                                            action = "/admin/product/create" modelAttribute = "product"
                                            enctype="multipart/form-data"
                                            >
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Name: </label>
                                                    <c:set var = "errorName">
                                                        <form:errors path = "name" cssClass = "invalid-feedback" />
                                                    </c:set>
                                                    <form:input type="text" class="form-control ${not empty errorName ?'is-invalid':''}" path = "name" />
                                                    ${errorName}

                                                </div>
                                          
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Price: </label>
                                                    <c:set var = "errorPrice">
                                                        <form:errors path="Price"  cssClass = "invalid-feedback"/>
                                                    </c:set>
                                                    <form:input type="number" step="0.1" class="form-control ${ not empty errorPrice ?'is-invalid':''}" path = "Price" />
                                                    ${errorPrice}
                                                </div>
                                                
                                          
                                                <div class="mb-3 col-12 col-md-6">                                                
                                                    <label class="form-label">Detail Description: </label>
                                                    <form:input type="text" class="form-control" path = "detailDesc" />
                                                </div>
                                          
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Short Description: </label>
                                                    <form:input type="text" class="form-control" path = "shortDesc"  />
                                                </div>
                                          
                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Quantity: </label>
                                                    <c:set var = "errorQuantity">
                                                        <form:errors path="quantity"  cssClass = "invalid-feedback"/>
                                                    </c:set>
                                                    <form:input type="number" class="form-control ${not empty errorQuantity ? 'is-invalid' :''}" path = "quantity" />
                                                    ${errorQuantity}
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Factory:</label>
                                                    <form:select class="form-select" path="factory">
                                                        <form:option value="MacBook">MacBook</form:option>
                                                        <form:option value="Dell">Dell</form:option>
                                                        <form:option value="ASUS">ASUS</form:option>
                                                        <form:option value="LeNoVo">LeNoVo</form:option>
                                                    </form:select>
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label class="form-label">Target:</label>
                                                    <form:select class="form-select" path="target">
                                                        <form:option value="Gaming">Gaming</form:option>
                                                        <form:option value="DoanhNhan">Doanh Nhân</form:option>
                                                        <form:option value="ThietKe">Thiết kế</form:option>
                                                      
                                                    </form:select>
                                                </div>

                                                <div class="mb-3 col-12 col-md-6">
                                                    <label for="imageProduct" class="form-label">image:</label>
                                                    <input class="form-control" type="file" id="imageProduct"
                                                        accept=".png, .jpg, .jpeg"
                                                        name ="file"/>  <!-- cùng bên be -->
                                                       
                                                </div>

                                                <div class="col-12 mb-3">
                                                    <img style="max-height: 250px; display: none;" alt="avatar preview"
                                                        id="avatarPreview" />
                                                </div>
                                                <div class="col-12 mb-5">
                                                    <button type="submit" class="btn btn-primary">Create</button>
                                                </div>
                                                
                                            </form:form>
                                            
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
        <script src="/js/scripts.js"></script>
    </body>
</html>
