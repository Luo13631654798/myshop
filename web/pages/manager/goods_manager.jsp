<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.deleteClass").click(function () {
				return confirm("确认删除【"+$(this).parent().parent().find("td:first").text()+"】？吗");
			})
		})
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">商品管理系统</span>
		<%@include file="/pages/common/manager_menu.jsp"%>

	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>种类</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
			<c:forEach items="${requestScope.page.items}" var="goods">
			<tr>
				<td>${goods.name}</td>
				<td>${goods.price}</td>
				<td>${goods.kind}</td>
				<td>${goods.sales}</td>
				<td>${goods.stock}</td>
				<td><a href="manager/goodsServlet?action=getGoods&id=${goods.id}">修改</a></td>
				<td><a class="deleteClass" href="manager/goodsServlet?action=delete&id=${goods.id}">删除</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/goods_edit.jsp">添加商品</a></td>
			</tr>	
		</table>


		<%@include file="/pages/common/page_nav.jsp"%>

	</div>
</body>
</html>