<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2021/2/16
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>首页</h1>
    <p>欢迎你：${sessionScope.get("user")}</p>
    <a href="/toUpload">上传文件</a>
    <a href="/success">测试在线</a>
    <a href="/logout">注销</a>
</body>
</html>
