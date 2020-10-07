<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/stylesheet.css">
    <link href="./assets/css/bootstrap.css" rel="stylesheet">
    <link href="./style/app.css" rel="stylesheet">
    <link href="./style/login.css" rel="stylesheet">

    <title>Welcome to StackOverGoat</title>
</head>
<html>
<jsp:include flush="true" page="./fragments/header.jsp"/>

<body>
<div style="text-align: center;">
    <c:if test="${currentUser != null}">
        <hr>
        Welcome ${currentUser} !
    </c:if>
</div>
<div class="card-group">

    <div class="card" style="padding: 5px; margin: 10px; border-radius: 15px;">

        <c:if test="${currentUser != null}">
        <div style="text-align: center;">
            <h2>Ask something !</h2>
        </div>
        <p>
        <form action="./submitQuestion.do" method="POST">
            <div class="form-group">
                <input name="text" type="text" class="form-control" id="ask" placeholder="ask something !">
                <small id="askHelp" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small>
            </div>
            <div style="text-align: center;">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
        </p>
        </c:if>

        <div style="text-align: center;"><h2>Questions</h2></div>
        <c:forEach var="question" items="${questions.questions}">
            <div>
                <div style="background: #b1dfbb; padding: 5px 5px 5px 5px;"><b>${question.author}</b> asked :</div>
                <div style="background: #f9f9f9; padding: 5px 5px 5px 5px;">
                    <p> ${question.text}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
