<%@ page language="java" pageEncoding="UTF-8" %>
<%
//    String version = .toString();
//    System.out.println(System.getProperties("user.dir"));
//    String version = "123";
    String version = System.getProperty("java.version");
    String dir = System.getProperty("user.dir");
%>
<html>
<body>
<h2>Hello World4!</h2>
dir: <%=dir%> <br>
version: <%=version%>
</body>
</html>
