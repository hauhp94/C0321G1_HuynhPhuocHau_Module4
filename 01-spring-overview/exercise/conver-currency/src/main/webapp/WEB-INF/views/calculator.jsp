<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/14/2021
  Time: 3:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert" method="post">
    Nhập USD:

    <input type="number" name="usd" value="${usd}"><br>
    Nhập tỉ giá:

    <input type="number" name="rate" value="${rate}"><br>

    <button type="submit">Đổi sang VND</button>
    <h1>Kết quả: ${vnd} VND </h1>

</form>
</body>
</html>
