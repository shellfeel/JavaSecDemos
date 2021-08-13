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
  <form action="hello" method="post">
    <%--@declare id="name"--%><label for="name">Please enter your name</label><br/>
    <input type="text" name="name"/>
    <input type="submit" value="Say Hello"/>
  </form>
  </body>
</html>
