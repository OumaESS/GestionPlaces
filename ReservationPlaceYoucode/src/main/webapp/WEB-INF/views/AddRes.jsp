<%--
  Created by IntelliJ IDEA.
  User: yc
  Date: 16/03/2021
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required Fremwork -->
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w==" crossorigin="anonymous" />
    <!-- Style.css -->
    <link rel="stylesheet" href="<c:url value="/resources/css/styleStudent.css"/>">
    <title>Title</title>
</head>
<body>


<!-- Pre-loader start -->
<div class="theme-loader">
    <div class="loader-track">
        <div class="preloader-wrapper">
            <div class="spinner-layer spinner-blue">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
            <div class="spinner-layer spinner-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>

            <div class="spinner-layer spinner-yellow">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>

            <div class="spinner-layer spinner-green">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="gap-patch">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Pre-loader end -->
<div id="pcoded" class="pcoded">
    <div class="pcoded-overlay-box"></div>
    <div class="pcoded-container navbar-wrapper">
        <nav class="navbar header-navbar pcoded-header">
            <div class="navbar-wrapper">
                <div class="navbar-logo">
                    <a class="mobile-menu waves-effect waves-light" id="mobile-collapse" href="#!">
                        <i class="ti-menu"></i>
                    </a>

                    <a href="index.html">
                        <img class="img-fluid" src="<c:url value="/resources/images/logo.jpg"/>" alt="Theme-Logo" />
                    </a>
                    <a class="mobile-options waves-effect waves-light">
                        <i class="ti-more"></i>
                    </a>
                </div>

                <div class="navbar-container container-fluid">
                    <ul class="nav-left">
                        <li>
                            <div class="sidebar_toggle"><a href="javascript:void(0)"><i class="ti-menu"></i></a>
                            </div>
                        </li>

                        <li style="margin-top: 1.5em;">
                            <a href="#!" onclick="javascript:toggleFullScreen()" class="waves-effect waves-light" >
                                <i class="ti-fullscreen" ></i>
                            </a>
                        </li>
                    </ul>
                    <ul class="nav-right">
                        <li class="header-notification"  style="margin-top: 1.5em;" >
                            <a href="#!" class="waves-effect waves-light">
                                <i class="ti-bell"></i>
                                <span class="badge bg-c-red"></span>
                            </a>
                            <ul class="show-notification">
                                <li>
                                    <h6>Notifications</h6>
                                    <label class="label label-danger">New</label>
                                </li>
                            </ul>
                        <li class="user-profile header-notification">
                            <a href="#!" class="waves-effect waves-light">
                                <span>John Doe</span>
                                <i class="ti-angle-down"></i>
                            </a>
                            <ul class="show-notification profile-notification">
                                <li class="waves-effect waves-light">
                                    <a href="user-profile.html">
                                        <i class="ti-user"></i> Profile
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="email-inbox.html">
                                        <i class="ti-email"></i> My Messages
                                    </a>
                                </li>
                                <li class="waves-effect waves-light">
                                    <a href="auth-normal-sign-in.html">
                                        <i class="ti-layout-sidebar-left"></i> Logout
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="pcoded-main-container">
            <div class="pcoded-wrapper">
                <nav class="pcoded-navbar">
                    <div class="sidebar_toggle"><a href="#"><i class="icon-close icons"></i></a></div>
                    <div class="pcoded-inner-navbar main-menu">
                        <div class="">
                            <div class="main-menu-header" style="background-image: url("<c:url value="/resources/images/userbg.jpg"/>");">

                            <div class="user-details">
                                <span id="more-details">John Doe<i class="fa fa-caret-down"></i></span>
                            </div>
                        </div>

                        <div class="main-menu-content">
                            <ul>
                                <li class="more-details">
                                    <a href="user-profile.html"><i class="ti-user"></i>View Profile</a>
                                    <a href="auth-normal-sign-in.html"><i
                                            class="ti-layout-sidebar-left"></i>Logout</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <div class="pcoded-navigation-label" data-i18n="nav.category.navigation">Layout</div>
                    <ul class="pcoded-item pcoded-left-item">
                        <li class="active">
                            <a href="dashbord" class="waves-effect waves-dark">
                                <span class="pcoded-micon"><i class="ti-home"></i><b>D</b></span>
                                <span class="pcoded-mtext" data-i18n="nav.dash.main">Dashboard</span>
                                <span class="pcoded-mcaret"></span>
                            </a>
                        </li>




                    </ul>

                    <ul class="pcoded-item pcoded-left-item">
                        <li class="active">
                            <a href="form-elements-component.html" class="waves-effect waves-dark">
                                <span class="pcoded-micon"><i class="ti-layers"></i><b>FC</b></span>
                                <span class="pcoded-mtext" data-i18n="nav.form-components.main">Add
                                            Reservation</span>
                                <span class="pcoded-mcaret"></span>
                            </a>
                        </li>

                    </ul>


                    <ul class="pcoded-item pcoded-left-item">

                        <li class="pcoded-hasmenu">
                            <a href="javascript:void(0)" class="waves-effect waves-dark">
                                <span class="pcoded-micon"><i class="ti-layout-grid2-alt"></i></span>
                                <span class="pcoded-mtext" data-i18n="nav.basic-components.main">Settings</span>
                                <span class="pcoded-mcaret"></span>
                            </a>
                            <ul class="pcoded-submenu">
                                <li class=" ">
                                    <a href="loginDirect" class="waves-effect waves-dark">
                                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                        <span class="pcoded-mtext"
                                              data-i18n="nav.basic-components.alert">Login</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                </li>
                                <li class=" ">
                                    <a href="regestre" class="waves-effect waves-dark">
                                        <span class="pcoded-micon"><i class="ti-angle-right"></i></span>
                                        <span class="pcoded-mtext"
                                              data-i18n="nav.basic-components.breadcrumbs">Register</span>
                                        <span class="pcoded-mcaret"></span>
                                    </a>
                                </li>
                            </ul>
                        </li>

                    </ul>

                </nav>

                <div class="pcoded-content">
                    <!-- Page-header start -->
                    <div class="page-header"  style="background-image: url("<c:url value="/resources/images/breadcrumbbg.jpg"/>");">
                    <div class="page-block">
                        <div class="row align-items-center">
                            <div class="col-md-8">
                                <div class="page-header-title">
                                    <h5 class="m-b-10">Dashboard</h5>
                                    <p class="m-b-0">Welcome to Youcode Reservation</p>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <ul class="breadcrumb-title">
                                    <li class="breadcrumb-item">
                                        <a href="dashbord"> <i class="fa fa-home"></i> </a>
                                    </li>
                                    <li class="breadcrumb-item"><a href="dashbord">Dashboard</a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Page-header end -->
                <div class="pcoded-inner-content">
                    <!-- Main-body start -->
                    <div class="main-body">


                        <div class="page-wrapper">

                            <div class="card">
                                <div class="card-header">Add Reservation</div>
                                <div class="card-body">
                                    <h5 class="card-title"></h5>

                                    <form class="form-horizontal" action="insert" method="post">


                                        <c:if test="${client != null}">
                                        <input type="hidden" name="id" />
                                        </c:if>


                                        <div class="form-group row">
                                            <label class="col-sm-2">Type de Reservation </label>
                                            <div class="col-sm-10">
                                                <select class="form-control">
                                                    <option>09:00--->17:00</option>
                                                    <option>17:00--->20:00</option>
                                                    <option>Week end</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="line"></div><br>


                                            <div class="form-group row">
                                                <label class="col-sm-2" for="date">Date</label>
                                                <div class="col-sm-10">
                                                <input type="date" onload="getDate()" class="form-control" id="date" name="date">
                                                </div>
                                            </div>




                                        <div class="line"></div><br>
                                        <div class="form-group row">
                                            <div class="col-sm-4 offset-sm-2">
                                                <button type="submit" id="annuler"
                                                        class="btn btn-secondary mb-2">Cancel</button>
                                                <button type="submit" class="btn btn-primary mb-2">
                                                    Add</button>
                                            </div>
                                            <!-- Page-body end -->
                                        </div>
                                        <div id="styleSelector"> </div>
                                </div>
                            </div>
                        </div>
                        <!-- Page-body end -->
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<script>
    function getDate(){
        var today = new Date();

        document.getElementById("date").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);


    }
</script>
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/pcoded.min.js"/>"></script>
<script src="<c:url value="/resources/js/vertical-layout.min.js"/>"></script>
<script src="<c:url value="/resources/js/customdashboard.js"/>"></script>
<script src="<c:url value="/resources/js/scripSTUDENT.js"/>"></script>
</body>
</html>
