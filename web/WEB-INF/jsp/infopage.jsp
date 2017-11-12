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
    <title>Info Page</title>
</head>
<body>
<header>
    <a href="FrontController?command=go_to_main_page">
        <div>Main Page</div>
    </a>
</header>

<c:if test="${requestScope.person != null}">

    <table border="3" frame="border">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Mobile Phone</th>
            <th>Email</th>
        </tr>
        <tr>
            <td><c:out value="${requestScope.person.id}"/></td>
            <td><c:out value="${requestScope.person.name}"/></td>
            <td><c:out value="${requestScope.person.surname}"/></td>
            <td><c:out value="${requestScope.person.mobilePhoneNumber}"/></td>
            <td><c:out value="${requestScope.person.email}"/></td>
        </tr>
    </table>
</c:if>
<c:if test="${requestScope.person == null}">
    <p>There is no such person in database</p>
</c:if>
</body>
</html>
