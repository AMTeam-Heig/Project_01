<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <link rel="stylesheet" href="css/stylesheet.css">
</head>
<html>
    <header>
        <title>Welcome to StackOverGoat</title>
    </header>
    <body>
    <center><h1>- StackOverGoat -</h1></center>

    <h2> All questions </h2>
    ${requestScope.questions.title}

    </body>
</html>