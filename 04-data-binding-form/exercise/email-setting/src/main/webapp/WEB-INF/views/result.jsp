<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/16/2021
  Time: 3:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Email setting</h2>
<h3>Language: ${emailSetting.language}</h3>
<h3>Page size: ${emailSetting.pageSize}</h3>
<h3>Spams filter: ${emailSetting.enableSpamsFilter}</h3>
<h3>Signature: ${emailSetting.signature}</h3>
</body>
</html>
