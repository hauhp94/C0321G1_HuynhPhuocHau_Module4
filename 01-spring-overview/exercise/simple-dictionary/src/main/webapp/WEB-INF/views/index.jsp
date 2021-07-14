<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/14/2021
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Vietnamese Dictionary</h2>

<form method="post" action="/translate">
    <input type="text" name="key" placeholder="Enter your word: "/><br>
    (one,two,three,four)
    <input type="submit" id="submit" value="Search"/>
    <h1>hết quả: ${result}</h1>
</form>
</body>
</html>
