<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2021/11/18
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <span>欢迎【<span class="um_span">${sessionScope.user.username}</span>】光临本商城</span>
    <a href="orderServlet?action=queryMyOrder">我的订单</a>
    <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
