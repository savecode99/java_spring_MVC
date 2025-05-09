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
        <title>Welcome back</title>
        <link href="/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script>
            $(document).ready(() => {
                const avatarFile = $("#imageProduct");
                const OrgImage = "${product.image}";
                if(OrgImage){
                    const UrlImage = "/images/product/" + OrgImage;
                    $("#avatarPreview").attr("src", UrlImage);
                    $("#avatarPreview").css({ "display": "block" });
                }

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
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item active"></li>
                        </ol>
                        <div>
                            <div class = "container mt-5">
                                <div class = "row">
                                        <div class = "col-md-6 col-12 mx-auto">
                                            <h2>Update Category</h2>
                                            <form:form method = "POST"
                                            action = "/admin/category/update" modelAttribute = "category"
                                            enctype="multipart/form-data"
                                            >  
                                            <div class="mb-3" style="display: none;">
                                                <label class="form-label" >ID: </label>
                                                <form:input type="text" class="form-control" path = "id" />
                                            </div>
                                                                          
                                            <div class="mb-3 col-12 col-md-6">
                                                <label class="form-label">Name: </label>
                                                <c:set var = "errorName">
                                                    <form:errors path = "name" cssClass = "invalid-feedback" />
                                                </c:set>
                                                <form:input type="text" class="form-control ${not empty errorName ?'is-invalid':''}" path = "name" />
                                                ${errorName}

                                            </div>
                                            <div class="mb-3 col-12">                                                
                                                <label class="form-label"> Description: </label>
                                                <form:input type="text" class="form-control" path = "description" />
                                            </div>
 
                                            <div class="d-flex justify-content-between">
                                                <button type="submit" class="btn btn-warning">Update</button>
                                                <button type="button" class="btn btn-secondary" onclick="window.location.href='/admin/category';">Cancel</button>
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
        <script src="../../../js/scripts.js"></script>
    </body>
</html>
