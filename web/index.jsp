<%--
  Created by IntelliJ IDEA.
  User: huytcm1
  Date: 8/21/19
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <title>Homepage</title>
      <!-- Tell the browser to be responsive to screen width -->
      <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <!-- Bootstrap 3.3.7 -->
      <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
      <!-- Font Awesome -->
      <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
      <!-- Ionicons -->
      <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
      <!-- Theme style -->
      <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
      <!-- AdminLTE Skins. Choose a skin from the css/skins
           folder instead of downloading all of them to reduce the load. -->
      <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
      <!-- bootstrap wysihtml5 - text editor -->
      <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

      <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->

      <!-- Google Font -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
  </head>
  <body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">
    <%@ include file="parts/main-header.jsp" %>
    <%@ include file="parts/main-sidebar.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper" style="padding-bottom: 30;">
          <!-- Content Header (Page header) -->
          <section class="content-header">
              <h1>

              </h1>
              <ol class="breadcrumb">
                  <li><a href="home"><i class="fa fa-dashboard"></i> Home</a></li>
              </ol>
          </section>

          <!-- Main content -->
          <section class="content">
<c:forEach items="${POSTS}" var="post">
              <div class="row">
                  <!-- /.col -->
                  <div class="col-md-9">
                      <div class="nav-tabs-custom">
                          <div class="tab-content">
                              <div class="active tab-pane" id="activity">
                                  <!-- Post -->
                                  <div class="post">
                                      <h3 class="box-title">
                                          <a href="/post?id=<c:out value="${post.id}"/>">
                                              <c:out value="${post.title}"/>
                                          </a>
                                      </h3>
                                      <div class="user-block">
                                          <img class="img-circle img-bordered-sm" src="../../dist/img/user1-128x128.jpg" alt="user image">
                                          <span class="username">
                          <c:out value="${post.author}"/>
                        </span>
                                          <span class="description"><c:out value="${post.updateDate}"/></span>
                                      </div>
                                      <!-- /.user-block -->
                                      <p>
                                          <c:out value="${post.shortContent}"/>
                                      </p>
                                  </div>
                                  <!-- /.post -->
                              </div>
                          </div>
                          <!-- /.tab-content -->
                      </div>
                      <!-- /.nav-tabs-custom -->
                  </div>
                  <!-- /.col -->
              </div>
              <!-- /.row -->
</c:forEach>
              <ul class="pagination pagination-sm no-margin pull-right">
<%
    int currentPage = (int)request.getAttribute("CURR_PAGE");
    Long numOfPosts = (Long)request.getAttribute("NUM_POST");
    int i = 0;

    if (currentPage > 1) {
%>
                  <li><a href="?txtPage=<%=currentPage - 1%>">&laquo;</a></li>
<%
    } else {
%>
                  <li><a href="?txtPage=1">&laquo;</a></li>
<%
    }
    do {
        i++;
        if (i == currentPage) {
%>
                  <li><a id="need-focus" href="?txtPage=<%=i%>"><%=i%></a></li>
<%
        } else {
%>
                  <li><a href="?txtPage=<%=i%>"><%=i%></a></li>
<%
        }
    } while (i*5 <= numOfPosts);
    if (currentPage == i) {
%>
                  <li><a href="?txtPage=<%=currentPage%>">&raquo;</a></li>
<%
    } else {
%>
                  <li><a href="?txtPage=<%=currentPage + 1%>">&raquo;</a></li>
<%
    }
%>
              </ul>
          </section>
          <!-- /.content -->
      </div>
      <!-- /.content-wrapper -->

    <%@ include file="parts/main-footer.jsp" %>
  </div>
  <!-- ./wrapper -->

  <!-- jQuery 3 -->
  <script src="bower_components/jquery/dist/jquery.min.js"></script>
  <!-- jQuery UI 1.11.4 -->
  <script src="bower_components/jquery-ui/jquery-ui.min.js"></script>
  <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
  <script>
      $.widget.bridge('uibutton', $.ui.button);
  </script>
  <!-- Bootstrap 3.3.7 -->
  <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
  <!-- AdminLTE App -->
  <script src="dist/js/adminlte.min.js"></script>
  <script>
      $( document ).ready(function() {
          $("#need-focus").css("background-color", "#eee");
      });
  </script>
  </body>
</html>
