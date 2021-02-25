<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Report</title>
    <style>
    .container {
      border-radius: 5px;
      background-color: #f2f2f2;
      padding: 20px;}
      </style>
</head>
<body>
<div class="container">
    <c:choose>
        <c:when test="${reportObject.isSuccess()}">
            Successful operation. Result: ${reportObject.getResult()}
        </c:when>
        <c:otherwise>
            Failed operation.
        </c:otherwise>
    </c:choose>
    <br>
    Operands:${reportObject.getOperands()}<br>
    Operator:${reportObject.getOperator()}<br>
    <a href="/">Back to configuration</a>
</div>
</body>
</html>