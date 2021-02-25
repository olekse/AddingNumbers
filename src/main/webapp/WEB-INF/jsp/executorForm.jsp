<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Please configure executor</title>
    <style>
        .error{
            color: red;
        }
        input[type=submit] {
          background-color: #4CAF50;
          color: white;
          padding: 12px 20px;
          border: none;
          border-radius: 4px;
          cursor: pointer;
        }

        input[type=submit]:hover {
          background-color: #45a049;
        }
        .container {
          border-radius: 5px;
          background-color: #f2f2f2;
          padding: 20px;
        }
    </style>
</head>
<body>
<div class="container">
           <form:form action="submitForm" modelAttribute="configuration">
                   Operation:
                   <br><form:radiobutton path="operation" value="add"/>Add
                   <br><form:radiobutton path="operation" value="multiply"/>Multiply
                   <br><form:errors path="operation" cssClass="error"/>
                   <br>Sources:
                   <br><form:checkbox path="sources" value="localRandom"/>Locally generated Random Number
                   <br><form:checkbox path="sources" value="remoteDatabase"/>Number from database
                   <br><form:checkbox path="sources" value="remoteRandom"/>Random.org
                   <br><form:errors path="sources" cssClass="error"/>
                   <br>
                   <input type="submit" value="Submit" />
               </form:form>
</div>
</body>
</html>

