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
           <form:form action="/executor/report" modelAttribute="executorConfiguration">
                   <br>Select how data should be processed:
                   <br>
                   <br><form:radiobutton path="operation" value="add"/>Add
                   <br><form:radiobutton path="operation" value="multiply"/>Multiply
                   <br><form:errors path="operation" cssClass="error"/>
                   <br>
                   <input type="submit" value="Select" />
               </form:form>
</div>
</body>
</html>

