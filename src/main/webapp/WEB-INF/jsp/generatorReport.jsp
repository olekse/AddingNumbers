<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Please configure executor</title>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
    Generated values: <strong>[
        <c:forEach items="${generatedData}" var="item">
                ${item.asString()}
        </c:forEach>]</strong><br>
    <br>
    <a href="/executor/configuration" class="link-button">Go to operation selection</a>
</div>
</body>
</html>