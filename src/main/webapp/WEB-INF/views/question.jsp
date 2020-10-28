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
    <link href="./assets/css/awesomeFonts.css" rel="stylesheet">

    <title>Welcome to StackOverGoat</title>
</head>
<body>

<jsp:include flush="true" page="./fragments/header.jsp"/>

<div class="card-group">
    <div class="card">
        <!-- QUESTION TITLE -->
        <h1>
            <b>${question.author}</b> asked <i>${question.text}</i>
        </h1>

        Up votes : ${question.nbrUpVotes}
        Down votes : ${question.nbrDownVotes}

        <form action="/submitQuestionVote.do" method="POST">
            <input name="questionId" type="hidden" value="${question.id}">
            <input name="vote" type="hidden" value="DOWN">
            <input type="submit" value="Down Vote :(" />
        </form>
        <form action="/submitQuestionVote.do" method="POST">
            <input name="questionId" type="hidden" value="${question.id}">
            <input name="vote" type="hidden" value="UP">
            <input type="submit" value="Up Vote :)" />
        </form>

        <!-- COMMENTAIRES SUR LA QUESTION -->
        <h2>Comments</h2>
        <c:if test="${currentUser != null}">
            <form action="./submitQuestionComment.do" method="POST">
                <div class="form-group">
                    <input name="comment"
                           type="text"
                           class="form-control"
                           id="commentQ"
                           placeholder="comment the question !" align="center">
                    <button type="submit" class="btn btn-secondary" style="margin: 15px 15px 15px 15px;">Comment
                    </button>
                    <!--<small id="askHelpQ" class="form-text text-muted">Be respectful, otherwise we'll kill u.</small> -->
                </div>
                <input id="questionIdQ" name="questionId" type="hidden" value="${question.id}">
            </form>
        </c:if>
        <c:forEach var="comment" items="${question.comments}">
            <p>
                <h-comment-and-answer>Commented by ${comment.author}</h-comment-and-answer>
                <br/>
            <p>
                    ${comment.comment}
            </p>


            </p>
        </c:forEach>
        <h2>Answers</h2>
        <c:if test="${currentUser != null}">
            <form action="./submitAnswer.do" method="POST">
                <div class="form-group">
                    <input name="answer" type="text" class="form-control" id="answerQ"
                           placeholder="answer the question !">
                </div>
                <input id="questionIdA" name="questionId" type="hidden" value="${question.id}">
                <div style="text-align: center;">
                    <button type="submit" class="btn btn-secondary" style="margin: 15px 15px 15px 15px;">Submit</button>
                </div></form>
        </c:if>
        <c:forEach var="answer" items="${answers.answers}">
            <div class="answer-group">
                <p>
                    <h-comment-and-answer>Answered by ${answer.author}</h-comment-and-answer>
                    <form action="/submitAnswerVote.do" method="POST">
                        <input name="questionId" type="hidden" value="${question.id}">
                        <input name="answerId" type="hidden" value="${answer.id}">
                        <input name="vote" type="hidden" value="DOWN">
                        <input type="submit" value="Down Vote :(" />
                    </form>
                    <form action="/submitAnswerVote.do" method="POST">
                        <input name="questionId" type="hidden" value="${question.id}">
                        <input name="answerId" type="hidden" value="${answer.id}">
                        <input name="vote" type="hidden" value="UP">
                        <input type="submit" value="Up Vote :)" />
                    </form>
                    <br/>
                <p>
                    ${answer.text}
                </p>
                Up votes : ${answer.nbrUpVotes}
                Down votes : ${answer.nbrDownVotes}

                <c:forEach var="comment" items="${answer.comments}">
                    <p>
                            ${comment.comment}<br/>
                        <h-comment-of-answer>Commented by ${comment.author}</h-comment-of-answer>
                    </p>
                </c:forEach>

                <c:if test="${currentUser != null}">
                    <form action="./submitAnswerComment.do" method="POST">
                        <div class="form-group">
                            <input name="comment" type="text" class="form-control" id="commentA"
                                   placeholder="comment the answer !">
                        </div>
                        <input id="answerId" name="answerId" type="hidden" value="${answer.id}">
                        <input id="questionId" name="questionId" type="hidden" value="${question.id}">
                        <div style="text-align: center;">
                            <button type="submit" class="btn btn-secondary">Submit</button>
                        </div>
                    </form>
                </c:if>
            </div>

        </c:forEach>
    </div>
</div>


</body>
</html>
