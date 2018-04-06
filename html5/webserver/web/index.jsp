<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/4/6
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Access-Control-Allow-Origin", "*");
    response.setContentType("text/event-stream; charset=utf-8");
    PrintWriter out1 = null;
    try {
        out1 = response.getWriter();
        while (true) {
            String jsonStr = "data:{code:0, \"message\":\"" + new Date().toString() + "\"}";
            out1.write("event:myevent");
            out1.write("\n");
            out1.write(jsonStr);
            out1.write("\n\n");
            out1.flush();
            Thread.sleep(1000);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
%>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
</body>
</html>
