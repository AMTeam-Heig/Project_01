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
<header>
    <jsp:include flush="true" page="./fragments/header.jsp"/>
</header>


<body>
<div class="card-group">
    <div class="card" style="padding: 5px; margin: 10px; border-radius: 15px;">
        <div style="text-align: right;">
            <form action="/action_page.php">
                <input type="text" placeholder="Search..." name="search">
                <button type="submit" class="btn btn-primary">
                    Search
                </button>
            </form>
        </div>

        <c:if test="${currentUser != null}">
        <div style="text-align: center;">
            <h2>
                <c:if test="${currentUser.username != null}">
                    Welcome ${currentUser.username} !
                </c:if>
                <c:if test="${currentUser.username == null}">
                    Welcome stranger !
                </c:if>
            </h2>
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
                <div style="background: #c9f1df; padding: 5px 5px 5px 5px;"><b>${question.author}</b> asked :</div>
                <div style="background: #f9f9f9; padding: 5px 5px 5px 5px;">
                    <p> ${question.text}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
