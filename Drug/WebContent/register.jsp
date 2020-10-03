<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>添加用户</title>  
    <link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.min.js"></script>

    <script>  
        function addCheck(){  
            var username=document.getElementById("username").value;  
            var password=document.getElementById("password").value;  
            var newword=document.getElementById("newword").value;  
            if(username==""){  
                alert("用户名不能为空!");  
                document.getElementById("username").focus();    
                return false;  
                }  
            if(password==""){  
                alert("密码不能为空!");  
                 document.getElementById("password").focus();  
                 return false;  
                 }  
            if(password != newword){  
                alert("两次输入密码不相同!");  
                 document.getElementById("newword").focus();  
                 return false;  
                 }  
        }  
        function validate(){  
            var flag = addCheck();  
            if(flag == false)  
                return false;  
            return true;  
        }  
    </script>  
<body>  
<div style="width:40%; margin:180px auto;">

<form action = "login" method = "post" >  
<table  class="table"> 
 <tr id="show_tab_one">
    <label for="" class="col-form-label">用户名：</label>
    <input type="text" name="username"  maxlength = "16" class="form-control">
  </tr>  
  <tr id="show_tab_one">
  	<label for="" class="col-form-label">密码：</label>
    <input type="text" name="password"  maxlength = "16" class="form-control">
  </tr>  
  <tr id="show_tab_one">
   <label for="" class="col-form-label">确认密码：</label>
    <input type="text" name="newword"  maxlength = "16" class="form-control">
  </tr>  
  <tr>  
    <td colspan = "2" align = "center">
    <button type="submit" class="btn btn-primary mb-4">注  册</button>
    <input type="reset" class="btn btn-primary mb-4" value="重  置">
    </td>  
  </tr>  
</table>  
</form>  
<br>

</div>
</body>  
</html> 