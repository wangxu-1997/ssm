<%--
  Created by IntelliJ IDEA.
  User: 18366
  Date: 2021/3/27
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查询所有账户</h2>
<c:forEach items="${list}" var="account">
    ${account.name}
</c:forEach>
</body>
</html>
