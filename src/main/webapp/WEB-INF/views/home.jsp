<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="./assets/css/stylesheet.css">
    <title>Welcome to StackOverGoat</title>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="./assets/css/bootstrap.css" rel="stylesheet">
    <link href="./style/app.css" rel="stylesheet">
    <link href="./style/login.css" rel="stylesheet">
    <link href="" rel="stylesheet">

</head>
<html>
<jsp:include flush="true" page="./fragments/header.jsp"/>

<body>
<div style="text-align: center;">
    <h1>- StackOverGoat -</h1>
</div>
<c:if test="${username != null}">
    <hr>
    Welcome ${username} !
</c:if>
<div class="card-group">
    <div class="card">
        <center><h2>Ask something !</h2></center>
        <p>
        <form action="./submitQuestion.do" method="POST">
            <div class="form-group">
                <label for="ask">Your question</label>
                <input name="text" type="text" class="form-control" id="ask" placeholder="ask question">
                <small id="askHelp" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
        </p>
    </div>

    <div class="card">
        <center><h2>Questions</h2></center>
        <c:forEach var="question" items="${questions.questions}">
            <p >${question.text}</p>
        </c:forEach>
    </div>
</div>

</body>
</html>
