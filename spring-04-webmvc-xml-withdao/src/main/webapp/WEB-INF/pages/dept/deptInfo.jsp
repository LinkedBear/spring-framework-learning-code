<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>部门信息</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>

<script>
    $(function() {
        $("#save-button").click(function() {
            $.ajax({
                url: '${pageContext.request.contextPath}/department/saveJson',
                type: 'post',
                data: JSON.stringify({
                    id: $("[name='id']").val(),
                    name: $("[name='name']").val(),
                    tel: $("[name='tel']").val()
                }),
                contentType: 'application/json;charset=utf-8',
                success: function(data) {
                    alert("修改成功！");
                }
            });
        });
    });
</script>

<body>
<h3>部门信息</h3>
<form id="data-form" method="post" action="${pageContext.request.contextPath}/department/save">
    <input type="hidden" name="id" value="${dept.id}">

    <label>部门名称：</label>
    <input type="text" name="name" value="${dept.name}">
    <br/>
    <label>部门电话：</label>
    <input type="text" name="tel" value="${dept.tel}">
    <br/>
    <input type="submit" value="保存部门">
</form>
<button id="save-button">保存</button>
<button onclick="window.history.go(-1)">返回</button>
</body>
</html>
