<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <p>Name ${requestScope.book.name}</p>
    <p>Description ${requestScope.book.description}</p>
    <p>Price ${requestScope.book.price}</p>
<c:if test="${sessionScope.user != null}">
    <form action="/basket" method="post">
        <input type="hidden" name="id" value="${requestScope.book.id}">
        <button>Add</button>
    </form>
</c:if>
</div>
</body>
</html>
