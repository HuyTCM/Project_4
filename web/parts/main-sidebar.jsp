<%--
  Created by IntelliJ IDEA.
  User: HuyTCM
  Date: 8/25/19
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p><c:out value="${sessionScope.USER}"/></p>
                <%--<a href="#"><i class="fa fa-circle text-success"></i> Online</a>--%>
            </div>
        </div>
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="treeview">
                <a href="editor">
                    <i class="fa fa-edit"></i> <span>New post</span>
                </a>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
