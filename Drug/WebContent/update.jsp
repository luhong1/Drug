<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'update.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<h1>请在下面填写要修改的内容！！！</h1>
  	<hr>
  	<% 
        String id=request.getParameter("id");
		String name=request.getParameter("name");
		String pingying=request.getParameter("pingyin");
		String spec=request.getParameter("spe");
		String unit=request.getParameter("unit");
		String type=request.getParameter("type");
		double price=Double.parseDouble(request.getParameter("price"));
		String packing=request.getParameter("packing");
		int amount=Integer.parseInt(request.getParameter("amount")); 
     %>
  	<form action="UpdateServlet" method="get">
  		<div class="col-lg-3">
    		<label>药品编码</label>
    		<input type="text" name="id" value=<%=id%> class="form-control" placeholder="请输入药品编码">
  		</div>
  		<div class="col-lg-3">
    		<label>药品名称</label>
    		<input type="text" name="name" value=<%=name%> class="form-control" placeholder="请输入药品名称">
  		</div>
  		<div class="col-lg-3">
    		<label>拼音助记码</label>
    		<input type="text" name="pingying" value=<%=pingying%> class="form-control" placeholder="请输入拼音助记码">
  		</div>
  		<div class="col-lg-3">
    		<label>药品规格</label>
    		<input type="text" name="spec" value=<%=spec%> class="form-control" placeholder="请输入药品规格">
  		</div>
  		<div class="col-lg-3">
    		<label>药品单位</label>
    		<input type="text" name="unit" value=<%=unit%> class="form-control" placeholder="请输入药品单位">
  		</div>
  		<div class="col-lg-3">
    		<label>药品类型</label>
    		<input type="text" name="type" value=<%=type%> class="form-control" placeholder="请输入药品类型">
  		</div>
  		<div class="col-lg-3">
    		<label>药品价格</label>
    		<input type="text" name="price" value=<%=price%> class="form-control" placeholder="请输入药品价格">
  		</div>
  		<div class="col-lg-3">
    		<label>药品包装单位</label>
    		<input type="text" name="packing" value=<%=packing%> class="form-control" placeholder="请输入包装单位">
  		</div>
  		<div class="col-lg-3">
    		<label>药品数量</label>
    		<input type="text" name="amount" value=<%=amount%> class="form-control" placeholder="请输入药品数量">
  		</div>
        <input type="submit" value="确定提交" class="btn btn-default" style="margin-left:15px; margin-top:25px;">
  	</form>
  </body>
</html>
