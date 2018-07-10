<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="get">
    Login:<br>
    <input type="text" name="login"/> <br>
    Password:<br>
    <input type="password" name="password"> <br><br>
    <input type="submit" value="login" ><br><br>
    <c:out value="${sessionScope.message}"/>
</form>
</body>
</html>
