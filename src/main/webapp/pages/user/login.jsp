<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<c:out value="${sessionScope.message}"/>
<form action="${pageContext.request.contextPath}/login" method="get">
    Name:<br>
    <input type="text" name="name"/> <br>
    Password:<br>
    <input type="password" name="password"> <br><br>
    <input type="submit" value="login" >
</form>
</body>
</html>
