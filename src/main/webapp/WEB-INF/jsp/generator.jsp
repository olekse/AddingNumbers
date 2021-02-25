<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Please configure executor</title>
    <link href="/css/style.css" rel="stylesheet"/>
</head>
<body>
<div class="container">
           <form:form action="/generator/report" modelAttribute="sourcesConfiguration">
                   <br>Sources:
                   <br><form:checkbox path="sources" value="localRandom"/>Simple Random Integer
                   <br><form:checkbox path="sources" value="remoteDatabase"/>Integer from a random database row
                   <br><form:checkbox path="sources" value="remoteRandom"/>Random Integer from Random.org
                   <br><form:checkbox path="sources" value="randomUuid"/>Random UUID (String)
                   <br><form:errors path="sources" cssClass="error"/>
                   <br>
                   <input type="submit" value="Generate" />
               </form:form>
</div>
</body>
</html>