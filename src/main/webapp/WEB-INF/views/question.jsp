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
    <link
            rel="apple-touch-icon"
            sizes="76x76"
            href="./assets/img/apple-icon.png"
    />
    <link rel="stylesheet" href="./assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/creativetimofficial/tailwind-starter-kit/compiled-tailwind.min.css"
    />
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <lin
    <title>Question</title>
</head>
<body class="text-gray-800 antialiased">

<div align="center">
    <c:forEach var="error" items="${errors}">
        <div class="error">${error}</div>
    </c:forEach>
</div>

<jsp:include flush="true" page="./fragments/header.jsp"/>

<main class="profile-page">
    <section class="relative block" style="height: 500px;">
        <div
                class="absolute top-0 w-full h-full bg-center bg-cover"
                style='background-image: url("https://images.unsplash.com/photo-1499336315816-097655dcfbda?ixlib=rb-1.2.1&amp;ixid=eyJhcHBfaWQiOjEyMDd9&amp;auto=format&amp;fit=crop&amp;w=2710&amp;q=80");'
        >
          <span
                  id="blackOverlay"
                  class="w-full h-full absolute opacity-50 bg-black"
          ></span>
        </div>

    </section>
    <section class="relative py-16 bg-gray-300">
        <div class="container mx-auto px-4">
            <div
                    class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64"
            >
                <div class="px-6">
                    <div class="text-center mt-12">
                        <div class="w-full lg:w-5/5 rounded-lg lg:rounded-l-lg lg:rounded-r-l shadow-md bg-white opacity-100 mx-6 lg:mx-0" style="margin:5px 5px 5px 5px;">
                            <div class="p-4 md:p-12 ">
                                <h1 class="text-2xl font-bold pt-8 lg:pt-0">${question.text}</h1>

                                <p class="text-black leading-none" style="margin:10px 30px 10px 10px;">${question.author}</p>
                                <p style="margin:10px 30px 10px 10px;">234 Votes</p>
                                <hr style="margin:15px 15px 15px 15px;">



                                <div class="flex h-screen md:-mx-4">
                                    <div class="w-full my-4">
                                        <div x-data={show:false} class="rounded-sm">
                                            <div class="border border-b-0 bg-gray-100 px-10 py-6" id="headingOne">
                                                <a @click="show=!show">
                                                    <button class="text-green-500 hover:text-green-700 focus:outline-none" type="button">
                                                        <h3 class="text-3xl font-semibold leading-normal mb-2">
                                                            Comments
                                                        </h3>
                                                    </button>
                                                </a>
                                            </div>
                                            <div x-show="show" class="border border-b-0 px-10 py-6" align="justify">
                                                <c:if test="${currentUser != null}">
                                                    <form action="./submitQuestionComment.do" method="POST" accept-charset="utf-8">
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
                                                    <div>
                                                        <div style="border-radius:25px 25px 25px 25px; background:#d7d7d7; padding:15px 15px 15px 15px;">
                                                                ${comment.comment}
                                                        </div>
                                                        <div align="right" style="padding:5px 45px 5px 15px;">
                                                                ${comment.author}
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="w-full lg:w-5/5 rounded-lg lg:rounded-l-lg lg:rounded-r-l shadow-md bg-white opacity-100 mx-6 lg:mx-0" style="margin:5px 5px 5px 5px;">
                            <div class="p-4 md:p-12 ">
                                <h1 class="text-2xl font-bold pt-8 lg:pt-0">THIS IS A FUCKING QUESTION, NEED ANSWER !!!</h1>
                                <p style="margin:10px 30px 10px 10px;">${question.author}</p>
                                <p style="margin:10px 30px 10px 10px;">234 Votes</p>
                                <hr style="margin:15px 15px 15px 15px;">
                                <p class="text-sm">Totally optional short description about yourself, what you do and so on. Totally optional short description about yourself, what you do and so on. Totally optional short description about yourself, what you do and so on. Totally optional short description about yourself, what you do and so on. Totally optional short description about yourself, what you do and so on. </p>
                                <form action="/submitQuestionVote.do" method="POST">
                                    <input name="questionId" type="hidden" value="${question.id}">
                                    <input name="vote" type="hidden" value="DOWN">
                                    <input type="submit" value="-" />
                                </form>
                                <form action="/submitQuestionVote.do" method="POST">
                                    <input name="questionId" type="hidden" value="${question.id}">
                                    <input name="vote" type="hidden" value="UP">
                                    <input type="submit" value="+" />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

</body>
</html>
