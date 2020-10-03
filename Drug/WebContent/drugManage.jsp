<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.DrugDaoImpl,bean.Drug,java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品管理页面</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.min.js"></script>


</head>

<script type="text/javascript">
	function doDelete(id){
		var flag=confirm("是否删除当前数据？");
		if(flag){
			window.location.href="DelectServlet?id="+id;
		}
	}
</script>

<body>

<div style="padding: 15px 50px 10px;">
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

<form action="show.jsp" method="get">
	<div style="margin-top:20px;margin-left:50px;width: 400px;float: left;">
	<input type="text" name="id"  class="form-control" placeholder="请输入药品编码">
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input style="margin-top:20px;margin-left:50px" class="btn btn-primary"  type="submit" value="确认搜索">
</form>

<a href="add.jsp" class="btn btn-default" style="margin-left:15px;margin-top: 50px" onclick="">添加药品</a>
<a href="#" class="btn btn-danger" style="margin-left:30px;margin-top: 50px" onclick=""> 批量删除</a>

<a href="#" class="btn btn-default"  style="margin-left:570px;margin-top: 50px">导入药品</a>


<br><br>
	<table class="table" id="show_tab">
			<thead class="">
		    	<tr id="show_tab_one">
		    	 <th>
		    	 <input type="checkbox" onclick="selectAll(this.checked)" />
		    	 </th>
		    	 
           		 <th scope="col">药品编码</th>
		         <th scope="col">药品名称</th>
		         <th scope="col">拼音助记码</th>
		         <th scope="col">药品规格</th>
		         <th scope="col">药品单位</th>
		         <th scope="col">药品类型</th>
		         <th scope="col">药品价格</th>
		         <th scope="col">药品包装单位</th>
		         <th scope="col">药品数量</th>
          		 <th scope="col" style="text-align: center;">操作</th>
       			</tr>
	 		</thead>
	 		<tbody>
	 			<%
            		DrugDaoImpl dao=new DrugDaoImpl();
            		ArrayList<Drug> list =dao.findAllDrug();   
            		for(Drug tl:list){%>
           				<tr id="show_tab_tr">
           				
           				 	<td><input type="checkbox" name="check" /></td>
              				<td><%=tl.getDrugId() %></td>
               				<td><%=tl.getDrugName() %></td>
               				<td><%=tl.getDrugPingyin() %></td>
               				<td><%=tl.getDrugSpecification() %></td>
               				<td><%=tl.getDrugUnit() %></td>
               				<td><%=tl.getDrugType() %></td>
               				<td><%=tl.getDrugPrice() %></td>
               				<td><%=tl.getDrugJX() %></td>
               				<td><%=tl.getDrugAmount() %></td>
               				<td>
               					<div style="text-align: center;">
               						<a href="#" onClick="doDelete(<%=tl.getDrugId() %>);return false;" class="btn btn-danger btn-sm">删除</a>
               						
               						<a href="update.jsp?id=<%=tl.getDrugId() %>&name=<%=tl.getDrugName() %>
               						&pingyin=<%=tl.getDrugPingyin() %>&spe=<%=tl.getDrugSpecification() %>
               						&unit=<%=tl.getDrugUnit() %>&type=<%=tl.getDrugType() %>&packing=<%=tl.getDrugJX() %>
               						&price=<%=tl.getDrugPrice() %>&amount=<%=tl.getDrugAmount() %>" class="btn btn-warning btn-sm">修改</a>
               					</div>
               				</td>
           				</tr>
            		<%}
        		%>
	 		</tbody>
   		</table>
		<input id="lastpage" type="button" class="btn btn-default" value="上一页" >
    	<input id="curPage" type="text"  size="5">
    	<input id="npage" type="button" class="btn btn-default" value="确定">
    	<input id="nextpage" type="button" class="btn btn-default" value="下一页">
    	共<input id="page" type="text" size="1" readonly="readonly" >页 
      	每页显示<input id="pageSize" type="text" value="5" size="5">行<input class="btn btn-default" type="button" value="确定" onclick="pageSize2()">
      	
      	
      	<script type="text/javascript">
  			var pageSize=5;  //每页显示的记录条数   
        	var curPage=0;   //显示第curPage页
        	var len;         //总行数
        	var page;        //总页数
       		$(function(){    
       			len =$("#show_tab tr").length-1;   //去掉表头     
        		page=len % pageSize==0?len/pageSize:Math.floor(len/pageSize)+1;//根据记录条数，计算页数
        		console.log("len:"+len+"page:"+page);
        		document.getElementById("page").value=page;
        		curPage=1;
        		displayPage();//显示第一页
      			$("#nextpage").click(function(){//下一页
          		if(curPage<page){
              		curPage+=1;
          		}
          		else{
              		alert("这是最后一页了！！");
          		}
         		displayPage();
         	});
      		$("#lastpage").click(function(){//上一页
          		if(curPage>1){
              		curPage-=1;
          		}
          		else{
              		alert("yishidiyiye");
          		}
          		displayPage();
          	});
      		$("#npage").click(function(){//跳到固定某一页
          		var npage=parseInt(document.getElementById("curPage").value);
          		if(npage>page||npage<1){
              		alert("没有这一页！！！");
          		}
          		else{
              		curPage=npage;
          		}
          		displayPage();
          	});
 		});
 
 		function displayPage(){  
     		var begin=(curPage-1)*pageSize;//起始记录号
     		var end = begin + pageSize;
     		console.log("  begin:"+len+"   end:"+end);
     		if(end > len ) end=len;
     		$("#show_tab tr").hide();
     		$("#show_tab tr").each(function(i){
         		if(i-1>=begin && i-1<end)//显示第page页的记录
             	{
             		$("#show_tab_one").show();
             		$(this).show();
             		document.getElementById("curPage").value=curPage;
             }         
     	});

 		}        
 		function pageSize2(){
     		curPage=0;   //显示第curPage页   
     		pageSize=parseInt(document.getElementById("pageSize").value);
      		len =$("#show_tab tr").length-1;   //去掉表头     
      		page=len % pageSize==0?len/pageSize : Math.floor(len/pageSize)+1;//根据记录条数，计算页数
      		console.log("len:"+len+"   page:"+page);
      		document.getElementById("page").value=page;
      		curPage=1;
      displayPage();//显示第一页 
      }
 		
 		
 		
 		
 		
		function selectAll(selectStatus){//传入参数（全选框的选中状态）
			  //根据name属性获取到单选框的input，使用each方法循环设置所有单选框的选中状态
			  if(selectStatus){
			    $("input[name='check']").each(function(i,n){
			      n.checked = true;
			    });
			  }else{
			    $("input[name='check']").each(function(i,n){
			      n.checked = false;
			    });
			  }
			}
  </script>






</div>
</body>
</html>