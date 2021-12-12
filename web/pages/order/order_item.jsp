<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单详情</title>
    <%@include file="/pages/common/head.jsp"%>
<%--    <script type="text/javascript">--%>
<%--        $(function () {--%>
<%--            $("a.deleteItem").click(function () {--%>
<%--                return confirm("确认删除【" + $(this).parent().parent().find("td:first").text()+"】吗？")--%>
<%--            })--%>
<%--            $("#clean").click(function () {--%>
<%--                return confirm("确认清空购物车吗？")--%>
<%--            })--%>
<%--            $(".updateCount").change(function () {--%>
<%--                var name = $(this).parent().parent().find("td:first").text();--%>
<%--                var count = this.value;--%>
<%--                var id = $(this).attr("id");--%>
<%--                if (confirm("确认将【" + name + "】数量修改为" + count + "吗？")) {--%>
<%--                    location.href = "cartServlet?action=updateCount&count="+count + "&id="+ id;--%>
<%--                }else {--%>
<%--                    this.value = this.defaultValue;--%>
<%--                }--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">订单详情</span>
    <%@include file="/pages/common/login_success_menu.jsp"%>

</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>总额</td>
        </tr>

        <c:forEach items="${requestScope.orderItemsList}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.count}</td>
                <td>${item.price}</td>
                <td>${item.totalPrice}</td>
<%--                <td><a href="cartServlet?action=deleteItem&id=${item.id}" class="deleteItem">删除</a></td>--%>
            </tr>
        </c:forEach>

    </table>

<%--        <div class="cart_info">--%>
<%--            <span class="cart_span">此订单中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>--%>
<%--            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>--%>
<%--        </div>--%>


</div>
</body>
</html>
