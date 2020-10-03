<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</head>
<body >

<div style="padding: 15px 50px 10px;" >
<nav class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
	    <div class="navbar-header">
	        <a class="navbar-brand" href="index.jsp">主页</a>
	    </div>
	    <div>
	        <ul class="nav navbar-nav">
	            <li ><a href="drugManage.jsp">药品管理</a></li>
	            <li class="dropdown">
	                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
	                   发/退药管理
	                    <b class="caret"></b>
	                </a>
	                <ul class="dropdown-menu">
	                 	<li><a href="dispensingDrug.jsp">门诊发药</a></li>
   					    <li><a href="outDrug.jsp">门诊退药</a></li>
	                </ul>
	            </li>	                
	        </ul>
	        		<a href="login.jsp" class="btn btn-primary btn-lg" style="float: right">退出登录</a>
	    </div>
    </div>

</nav>


<hr>
<h1 style="margin-left: 30px;margin-top: 50px">欢迎使用药房管理系统</h1>

</div>

</body>
</html>