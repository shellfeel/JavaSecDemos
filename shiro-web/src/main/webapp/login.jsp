<%@ page import="org.apache.shiro.subject.Subject" %>
<%@ page import="org.apache.shiro.SecurityUtils" %><%--
  Created by xiaofeixiong at 2021/2/18 10:45 上午.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Subject subject = SecurityUtils.getSubject();
    boolean isLogin = subject.isAuthenticated();
    System.out.println("isLogin:" + isLogin);
    if (isLogin){
        response.setStatus(response.SC_MOVED_TEMPORARILY);
        response.setHeader("Location","sec/no");
    }
%>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/login/doLogin" >

    <label for="user-name-label"> 用户名：&nbsp;</label>
        <input id="user-name-label" name="username" type="text" ><br/>

    <label for="password-label">密码： &nbsp;</label>
        <input id="password-label" name="password" type="password" ><br/>
    <input type="submit" value="登录">

</form>

</body>
</html>
