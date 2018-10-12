<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table border="1" align="center" width="70%">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>
    <#list list as user>
        <tr>
            <td>${user.userId }</td>
            <td>${user.userName}</td>
            <td>${user.userAge }</td>
        </tr>
    </#list>
</table>
</body>
</html>