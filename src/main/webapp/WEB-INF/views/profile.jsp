<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link href="./assets/css/bootstraps/bootstrap.css" rel="stylesheet">
    <link href="./assets/css/awesomeFonts.css" rel="stylesheet">
    <link href="./assets/css/profile.css" rel="stylesheet">


    <title>User profile</title>
</head>
<nav class="navbar-header">
    <jsp:include flush="true" page="./fragments/header.jsp"/>
</nav>
<body>

<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="our-team">
                <div class="picture">
                    <img class="img-fluid" src="./assets/img/goat.png">
                </div>
                <div class="team-content">
                    <h3 class="name">${currentUser.firstname} ${currentUser.lastname}</h3>
                    <h4 class="title">${currentUser.username}</h4>
                    ${currentUser.email}
                </div>
            </div>
        </div>
    </div>
</div>

<div class="card-group">
    <div class="card" style="padding: 15px; margin: 10px; border-radius: 15px;">
<h2>My questions</h2>
<c:forEach var="question" items="${questions.questions}">
    <div class="question-group">
        <p>
            <a href="/question?id=${question.id}" class="a">${question.text}</a>
        </p>
        Up votes : ${question.nbrUpVotes}
        Down votes : ${question.nbrDownVotes}

        <form action="./removeQuestion.do" method="POST">
            <input name="questionId" type="hidden" value="${question.id}">
            <input name="userId" type="hidden" value="${currentUser.id}">
            <button type="submit" class="btn btn-secondary">Remove</button>
        </form>
    </div>
</c:forEach>
    </div>

    <div class="card" style="padding: 15px; margin: 10px; border-radius: 15px;">
<h2>My answers</h2>
<c:forEach var="answer" items="${answers.answers}">
    <div class="answer-group">
        <p>
            <a href="/question?id=${answer.idQuestion}" class="a">${answer.text}</a>
        </p>
        Up votes : ${answer.nbrUpVotes}
        Down votes : ${answer.nbrDownVotes}

        <form action="./removeAnswer.do" method="POST">
            <input name="answerId" type="hidden" value="${answer.id}">
            <input name="userId" type="hidden" value="${currentUser.id}">
            <button type="submit" class="btn btn-secondary">Remove</button>
        </form>
    </div>
</c:forEach>
    </div>
</div>

</body>
</html>
