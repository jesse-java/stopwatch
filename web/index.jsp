<%--
  Created by IntelliJ IDEA.
  User: jesse
  Date: 2/16/18
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.naldojesse.com.models.Timer" import="java.util.ArrayList"%>
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

  <p>Start: <c:out value="${currStartTime}"/> </p>
  <p>Current Time: <c:out value="${currTime}"/></p>
  <p>Running Time: <c:out value="${currRunTime}"/></p>


  <%
    // retrieve your list from the request, with casting
    ArrayList<Timer> list = (ArrayList<Timer>) request.getAttribute("archivedTimers");

// print the information about every category of the list




    for(Timer t : list) {
      out.println(t.getStart());
      out.println(t.getStop());
      out.println(t.calcDuration());
    }
  %>

  </body>
</html>
