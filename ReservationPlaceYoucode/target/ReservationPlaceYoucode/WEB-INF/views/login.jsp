<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 14/03/2021
  Time: 00:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" >

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">

    <!-- Style -->
    <link rel="stylesheet" href="<c:url value="/resources/css/owl.carousel.min.css"/>" type="text/css">

</head>
<body>



<div class="content">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="<c:url value="/resources/images/undraw_remotely_2j6y.svg"/>" alt="Image" class="img-fluid">
            </div>
            <div class="col-md-6 contents">
                <div class="row justify-content-center">
                    <div class="col-md-8">
                        <div class="mb-4">
                            <h3>Sign In</h3>
                            <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
                        </div>
                <form:form method="post" modelAttribute="userlogin" action="prosseForm">
                            <div class="form-group first">
                                <label for="username">Username</label>
                                <form:input  path="email" type="text" class="form-control" id="username" name="username"/>

                            </div>
                            <div class="form-group last mb-4">
                                <label for="password">Password</label>
                                <form:input path="password" type="password" class="form-control" id="password" name="password"/>

                            </div>

                            <div class="d-flex mb-5 align-items-center">
                               <span class="caption"><a href="regestre" class="signup-image-link">Create an account</a></span>


                            </div>



                            <input type="submit" value="Log In" class="btn btn-block btn-primary">



                </form:form>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>


<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/main.js"/>"></script>

</body>
</html>
