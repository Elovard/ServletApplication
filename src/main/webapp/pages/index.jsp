<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Index</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="container">
	<ul>
		<h2>Our Book Collection: </h2>
		<c:forEach items="${requestScope.items}" var="item">
		<br>
		<li><a href="/item/view?id=${item.id}"><strong>${item.name}</strong></a></li>
			<br>
			<div class="card" style="width: 18rem;">
				<c:if test="${item.id == 1}" var="id">
					<img src="https://images-na.ssl-images-amazon.com/images/I/A1a-wgltdoL.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h3 class="card-title">${item.name}</h3>
						<p class="card-text">${item.description}</p>
						<br>
						<a href="/item/view?id=${item.id}" class="btn btn-primary">Take a look</a>
						<br>
						<br>
					</c:if>
						<c:if test="${item.id == 2}" var="id">
						<img src="https://m.media-amazon.com/images/I/51u4rdQeBlL.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h3 class="card-title">${item.name}</h3>
							<p class="card-text">${item.description}</p>
							<br>
							<a href="/item/view?id=${item.id}" class="btn btn-primary">Take a look</a>
							<br>
							<br>
						</c:if>
							<c:if test="${item.id == 3}" var="id">
							<img src="https://images-na.ssl-images-amazon.com/images/I/91HHqVTAJQL.jpg" class="card-img-top" alt="...">
							<div class="card-body">
								<h3 class="card-title">${item.name}</h3>
								<p class="card-text">${item.description}</p>
								<br>
								<a href="/item/view?id=${item.id}" class="btn btn-primary">Take a look</a>
								<br>
								<br>
							</c:if>
								<c:if test="${item.id == 4}" var="id">
								<img src="https://images-na.ssl-images-amazon.com/images/I/51aHYpRqWvL._SX258_BO1,204,203,200_.jpg" class="card-img-top" alt="...">
								<div class="card-body">
									<h3 class="card-title">${item.name}</h3>
									<p class="card-text">${item.description}</p>
									<br>
									<a href="/item/view?id=${item.id}" class="btn btn-primary">Take a look</a>
									<br>
									<br>
									</c:if>
				</div>
		</c:forEach>
	</ul>
</div>
</body>
</html>
