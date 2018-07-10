<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login & registration</title>
</head>
<body>
<c:url var="Login" value="login.jsp">
</c:url>
<a href="<c:out value="${Login}"/>">Login</a><br>
<c:url var="Registration" value="registration.jsp">
</c:url>
<a href="<c:out value="${Registration}"/>">Registration</a>

</body>
</html>
