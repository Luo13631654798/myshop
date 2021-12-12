<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商城首页</title>
	<%@include file="/pages/common/head.jsp"%>
	<Script type="text/javascript">
		$(function () {
			$("button.addToCart").click(function () {
				var itemid = $(this).attr("itemid")
				location.href = "cartServlet?action=addItem&id="+itemid;
			})
		})
	</Script>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上商城</span>
			<div>
				<c:if test="${empty sessionScope.user}">
						<a href="pages/user/login.jsp">登录</a> |
						<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
				</c:if>
				<c:if test="${not empty sessionScope.user}">
					<span>欢迎【<span class="um_span">${sessionScope.user.username}</span>】光临本商城</span>
					<a href="orderServlet?action=queryMyOrder">我的订单</a>
					<a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
				</c:if>
			<a href="pages/cart/cart.jsp">购物车</a>
			<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/clientGoodsServlet" method="get">
						<input type="hidden" name="action" value="pageByKey">
						关键词搜索：<input id="key" type="text" name="key" value="${param.key}">
						<input type="submit" value="查询" />
				</form>
			</div>
			<c:if test="${empty sessionScope.cart.items}">
				<div style="text-align: center">
					<span>您的购物车中没有商品</span>
				</div>
			</c:if>

			<c:if test="${not empty sessionScope.cart.items}">
				<div style="text-align: center">
					<span>您的购物车中有${sessionScope.cart.totalCount}件商品</span>
					<div>
						您刚刚将<span style="color: red">${sessionScope.lastname}</span>加入到了购物车中
					</div>
				</div>
			</c:if>

			<c:forEach items="${requestScope.page.items}" var="goods">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${goods.imgpath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">商品名：</span>
							<span class="sp2">${goods.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">种类：</span>
							<span class="sp2">${goods.kind}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">${goods.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${goods.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${goods.stock}</span>
						</div>
						<div class="book_add">
							<button itemid="${goods.id}"class="addToCart">加入购物车</button>
						</div>
					</div>
				</div>

			</c:forEach>


		</div>
		<%@include file="/pages/common/page_nav.jsp"%>

	
	</div>
</body>
</html>