<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
  <%@page import="dao.*,bean.*,java.text.SimpleDateFormat,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发药</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div style="padding: 10px 100px 10px;">
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
	    </div>
    </div>
</nav>
<hr>
<form action="query" method="get">
		<div style="width: 80%;float: left;">
		<div style="width: 80%;float: left;">
 病历号：<input type="text" name="caseNum"   placeholder="请输入病历号" > &nbsp;&nbsp;
 时间：<input type="date" name="date"  placeholder="请输入时间"  />
   </div>
 <div style="width: 20%;float: right;margin-bottom:15px">
  <input type="submit" class="btn btn-primary" value="查询" >
  </div>
   </div>
</form>

<div style="width: 20%;float: right;margin-bottom:15px">
			<a class="btn btn-primary" href="rivivalServlet?payType=${payType}&caseNum=${caseNum }&time=${time }"  >发药</a>
    </div>			
     	</div>
				<table class="table table-striped" style="margin-left: 50px;width: 90%">
					<thread>
						<tr>
							<th colspan="5" style="text-align: center;">患者信息</th>
						</tr>
						<tr>
							<th>姓名</th>
							<th>性别</th>
							<th>年龄</th>
							<th class="warning">是否缴费</th>
							<th class="warning">是否发药</th>
						</tr>
					</thread>
					<tbody>
						<tr>
						<td>${name}</td>
							<td>${gender}</td>
							<td>${age}</td>
							<td class="warning">${payType}</td>
							<td class="warning">${drugType}</td>
						</tr>
					</tbody>
				</table>
	    <table class="table table-bordered" style="width: 50%;margin-left: 150px ">
		<thead>
			<tr>
				<th colspan="3" style="text-align: center;">药品信息</th>
			</tr>
			<tr>
			
				<th>药品名称</th>
				<th>药品单价</th>
				<th>药品数量</th>
			</tr>
		</thead>
		<tbody>
			<%
        Drug drug=new Drug();
		DrugDao drugDuo = new DrugDaoImpl();
		 String s=(String)session.getAttribute("drugNameList");
		 Double sum=0.0;
		 if(s!=null){
		String[] drugName = s.split(",|，");
		 for(String ss:drugName){
			 System.out.println(ss);
			 drug = drugDuo.findDrugName(ss);
			 sum=sum+drug.getDrugPrice();
		%>
			<tr>
				<td><%=drug.getDrugName() %></td>
				<td><%=drug.getDrugPrice() %></td>
				<td><%=drug.getDrugAmount() %></td>
			</tr>
		<%}}{%>
		</tbody>
		</table>
		<div style="width: 100%;margin-top:0px">
			<div style="width: 85%;float: left;margin-top:0px">
			</div>
			
			<div style="width: 15%;float: right;margin-top:0px">
			<span style="color: red;">消费金额：<%=sum %>$</span>
			</div>
</div>/
		<%}%>
<br>
	<div style="width: 100%;margin-top:0px">
			<div style="width: 85%;float: left;margin-top:0px">
			</div>
			
			<div style="width: 15%;float: right;margin-top:0px">
			<table class="table table-bordered">${cn }</table>
</div>
</div>

</body>
</html>