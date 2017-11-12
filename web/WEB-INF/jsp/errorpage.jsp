<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 11/09/2017
  Time: 5:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Error Page</title>
</head>
<body>
<header>
</header>
    <h1>Sorry, something went wrong :(</h1>
    <p>Problem: <c:out value="${requestScope.message}"/></p>
</body>
</html>
