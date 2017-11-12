<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/09/2017
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<header>
    <h1>MAIN</h1>
</header>
    <form action="FrontController" method="get">
        <input type="hidden" name="command" value="get_info"/>
        <p>Type name</p>
        <input type="text" name="name" value=""/>
        <p>Type surname</p>
        <input type="text" name="surname" value=""/>
        <br>
        <input type="submit" value="get info"/>
    </form>
</body>
</html>
