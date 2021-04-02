<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 16/03/2021
  Time: 01:45
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Inscription</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/inscript.css" />" >
</head>
<body>


<div class="main">

    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>
                    <form:form method="post" modelAttribute="student" action="registerForm">
                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <form:input path="firstName" type="text" name="fn" id="namef" placeholder="Your FirstName"/>
                        </div>

                        <div class="form-group">
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <form:input path="lastName" type="text" name="ln" id="name" placeholder="Your LastName"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <form:input path="email" type="email" name="email" id="email" placeholder="Your Email"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <form:input path="phone" type="number" name="phone" id="phone" placeholder="Your Phone"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <form:input path="password" type="password" name="pass" id="pass" placeholder="Password"/>
                        </div>
                        <div class="form-group">
                            <label ><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                        </div>
                    </form:form>
                </div>
                <div class="signup-image">
                    <figure><img src="<c:url value="/resources/images/signup-image.jpg"/>" alt="sing up image"></figure>
                    <a href="loginDirect" class="signup-image-link">I am already member</a>
                </div>
            </div>
        </div>
    </section>

</div>

<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/inscrpt.js"/>"></script>
</body>
</html>
