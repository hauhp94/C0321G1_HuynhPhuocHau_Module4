<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/16/2021
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="create" method="post" modelAttribute="setting">
    <fieldset>
        <legend>Setting</legend>
        <table>
            <tr>
                <td>Language:</td>
                <td>
                    <form:select path="language" items="${languages}"/>
                </td>

            </tr>
            <tr>
                <td>Page Size:</td>
                <td>Show
                    <form:select path="pageSize" items="${pageSize}"/>
                    email per page
                </td>
            </tr>
            <tr>
                <td>Spams filter:</td>
                <td>
                    <form:checkbox path="enableSpamsFilter"/> Enable spams fillter
                </td>
            </tr>
            <tr>
                <td>Signature:</td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><button type="submit" style="color: cornflowerblue">Ok</button></td>
                <td><button type="reset">Reset</button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
