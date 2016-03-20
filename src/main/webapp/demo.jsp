<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>druid</title>
</head>
<body>
<fieldset>
    <legend>TestDruid</legend>
    <table border="1px" style="border-collapse: collapse">
        <tr>
            <td>id</td>
            <td>username</td>
            <td>password</td>
            <td>salt</td>
            <td>locked</td>
        </tr>
        <c:foreach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.salt}</td>
                <td>${user.locked}</td>
            </tr>
        </c:foreach>
    </table>
</fieldset>

</body>
</html>
