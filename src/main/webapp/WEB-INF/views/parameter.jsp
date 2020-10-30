<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link
            rel="stylesheet"
            href="./assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
    />
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/gh/creativetimofficial/tailwind-starter-kit/compiled-tailwind.min.css"
    />

    <title>User profile</title>
</head>

<body class="text-gray-800 antialiased">
<jsp:include flush="true" page="./fragments/header.jsp"/>
<main class="profile-page">
    <section class="relative block" style="height: 500px;">
        <div
                class="absolute top-0 w-full h-full bg-center bg-cover"
                style='background-image: url("./assets/img/header-profil.jpg");'
        >
        </div>
        <div
                class="top-auto bottom-0 left-0 right-0 w-full absolute pointer-events-none overflow-hidden"
                style="height: 70px; transform: translateZ(0px);"
        >
            <svg
                    class="absolute bottom-0 overflow-hidden"
                    xmlns="http://www.w3.org/2000/svg"
                    preserveAspectRatio="none"
                    version="1.1"
                    viewBox="0 0 2560 100"
                    x="0"
                    y="0"
            >
                <polygon
                        class="text-gray-300 fill-current"
                        points="2560 0 2560 100 0 100"
                ></polygon>
            </svg>
        </div>
    </section>
    <section class="relative py-16 bg-gray-300">
        <div class="container mx-auto px-4">
            <div
                    class="relative flex flex-col min-w-0 break-words bg-white w-full mb-6 shadow-xl rounded-lg -mt-64"
            >
                <div class="px-6">
                    <div class="flex flex-wrap justify-center">
                        <div
                                class="w-full lg:w-3/12 px-4 lg:order-2 flex justify-center"
                        >
                            <div class="relative">
                                <img
                                        alt="..."
                                        src="./assets/img/goat.png"
                                        class="shadow-xl rounded-full h-auto align-middle border-none absolute -m-16 -ml-20 lg:-ml-16"
                                        style="max-width: 150px;"
                                />
                            </div>
                        </div>
                        <div
                                class="w-full lg:w-4/12 px-4 lg:order-3 lg:text-right lg:self-center"
                        >
                        </div>
                        <div class="w-full lg:w-4/12 px-4 lg:order-1">
                            <div class="flex justify-center py-4 lg:pt-4 pt-8">
                                <div class="mr-4 p-3 text-center">
                      <span
                              class="text-xl font-bold block uppercase tracking-wide text-gray-700"
                      >${nbrQuestions}</span
                      ><span class="text-sm text-gray-500">Questions</span>
                                </div>
                                <div class="mr-4 p-3 text-center">
                      <span
                              class="text-xl font-bold block uppercase tracking-wide text-gray-700"
                      >${nbrAnswers}</span
                      ><span class="text-sm text-gray-500">Answer</span>
                                </div>
                                <div class="lg:mr-4 p-3 text-center">
                      <span
                              class="text-xl font-bold block uppercase tracking-wide text-gray-700"
                      >${nbrComments}</span
                      ><span class="text-sm text-gray-500">Comments</span>
                                </div>
                            </div>
                        </div>
                    </div>
            <div class="text-center mt-12">
                <h3 class="text-4xl font-semibold leading-normal mb-2 text-gray-800 mb-2">
                    ${currentUser.firstname} ${currentUser.lastname}
                </h3>
                <h4 class="title">${currentUser.username}</h4>
                <div
                        class="text-sm leading-normal mt-0 mb-2 text-gray-500 font-bold uppercase"
                >
                    ${currentUser.email}
                </div>
            </div>

            <div>
                <form action="./profile.do" method="POST">
                    <h1>
                        Change Firstname:
                    </h1>
                    <input name="newFirstname" id="newFirstname" class="form-control" placeholder="${currentUser.firstname}">
                    <h1>
                        Change Lastname:
                    </h1>
                    <input name="newLastname" id="newLastname" class="form-control" placeholder="${currentUser.lastname}">
                    <h1>
                        Change Email:
                    </h1>
                    <input name="newEmail" id="newEmail" class="form-control" placeholder="${currentUser.email}">
                    <h1>
                        Change Password:
                    </h1>
                    <input type="password" name="newClearTextPassword" id="newClearTextPassword" class="form-control" placeholder="New password">
                    <button>
                        Validate
                    </button>
                </form>
                <c:forEach var="error" items="${errors}">
                    <div class="error">${error}</div>
                </c:forEach>
            </div>
</body>
</html>
