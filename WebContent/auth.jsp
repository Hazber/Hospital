<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename='messages'/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fmt:message key='greetingAuthorization'/>
<form action="${pageContext.request.contextPath}/Controller" method="POST">
    <input type="hidden" name="command" value="authorization">
    <fmt:message key='eMail'/>:<input type="email" name="eMail"><br>
    <fmt:message key='password'/>:<input type="password" name="password"><br>
    <input type="submit" name="authorization" value= "<fmt:message key='login' />" >
</form>
<form action="/Controller" method="POST">
    <input type="radio" name="lang" value="<fmt:message key='ukrainian'/>"/>
    <input type="radio" name="lang" value="<fmt:message key='english'/>"/>
    <input type="hidden" name="command" value="changeLanguage">
    <input type="submit" name="changeLanguage" value="<fmt:message key='changeLanguage'/>">
</form>
</body>
</html>