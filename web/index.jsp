<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/16/18
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/stopwatch" method="get">
    <input type="hidden" name="user_action" value="start">
    <input type="submit" value="Start">
  </form>

  <form action="/stopwatch" method="get">
    <input type="hidden" name="user_action" value="stop">
    <input type="submit" value="Stop">
  </form>

  <form action="/stopwatch" method="get">
    <input type="hidden" name="user_action" value="reset">
    <input type="submit" value="Reset">
  </form>


  <p>Start: <c:out value="${startTime}"/> </p>
  <p>Stop: <c:out value="${stopTime}"/></p>
  <p>Total: <c:out value="${currDuration}"/></p>

  </body>
</html>
