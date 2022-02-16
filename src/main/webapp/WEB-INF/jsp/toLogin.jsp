<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/2/16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>登录页面</h1>
    <p style="color: red">${sessionScope.get("msg")}</p>
    <form method="post" action="/login">
        <p>姓名：<input type="text" name="username"/></p>
        <p>密码：<input type="password" name="password"/></p>
        <p><input type="submit" value="确定">
            <input type="reset" value="取消"></p>
    </form>

</body>
</html>
