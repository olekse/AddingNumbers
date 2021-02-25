<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report</title>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${reportObject.isSuccess()}">
            <h3>Successful operation.</h3> Result: ${reportObject.getResult().asString()}
        </c:when>
        <c:otherwise>
            Operation failed!
        </c:otherwise>
    </c:choose>
    <br>
    Operands: <strong>[
    <c:forEach items="${reportObject.getOperands()}" var="item">
            ${item.asString()}
    </c:forEach>]</strong><br>
    Operator: ${reportObject.getOperator()}<br><br>
    <a href="/" class="link-button">Back to home page</a>
</div>
</body>
</html>