<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by xiaofeixiong at 2021/8/13 10:12 上午.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello World</title>
  </head>
  <body>
  <h1>Hello World From Struts2</h1>
  <s:form action="hello" method="get">
    <s:textfield name="username" label="username" />
    <s:submit></s:submit>
  </s:form>

  <hr>

  </body>
</html>
