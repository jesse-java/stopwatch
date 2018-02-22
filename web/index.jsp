<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/16/18
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.naldojesse.com.models.Timer" import="java.util.ArrayList" import="java.util.concurrent.TimeUnit" import="java.text.SimpleDateFormat" import="java.util.Date"%>
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


  <p>Start: <c:out value="${currStartTime}"/></p>
  <p>Current Time: <c:out value="${currTime}"/></p>
  <p>Running Time: <c:out value="${currRunTime}"/></p>


  <%--<%  ArrayList<Timer> list = (ArrayList<Timer>) request.getAttribute("archivedTimers"); %>--%>
  <table border="1">
      <thead>
        <th>Start</th>
        <th>Stop</th>
        <th>Total</th>
      </thead>
      <%--<% if (list != null) { %>--%>
          <%--<% for (Timer t : list) { %>--%>
              <%--<tr>--%>
                  <%--<td><%= t.getStartTime() %></td>--%>
                  <%--<td><%= t.getStopTime() %></td>--%>
                  <%--<td><%= t.calcDurationTime() %></td>--%>
              <%--</tr>--%>
          <%--<% } %>--%>
      <%--<% } %>--%>
      <c:forEach items="${archivedTimers}" var="timer">
          <tr>
              <td><c:out value="${timer.getStartTime()}"/></td>
              <td><c:out value="${timer.getStopTime()}"/></td>
              <td><c:out value="${timer.calcDurationTime()}"/></td>
          </tr>
      </c:forEach>


  </table>


  </body>
</html>
