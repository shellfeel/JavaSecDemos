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
  <form action="hello.action" method="get">
    <label for="name">Please enter your name</label><br/>
    <input type="text" name="userName" id="name"/>
    <input type="submit" value="Say Hello"/>
  </form>

  <hr>
  <form action="upload" method="post" enctype="multipart/form-data">
    <label for="myFile">Upload your file</label>
    <input type="file" name="myFile" id="myFile" />
    <input type="submit" value="Upload"/>

  </form>
  </body>
</html>
