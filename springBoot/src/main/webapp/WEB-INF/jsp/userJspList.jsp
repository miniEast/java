<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
</head>
<body>
<table border="1" align="center" width="60%">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <c:forEach items="${list }" var="user">
        <tr>
            <td>${user.userId }</td>
            <td>${user.userName}</td>
            <td>${user.userAge }</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>