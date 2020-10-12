<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="./assets/css/bootstraps/bootstrap.css" rel="stylesheet">

    <title>Welcome to StackOverGoat</title>
</head>
<body>

<jsp:include flush="true" page="./fragments/header.jsp"/>

<div class="card-group">
    <div class="card" style="padding: 5px; margin: 10px; border-radius: 15px;">
        <div style="text-align: center;"><h2> ${question.text}</h2></div>
        <c:forEach var="answer" items="${questions.answers}">
            <div>
                <a href="#" class="a"><div style="background: #c9f1df; padding: 5px 5px 5px 5px;">
                    <b>${answer.author}</b> asked :
                </div></a>
                <div style="background: #f9f9f9; padding: 5px 5px 5px 5px;">
                    <p> ${answer.text}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
