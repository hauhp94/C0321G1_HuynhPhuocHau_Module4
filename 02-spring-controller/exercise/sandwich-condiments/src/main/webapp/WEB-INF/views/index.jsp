<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/15/2021
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Sandwich Condiments</h1>
  <form action="/save" method="post">
    <input type="checkbox" id="Lettuce" name="condiment" value="Lettuce">
    <label for="Lettuce">Lettuce</label><br>
    <input type="checkbox" id="Tomato" name="condiment" value="Tomato" >
    <label for="Tomato">Tomato</label><br>
    <input type="checkbox" id="Mustard" name="condiment" value="Mustard">
    <label for="Mustard">Mustard</label><br>
    <input type="checkbox" id="Sprouts" name="condiment" value="Sprouts">
    <label for="Sprouts">Sprouts</label>
    <hr>
    <button type="submit" >OK</button>
  </form>
  <h1>Result: sandwich with</h1>
  <h1>
    <c:forEach items="${result}" var="result">
    <p>${result}</p>
  </c:forEach>
  </h1>
  </body>
</html>
