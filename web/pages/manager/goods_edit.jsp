<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑商品</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑商品</span>
	<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<form action="manager/goodsServlet" method="get">
				<input type="hidden" name="action" value="${empty param.id? "add":"update"}">
				<input type="hidden" name="id" value="${requestScope.goods.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>种类</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input name="name" type="text" value="${requestScope.goods.name}"/></td>
						<td><input name="price" type="text" value="${requestScope.goods.price}"/></td>
						<td><input name="kind" type="text" value="${requestScope.goods.kind}"/></td>
						<td><input name="sales" type="text" value="${requestScope.goods.sales}"/></td>
						<td><input name="stock" type="text" value="${requestScope.goods.stock}"/></td>
						<td><input type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
</body>
</html>