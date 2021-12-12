<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
	<%@include file="/pages/common/head.jsp"%>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@include file="/pages/common/login_success_menu.jsp"%>
	</div>
	
	<div id="main">
		
		<table>
			<tr>
				<td>日期</td>
				<td>金额</td>
				<td>状态</td>
				<td>详情</td>
			</tr>		
			<c:if test="${empty sessionScope.myOrder}">
				<div class="cart_info">
					您的订单列表为空，快来<a href="index.jsp">选购商品</a>吧
				</div>
			</c:if>
			<c:if test="${not empty sessionScope.myOrder}">
				<c:forEach items="${sessionScope.myOrder}" var="item">
					<tr>
						<td>${item.createTime}</td>
						<td>${item.price}</td>
						<c:if test="${item.status==0}">
							<td>未发货</td>
							<td><a href="orderServlet?action=queryOrderDetails&orderid=${item.orderId}">查看详情</a></td>
						</c:if>
						<c:if test="${item.status==1}">
							<td>已发货</td>
							<td><a href="orderServlet?action=queryOrderDetails&orderid=${item.orderId}">查看详情</a></td>
							<td><a href="orderServlet?action=confirm&orderid=${item.orderId}">确认收货</a></td>
						</c:if>
						<c:if test="${item.status==2}">
							<td>已完成</td>
							<td><a href="orderServlet?action=queryOrderDetails&orderid=${item.orderId}">查看详情</a></td>
						</c:if>

					</tr>
				</c:forEach>

			</c:if>

			

			

		</table>
		
	
	</div>
</body>
</html>