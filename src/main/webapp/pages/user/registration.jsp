<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="get">
    Login:<br>
    <input type="text" name="login"/> <br>
    Name:<br>
    <input type="text" name="name"/> <br>
    Last Name:<br>
    <input type="text" name="lastName"/> <br>
    Password:<br>
    <input type="password" name="password"> <br>
    Confirm Password:<br>
    <input type="password" name="confirmPassword"> <br><br>
    <input type="submit" value="Registration" ><br><br>
    <c:out value="${sessionScope.message}"/>
</form>
</body>
</html>
