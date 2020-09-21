<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Welcome to StackOverGoat</title>
    </head>
    <body>
    <h1>Welcome to StackOverGoat <3</h1>

    <h2> All questions </h2>
    ${requestScope.questions.title}

    </body>
</html>