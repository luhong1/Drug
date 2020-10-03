<%@page import="dao.DrugDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="bean.*,dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>

<div style="padding: 15px 50px 10px;">
<ul class="nav nav-pills" style="font-size: 20px;line-height: 1.5;">


	<li role="presentation"  class=""><a href="index.jsp">主页</a></li>
	<li role="presentation" ><a href="drugManage.jsp">药品管理</a></li>
	<li role="presentation" class="dropdown">
		<a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
		发/退药管理<span class="caret"></span>
		</a>
		<ul class="dropdown-menu">
			<li><a href="dispensingDrug.jsp">门诊发药</a></li>
			<li><a href="outDrug.jsp">门诊退药</a></li>
		</ul>
   </li>
</ul>
</div>

<%
	String drugId = request.getParameter("id");
	DrugDao dd = new DrugDaoImpl();
	Drug drug = dd.findDrug(drugId);
%>
<div style="width:60%; margin:auto; margin-left: 35%; margin-top: 8%">
<form  action="" method="get" style="font-size: 20px">
<div class="row">
	 <div class="col">
   		<label>药品编号:</label>
    	<%out.println(drug.getDrugId()); %>
   </div>
   <div class="col">
   		<label>药品名:</label>
    	<%out.println(drug.getDrugName()); %>
   </div>
   <div class="col">
   		<label>拼音助记码:</label>
    	<%out.println(drug.getDrugPingyin()); %>	
   </div>
   <div class="col">
   		<label>药品单位:</label>
    	<%out.println(drug.getDrugUnit()); %>	
   </div>
   <div class="col">
   		<label>药品规格:</label>
    	<%out.println(drug.getDrugSpecification()); %>	
   </div>
   <div class="col">
   		<label>药品价格:</label>
    	<%out.println(drug.getDrugPrice()); %>	
   </div>
   <div class="col">
   		<label>药品剂型:</label>
    	<%out.println(drug.getDrugJX()); %>	
   </div>
   <div class="col">
   		<label>药品数量:</label>
    	<%out.println(drug.getDrugAmount()); %>	
   </div>
   <div class="col">
   		<label>药品编号:</label>
    	<%out.println(drug.getDrugId()); %>	
   </div>
</div>
</form>



</div>
</body>
</html>