<%--
  Created by IntelliJ IDEA.
  User: 86136
  Date: 2021/11/21
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="page_nav">
    <a href="${requestScope.page.url}&pageNo=1">首页</a>
    <c:if test="${requestScope.page.pageNo>1}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    <%--			<a href="#">3</a>--%>
    【${requestScope.page.pageNo}】
    <%--			<a href="#">5</a>--%>
    <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
    </c:if>
    <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">末页</a>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageToalCount}条记录
    到第<input value="${param.pageNo}" name="pn" id="pn_input"/>页
    <input id="searchPagebtn" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            $("#searchPagebtn").click(function () {
                var pageNo = $("#pn_input").val();
                var pageTotal = ${requestScope.page.pageTotal};
                if(pageNo>=1 &&pageNo<=pageTotal){
                    location.href = "${requestScope.page.url}&pageNo=" + pageNo;
                }else {
                    alert("请输入1到"+pageTotal+"间的页码数");
                }


            })
        })
    </script>
</div>

