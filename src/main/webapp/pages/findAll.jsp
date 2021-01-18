<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Find All</title>
</head>
<body>

<jsp:include page="_header.jsp"/>
<div class="container">
	<ul>
		<c:forEach items="${requestScope.users}" var="user">
			<li>${user.name}</li>
		</c:forEach>
	</ul>
</div>
</body>
</html>
