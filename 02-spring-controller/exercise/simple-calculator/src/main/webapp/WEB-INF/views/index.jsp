<%--
  Created by IntelliJ IDEA.
  User: test
  Date: 7/15/2021
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Calculator</h1>
  <form action="/calculator" method="get">
  <input type="number" name="firstNumber" value="${firstNumber}">
<%--    <input type="number" name="operator" value="${operator}" disabled>--%>
    <input type="number" name="secondNumber" value="${secondNumber}"><br>
  <button type="submit" name="operator" value="+">Addition(+)</button>
  <button type="submit" name="operator" value="-">Subtraction(-)</button>
  <button type="submit" name="operator" value="*">Multiplication(*)</button>
  <button type="submit" name="operator" value="/">Division(/)</button>
  </form>
  <h2>Kết quả: ${firstNumber} ${operator} ${secondNumber} = ${result}</h2>



  </body>
</html>
