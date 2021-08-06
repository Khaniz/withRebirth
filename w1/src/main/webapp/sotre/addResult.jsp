<%--
  Created by IntelliJ IDEA.
  User: khan
  Date: 2021/08/06
  Time: 4:04 오후
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String area = request.getParameter("area");
    String desc = request.getParameter("desc");
    String link = request.getParameter("link");
%>



<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2><%=name%></h2>
    <h2><%=area%></h2>
    <h2><%=desc%></h2>
    <h2><%=link%></h2>
</body>
</html>
