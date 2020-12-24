<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户信息</title>
</head>
<body>
<h3>用户信息</h3>
<form id="data-form" method="post" action="${pageContext.request.contextPath}/user/save"
      enctype="multipart/form-data">
    <input type="hidden" name="id" value="${user.id}">

    <label>用户名：</label>
    <input type="text" name="username" value="${user.username}">
    <br/>
    <label>用户姓名：</label>
    <input type="text" name="name" value="${user.name}">
    <br/>
    <label>所属部门：</label>
    <select name="department.id">
        <c:forEach items="${deptList}" var="dept">
            <c:if test="${user.department.id == dept.id}">
                <option value="${dept.id}" selected="selected">${dept.name} - ${dept.tel}</option>
            </c:if>
            <c:if test="${user.department.id != dept.id}">
                <option value="${dept.id}">${dept.name} - ${dept.tel}</option>
            </c:if>
        </c:forEach>
    </select>
    <br/>
    <label>生日：</label>
    <input type="text" name="birthday" value="${user.birthday}">
    <br/>
    <label>头像：</label>
    <input type="file" name="photoFile">
    <br/>
    <input type="submit" value="保存用户">
</form>
<button onclick="window.history.go(-1)">返回</button>
</body>
</html>
