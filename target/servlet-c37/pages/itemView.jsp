<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Description Page</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
    <center>
    <table border="0" cellpadding="0" cellspacing="10">
        <tr>
            <td valign="top"><p><strong>Name:</strong> ${requestScope.book.name}</p>
                <p><strong>Description:</strong> ${requestScope.book.description}</p>
                <p><strong>Price:</strong> ${requestScope.book.price} dollars</p>
                <p><strong>Author:</strong> ${requestScope.book.author}</p>
            </td>
            <td valign="top">
                <div style="background-color:snow; border-left: 2px solid #ffffff; height: 150px; padding-left: 10px; width: 400px;">
                    <c:if test="${requestScope.book.id == 1}" var="id">
                    <img src="https://images-na.ssl-images-amazon.com/images/I/A1a-wgltdoL.jpg" width="300" height="500">
                    </c:if>
                    <c:if test="${requestScope.book.id == 2}" var="id">
                        <img src="https://m.media-amazon.com/images/I/51u4rdQeBlL.jpg" width="300" height="500">
                    </c:if>
                    <c:if test="${requestScope.book.id == 3}" var="id">
                        <img src="https://images-na.ssl-images-amazon.com/images/I/91HHqVTAJQL.jpg" width="300" height="500">
                    </c:if>
                        <c:if test="${requestScope.book.id == 4}" var="id">
                            <img src="https://images-na.ssl-images-amazon.com/images/I/51aHYpRqWvL._SX258_BO1,204,203,200_.jpg" width="300" height="500">
                        </c:if>
                            <c:if test="${sessionScope.user != null}">
                                <form action="/basket" method="post">
                                    <input type="hidden" name="id" value="${requestScope.book.id}">
                                    <button>Add To Cart</button>
                                </form>
                            </c:if>
                </div>
            </td>
        </tr>
    </table>
    </center>
</div>
</body>
</html>
