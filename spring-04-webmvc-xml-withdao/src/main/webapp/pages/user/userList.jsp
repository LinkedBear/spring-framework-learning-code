<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户列表</title>
</head>

<script>
    function del(id) {
        if (confirm("是否删除用户？")) {
            window.location = "${pageContext.request.contextPath}/user/delete?id=" + id;
        }
    }
</script>

<body>
<h3>用户列表</h3>
<div>
    <form id="query-form" method="get" action="${pageContext.request.contextPath}/user/list">
        <label>用户名：</label>
        <input type="text" name="username" value="">
        <input type="submit" value="查询">
    </form>
</div>
<table id="dept-table" border="1">
    <thead>
    <tr>
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
        <c:forEach items="${userList}" var="user">
            <tr>
                <td align="center">${user.id}</td>
                <td align="center">${user.username}</td>
                <td align="center">${user.name}</td>
                <td align="center">${user.birthday}</td>
                <td align="center"></td>
                <td align="center">${user.department.name}</td>
                <td align="center">
                    <a href="${pageContext.request.contextPath}/user/edit?id=${user.id}">编辑</a>
                    <a href="javascript:del('${user.id}')">删除</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
    </tbody>
</table>
</body>
</html>
