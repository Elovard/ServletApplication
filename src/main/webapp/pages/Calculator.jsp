<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/calc" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">firstNum</label>
        <input type="number" value="${requestScope.firstNum}" name="firstNum" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label for="exampleInputEmail2" class="form-label">secondNum</label>
        <input type="number" value="${requestScope.secondNum}" name="secondNum" class="form-control" id="exampleInputEmail2" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">${requestScope.message}</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Operation</label>
        <input type="text" value="${requestScope.operation}" name="operation" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Calculate</button>
</form>
<br>
${requestScope.messageZero}
${requestScope.messageNoOperation}
${requestScope.messageWrongNumber}
${requestScope.result}
</body>
</html>
