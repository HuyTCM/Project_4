<%--
  Created by IntelliJ IDEA.
  User: huytcm1
  Date: 8/22/19
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="main-header">
    <%
        if (session.getAttribute("USER") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    <!-- Logo -->
    <a href="home" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>H</b>uy</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>HuyTCM</b>Blog</span>
    </a>
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <li class="dropdown user user-menu">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs"><c:out value="${sessionScope.USER}"/></span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                            <p>
                                <c:out value="${sessionScope.USER}"/>
                                <%--<small>Member since Nov. 2012</small>--%>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-body">
                            <%--<div class="row">--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                    <%--<a href="#">Followers</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                    <%--<a href="#">Sales</a>--%>
                                <%--</div>--%>
                                <%--<div class="col-xs-4 text-center">--%>
                                    <%--<a href="#">Friends</a>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<!-- /.row -->--%>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <%--<a href="#" class="btn btn-default btn-flat">Profile</a>--%>
                            </div>
                            <div class="pull-right">
                                <a href="logout" class="btn btn-default btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
                <!-- Control Sidebar Toggle Button -->
            </ul>
        </div>
    </nav>
</header>
