<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
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
    <title>Welcome to StackOverGoat</title>
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
                style='background-image: url("./assets/img/header-profil.jpg");'
        >
        </div>
    </section>
    <section class="relative py-16 bg-gray-300">
        <div class="container mx-auto px-4">
            <div class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64" >
                <div class="px-6">
                    <div class="text-center mt-12">
                        <!-- message bienvenue -->
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

                        <!-- debut carte -->
                        <c:forEach var="question" items="${questions.questions}">
                            <div class="w-full lg:w-5/5 rounded-lg lg:rounded-l-lg lg:rounded-r-l shadow-md bg-white opacity-100 mx-6 lg:mx-0" style="margin:15px 15px 15px 15px;">
                                <div class="p-4 md:p-12 ">
                                    <a href="/question?id=${question.id}" class="a">
                                        <h1 class="text-2xl font-bold pt-8 lg:pt-0">${question.text}</h1>
                                    </a>
                                    <hr style="margin:15px 15px 15px 15px;">
                                    <p class="text-black leading-none" style="margin:10px 30px 10px 10px;">${question.author}</p>
                                </div>
                            </div>
                        </c:forEach>
                        <!-- fin carte -->
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>
</body>
</html>
