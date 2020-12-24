<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>

<script>
    $(function() {
        $("#batch-delete-button").click(function() {
            var selectedIds = $("[name='selectedId']:checked");
            var ids = [];
            for (var i = 0; i < selectedIds.length; i++) {
                ids.push(selectedIds[i].value);
            }
            // $.post("${pageContext.request.contextPath}/user/batchDelete", {ids: ids}, function(data) {
            $.post("http://localhost:8081/spring-webmvc/user/batchDelete", {ids: ids}, function(data) {
                alert(data)
            });
        });

        $("#batch-update-button").click(function() {
            $("#batch-update-form").submit();
        });
    });
</script>

<body>
<h3>用户列表 ${publicMessage}</h3>
<div>
    <form id="query-form" method="get" action="${pageContext.request.contextPath}/user/list">
        <label>用户名：</label>
        <input type="text" name="username" value="">
        <input type="submit" value="查询">
    </form>
    <button id="batch-delete-button">批量删除</button>
    <button id="batch-update-button">批量修改用户名</button>
</div>
<table id="dept-table" border="1">
    <thead>
    <tr>
        <th width="40px"></th>
        <th width="320px">id</th>
        <th width="150px">用户名</th>
        <th width="100px">姓名</th>
        <th width="150px">生日</th>
        <th width="150px">头像</th>
        <th width="150px">所属部门</th>
        <th width="100px">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${userList != null}">
        <form id="batch-update-form" action="${pageContext.request.contextPath}/user/batchUpdate" method="post">
            <c:forEach items="${userList}" var="user" varStatus="status">
                <tr>
                    <td align="center">
                        <input type="checkbox" name="selectedId" value="${user.id}">
                    </td>
                    <td align="center">${user.id}</td>
                    <%--<td align="center">${user.username}</td>--%>
                    <td align="center">
                        <input type="text" name="users[${status.index}].username" value="${user.username}">
                    </td>
                    <td align="center">${user.name}</td>
                    <td align="center">${user.birthday}</td>
                    <td align="center">
                        <img src="${pageContext.request.contextPath}/user/getPhoto?id=${user.id}">
                    </td>
                    <td align="center">${user.department.name}</td>
                    <td align="center">
                        <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">编辑</a>
                    </td>
                </tr>
            </c:forEach>
        </form>
    </c:if>
    </tbody>
</table>
</body>
</html>
