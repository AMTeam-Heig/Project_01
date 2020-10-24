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
        <div>
            <h3> Author : ${question.author}</h3>
        </div>
        <c:if test="${currentUser != null}">
            <form action="./submitQuestionComment.do" method="POST">
                <div class="form-group">
                    <input name="comment" type="text" class="form-control" id="commentQ" placeholder="comment the question !">
                    <small id="askHelpQ" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small>
                </div>
                <input id="questionIdQ" name="questionId" type="hidden" value="${question.id}">
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </c:if>

        <c:if test="${currentUser != null}">
            <form action="./submitAnswer.do" method="POST">
                <div class="form-group">
                    <input name="answer" type="text" class="form-control" id="answerQ" placeholder="answer the question !">
                    <small id="askHelpA" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small>
                </div>
                <input id="questionIdA" name="questionId" type="hidden" value="${question.id}">
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </c:if>
        <div>
            <h3> Comments </h3>
        </div>
        <c:forEach var="comment" items="${question.comments}">
            <div>
                    ${comment.comment}
                <br>
                <i>Commented by ${comment.author}</i>
            </div>
        </c:forEach>
        <div>
            <h3> Answers </h3>
        </div>
        <c:forEach var="answer" items="${answers.answers}">
            <div>
                <a href="#" class="a">
                    <div style="background: #c9f1df; padding: 5px 5px 5px 5px;">
                    <b>${answer.author}</b> says :
                    </div>
                </a>
                <div style="background: #f9f9f9; padding: 5px 5px 5px 5px;">
                    <p> ${answer.text}</p>
                </div>

                <c:if test="${currentUser != null}">
                <form action="./submitAnswerComment.do" method="POST">
                    <div class="form-group">
                        <input name="comment" type="text" class="form-control" id="commentA" placeholder="comment the answer !">
                        <small id="askHelp" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small>
                    </div>
                    <input id="answerId" name="answerId" type="hidden" value="${answer.id}">
                    <input id="questionId" name="questionId" type="hidden" value="${question.id}">
                    <div style="text-align: center;">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </form>
                </c:if>

                <c:forEach var="comment" items="${answer.comments}">
                    <div>
                        ${comment.comment}
                        <br>
                            <i>Commented by ${comment.author}</i>
                    </div>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
