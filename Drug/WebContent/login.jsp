<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="width:30%; margin:12% auto;">

<form action="login" method="get">
  <div class="form-group" >
    <label >用户名</label>
    <input type="text" name="name" class="form-control" >
    <small  class="form-text text-muted">我们会保护你的账户</small>
  </div>
  <div class="form-group">
    <label >Password</label>
    <input type="password" class="form-control" name="password">
  </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" >
    <label class="form-check-label" for="exampleCheck1">记住密码</label>
  </div>
  <div style="width:60%; margin:15px auto;">
  <button type="submit" class="btn btn-primary">登录</button>
  <a  class="btn btn-primary" style="margin-left: 30px" href="register.jsp">注册</a>
  </div>
</form>
<span style="color: red;">${login }</span>
</div>
</body>
</html>